package org.synyx.urlaubsverwaltung.core.application.service.exception;

/**
 * Thrown in case the person of an application for leave is too impatient and tries too early to remind the privileged
 * user(s) that they should decide about the application for leave.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
public class ImpatientAboutApplicationForLeaveProcessException extends Exception {

    public ImpatientAboutApplicationForLeaveProcessException(String message) {

        super(message);
    }
}
