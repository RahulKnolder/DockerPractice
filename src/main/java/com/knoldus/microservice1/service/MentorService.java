package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MentorService {
    /**
     * Returns a List of all Mentor objects stored in the Postgres database.
     *
     * @return a List of all Mentor objects stored in the Postgres database
     */
//    List<Mentor> getAllMentor();
    public List<Mentor> findAllMentors();

    /**
     * Returns the Mentor object with the specified
     * ID from the Postgres database.
     *
     * @param mentorId the ID of the Mentor object to retrieve
     * @return the Mentor object with the specified ID
     * @throws com.knoldus.microservice1.exception.ResourceNotFoundException if the Mentor object
     * with the specified ID is not found in the database
     */
    Mentor getMentorById(int mentorId);

    /**
     * Saves the given Mentor object to the Postgres database.
     *
     * @param mentor the Mentor object to be saved
     * @return the saved Mentor object
     */
    Mentor addMentor(Mentor mentor);

    /**
     * Updates the given Mentor object in the Postgres database.
     *
     * @param updatedMentor the Mentor object to be updated
     * @return the updated Mentor object
     * @throws com.knoldus.microservice1.exception.ResourceNotFoundException if the Mentor object
     * to be updated is not found in the database
     */
    ResponseEntity<Mentor> updateMentor(final Integer targetID, Mentor updatedMentor);

    /**
     * Deletes the Mentor object with the specified ID
     * from the Postgres database.
     *
     * @param mentorId the ID of the Mentor object to delete
     */

    ResponseEntity<String> deleteMentor(int mentorId);


}
