package org.synyx.urlaubsverwaltung.core.application.domain;

import com.google.common.base.MoreObjects;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

import org.springframework.data.jpa.domain.AbstractPersistable;

import org.synyx.urlaubsverwaltung.core.person.Person;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 * This class describes an application for leave.
 *
 * @author  Johannes Reuter
 * @author  Aljona Murygina
 */

@Entity
public class Application extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 1234589209309L;

    // One person may own multiple applications for leave
    @ManyToOne
    private Person person;

    // The person that applied the application
    @ManyToOne
    private Person applier;

    // The person that allowed/rejected the application
    @ManyToOne
    private Person boss;

    // The person that cancelled the application
    @ManyToOne
    private Person canceller;

    // Period of holiday
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;

    // Type of holiday, e.g. holiday, special leave, etc.
    @Enumerated(EnumType.STRING)
    private VacationType vacationType;

    // length of day: contains time of day (morning, noon or full day) and value (1.0 or 0.5 - as BigDecimal)
    @Enumerated(EnumType.STRING)
    private DayLength dayLength;

    // For special and unpaid leave a reason is required
    private String reason;

    // Holiday replacement: stands in while the person is on holiday
    @ManyToOne
    @JoinColumn(name = "rep_id")
    private Person holidayReplacement;

    // Address and phone number during holiday
    private String address;

    // Date of applying for leave
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date applicationDate;

    // Date of cancelling an application for leave
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cancelDate;

    // Date of editing (allow or reject) an application for leave
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date editedDate;

    // Last date of sending a reminding email to boss
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date remindDate;

    // State of application (e.g. waiting, allowed, ...)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    // Signature of applicant
    @Column(columnDefinition = "longblob")
    private byte[] signaturePerson;

    // Signature of boss
    @Column(columnDefinition = "longblob")
    private byte[] signatureBoss;

    // team informed about holidays?
    private boolean teamInformed;

    public String getAddress() {

        return address;
    }


    public void setAddress(String address) {

        this.address = address;
    }


    public DateMidnight getApplicationDate() {

        if (this.applicationDate == null) {
            return null;
        }

        return new DateTime(this.applicationDate).toDateMidnight();
    }


    public void setApplicationDate(DateMidnight applicationDate) {

        if (applicationDate == null) {
            this.applicationDate = null;
        } else {
            this.applicationDate = applicationDate.toDate();
        }
    }


    public DateMidnight getCancelDate() {

        if (this.cancelDate == null) {
            return null;
        }

        return new DateTime(this.cancelDate).toDateMidnight();
    }


    public void setCancelDate(DateMidnight cancelDate) {

        if (cancelDate == null) {
            this.cancelDate = null;
        } else {
            this.cancelDate = cancelDate.toDate();
        }
    }


    public DateMidnight getEditedDate() {

        if (this.editedDate == null) {
            return null;
        }

        return new DateTime(this.editedDate).toDateMidnight();
    }


    public void setEditedDate(DateMidnight editedDate) {

        if (editedDate == null) {
            this.editedDate = null;
        } else {
            this.editedDate = editedDate.toDate();
        }
    }


    public Person getApplier() {

        return applier;
    }


    public void setApplier(Person applier) {

        this.applier = applier;
    }


    public Person getBoss() {

        return boss;
    }


    public void setBoss(Person boss) {

        this.boss = boss;
    }


    public Person getCanceller() {

        return canceller;
    }


    public void setCanceller(Person canceller) {

        this.canceller = canceller;
    }


    public DateMidnight getEndDate() {

        if (this.endDate == null) {
            return null;
        }

        return new DateTime(this.endDate).toDateMidnight();
    }


    public void setEndDate(DateMidnight endDate) {

        if (endDate == null) {
            this.endDate = null;
        } else {
            this.endDate = endDate.toDate();
        }
    }


    public DayLength getDayLength() {

        return dayLength;
    }


    public void setDayLength(DayLength dayLength) {

        this.dayLength = dayLength;
    }


    public Person getPerson() {

        return person;
    }


    public void setPerson(Person person) {

        this.person = person;
    }


    public String getReason() {

        return reason;
    }


    public void setReason(String reason) {

        this.reason = reason;
    }


    public Person getHolidayReplacement() {

        return holidayReplacement;
    }


    public void setHolidayReplacement(Person holidayReplacement) {

        this.holidayReplacement = holidayReplacement;
    }


    public byte[] getSignatureBoss() {

        if (signatureBoss == null) {
            return null;
        }

        return Arrays.copyOf(signatureBoss, signatureBoss.length);
    }


    public void setSignatureBoss(byte[] signatureBoss) {

        if (signatureBoss != null) {
            this.signatureBoss = Arrays.copyOf(signatureBoss, signatureBoss.length);
        } else {
            this.signatureBoss = null;
        }
    }


    public byte[] getSignaturePerson() {

        if (signaturePerson == null) {
            return null;
        }

        return Arrays.copyOf(signaturePerson, signaturePerson.length);
    }


    public void setSignaturePerson(byte[] signaturePerson) {

        if (signaturePerson != null) {
            this.signaturePerson = Arrays.copyOf(signaturePerson, signaturePerson.length);
        } else {
            this.signaturePerson = null;
        }
    }


    public DateMidnight getStartDate() {

        if (this.startDate == null) {
            return null;
        }

        return new DateTime(this.startDate).toDateMidnight();
    }


    public void setStartDate(DateMidnight startDate) {

        if (startDate == null) {
            this.startDate = null;
        } else {
            this.startDate = startDate.toDate();
        }
    }


    public ApplicationStatus getStatus() {

        return status;
    }


    public void setStatus(ApplicationStatus status) {

        this.status = status;
    }


    public VacationType getVacationType() {

        return vacationType;
    }


    public void setVacationType(VacationType vacationType) {

        this.vacationType = vacationType;
    }


    public boolean isFormerlyAllowed() {

        return hasStatus(ApplicationStatus.CANCELLED);
    }


    public DateMidnight getRemindDate() {

        if (this.remindDate == null) {
            return null;
        }

        return new DateTime(this.remindDate).toDateMidnight();
    }


    public void setRemindDate(DateMidnight remindDate) {

        if (startDate == null) {
            this.remindDate = null;
        } else {
            this.remindDate = remindDate.toDate();
        }
    }


    public boolean isTeamInformed() {

        return teamInformed;
    }


    public void setTeamInformed(boolean teamInformed) {

        this.teamInformed = teamInformed;
    }


    @Override
    public String toString() {

        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);

        toStringHelper.add("id", getId());
        toStringHelper.add("startDate", getStartDate());
        toStringHelper.add("endDate", getEndDate());
        toStringHelper.add("vacationType", getVacationType());
        toStringHelper.add("dayLength", getDayLength());

        if (getPerson() != null && getApplier() != null && getPerson().equals(getApplier())) {
            toStringHelper.add("person", getPerson());
        } else {
            toStringHelper.add("person", getPerson());
            toStringHelper.add("applier", getApplier());
        }

        if (getBoss() != null) {
            toStringHelper.add("boss", getBoss());
        }

        if (getCanceller() != null) {
            toStringHelper.add("canceller", getCanceller());
        }

        return toStringHelper.toString();
    }


    /**
     * Checks if the application for leave has the given status.
     *
     * @param  status  to be checked
     *
     * @return  {@code true} if the application for leave has the given status, else {@code false}
     */
    public boolean hasStatus(ApplicationStatus status) {

        return getStatus() == status;
    }
}
