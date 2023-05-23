package com.knoldus.microservice1.controller.impl;

import com.knoldus.microservice1.controller.MentorController;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorControllerImpl implements MentorController {

    @Autowired
    private MentorService mentorService;

    /**
     * Retrieves all Mentors from the Postgres database.
     *
     * @return a {@code ResponseEntity<List<Mentor>>} containing
     * a list of all Mentors and an HTTP status of 200 OK.
     */
    public ResponseEntity<List<Mentor>> findAllMentors() {
        List<Mentor> listOfMentor = mentorService.findAllMentors();
        return new ResponseEntity<>(listOfMentor, HttpStatus.OK);
    }


    /**
     * Retrieves an Mentor from the Postgres database by its ID.
     *
     * @param id the ID of the Mentor to retrieve.
     * @return a {@code ResponseEntity<Mentor>} containing
     * the retrieved Mentor and an HTTP status of 200 OK.
     * @throws com.knoldus.microservice1.exception.ResourceNotFoundException if the Mentor is not found in the database.
     */
    public ResponseEntity<Mentor> getMentorById(@PathVariable("id") final int id) {
        Mentor mentor = mentorService.getMentorById(id);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    /**
     * Creates a new Mentor in the Postgres database.
     *
     * @param mentor the Mentor to create.
     * @return a {@code ResponseEntity<Mentor>} containing
     * the created Mentor and an HTTP status of 201 CREATED.
     */
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor) {
        mentorService.addMentor(mentor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Updates an existing Mentor in the Postgres database.
     *
     * @param mentor the Mentor to update.
     * @return a {@code ResponseEntity<Mentor>} containing the
     * updated Mentor and an HTTP status of 200 OK.
     */
    public ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor, @PathVariable final Integer id) {
        mentorService.updateMentor(id, mentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    /**
     * Deletes an existing Mentor
     * from the Postgres database.
     *
     * @param id the ID of the Mentor to delete.
     * @return an HTTP status of 200 OK.
     */
    public ResponseEntity<String> deleteMentor(@PathVariable final int id) {
        return mentorService.deleteMentor(id);
    }
}
