/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synyx.urlaubsverwaltung.validator;

import org.springframework.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.synyx.urlaubsverwaltung.domain.DayLength;
import org.synyx.urlaubsverwaltung.domain.VacationType;
import org.synyx.urlaubsverwaltung.view.AppForm;


/**
 * This class validate if an application's form ('AppForm') is filled correctly by the user, else it saves error
 * messages in errors object.
 *
 * @author  Aljona Murygina
 */
public class ApplicationValidator implements Validator {

    private static final String MANDATORY_FIELD = "error.mandatory.field";
    private static final String PERIOD = "error.period";
    private static final String PAST = "error.period.past";

    @Override
    public boolean supports(Class<?> clazz) {

        return AppForm.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {

        AppForm app = (AppForm) target;

        // check if date fields are valid
        if (app.getHowLong() == DayLength.FULL) {
            // check if date fields are not filled
            if (app.getStartDate() == null) {
                errors.rejectValue("startDate", MANDATORY_FIELD);
            }

            if (app.getEndDate() == null) {
                errors.rejectValue("endDate", MANDATORY_FIELD);
            }

            if (app.getStartDate() != null && app.getEndDate() != null) {
                // check if from < to
                if (app.getStartDate().isAfter(app.getEndDate())) {
                    errors.reject(PERIOD);
                }
            }
        } else {
            if (app.getStartDateHalf() == null) {
                errors.rejectValue("startDateHalf", MANDATORY_FIELD);
            }
        }

        // check if reason is not filled
        if (app.getVacationType() != VacationType.HOLIDAY) {
            if (app.getReason() == null || !StringUtils.hasText(app.getReason())) {
                errors.rejectValue("reason", MANDATORY_FIELD);
            }
        }
    }


    /**
     * If a user (or a boss) applies for leave, startDate has to be equal or greater than now(). The office is able to
     * apply for leave for someone else and may apply for past too.
     *
     * @param  target
     * @param  errors
     */
    public void validateForUser(Object target, Errors errors) {

        AppForm app = (AppForm) target;

        // check if given dates are valid
        if (app.getHowLong() == DayLength.FULL) {
            if (app.getStartDate() != null) {
                if (app.getStartDate().isBeforeNow()) {
                    errors.rejectValue("startDate", PAST);
                }
            }
        } else {
            if (app.getStartDateHalf() != null) {
                if (app.getStartDateHalf().isBeforeNow()) {
                    errors.rejectValue("startDateHalf", PAST);
                }
            }
        }
    }
}