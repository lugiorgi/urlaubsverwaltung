package org.synyx.urlaubsverwaltung.core.sicknote;

import org.synyx.urlaubsverwaltung.core.application.domain.Application;
import org.synyx.urlaubsverwaltung.core.person.Person;


/**
 * Provides interactions with sick notes, i.e. create, edit etc.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
public interface SickNoteInteractionService {

    /**
     * Creates a new sick note.
     *
     * @param  sickNote  to be saved
     * @param  creator  the person who creates the sick note
     *
     * @return  the saved sick note
     */
    SickNote create(SickNote sickNote, Person creator);


    /**
     * Update an existent sick note.
     *
     * @param  sickNote  to be updated
     * @param  editor  the person who updates the sick note
     *
     * @return  the updated sick note
     */
    SickNote update(SickNote sickNote, Person editor);


    /**
     * Convert a sick note to an allowed application for leave.
     *
     * @param  sickNote  to be converted to vacation
     * @param  application  represents the application for leave that is created
     * @param  converter  the person who converts the sick note
     *
     * @return  the converted sick note
     */
    SickNote convert(SickNote sickNote, Application application, Person converter);


    /**
     * Cancel an existent sick note.
     *
     * @param  sickNote  to be cancelled
     * @param  canceller  the person who cancels the sick note
     *
     * @return  the cancelled sick note
     */
    SickNote cancel(SickNote sickNote, Person canceller);
}
