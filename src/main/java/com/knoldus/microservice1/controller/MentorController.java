package com.knoldus.microservice1.controller;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MentorController {

    /**
     * Retrieves all Mentors from the Postgres database.
     *
     * @return a {@code ResponseEntity<List<Mentor>>} containing
     * a list of all Mentors and an HTTP status of 200 OK.
     */

    @GetMapping("/getMentor")
    ResponseEntity<List<Mentor>> findAllMentors();

    /**
     * Retrieves an Mentor from the Postgres database by its ID.
     *
     * @param id the ID of the Mentor to retrieve.
     * @return a {@code ResponseEntity<Mentor>} containing
     * the retrieved Mentor and an HTTP status of 200 OK.
     * @throws com.knoldus.microservice1.exception.ResourceNotFoundException if the Mentor is not found in the database.
     */

    @GetMapping("/getMentor/{id}")
    ResponseEntity<Mentor> getMentorById(@PathVariable("id") final int id);

    /**
     * Creates a new Mentor in the Postgres database.
     *
     * @param mentor the Mentor to create.
     * @return a {@code ResponseEntity<Mentor>} containing
     * the created Mentor and an HTTP status of 201 CREATED.
     */
    @PostMapping("/addMentor")
    ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor);

    /**
     * Updates an existing Mentor in the Postgres database.
     *
     * @param mentor the Mentor to update.
     * @return a {@code ResponseEntity<Mentor>} containing the
     * updated Mentor and an HTTP status of 200 OK.
     */

    @PutMapping("/updateMentor/{id}")
    ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor, @PathVariable final Integer targetId);

    /**
     * Deletes an existing Mentor
     * from the Postgres database.
     *
     * @param id the ID of the Mentor to delete.
     * @return an HTTP status of 200 OK.
     */
    @DeleteMapping("/deleteMentor/{id}")
    ResponseEntity<String> deleteMentor(@PathVariable final int id);

}
