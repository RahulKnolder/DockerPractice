package com.knoldus.microservice1.controller;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InternController {

    /**
     * Retrieves a list of Interns based on the given Mentor ID.
     * @param mentorId the ID of the Mentor whose Interns are to be retrieved
     * @return a List of Interns associated with the Mentor ID
     */
    @GetMapping("findInternsByMentorId/{mentorId}")
    List<Interns> findInternsByMentor(@PathVariable Integer mentorId);

    /**
     * Deletes the Intern record with the given ID.
     * @param internId the ID of the Intern to be deleted
     * @return a ResponseEntity with a message indicating success or failure
     */
    @DeleteMapping("deleteIntern/{internId}")
    ResponseEntity<String> deleteIntern(@PathVariable("internId") int internId);

    /**
     * Retrieves the Intern record with the given ID.
     * @param internId the ID of the Intern to be retrieved
     * @return the Intern object associated with the given ID
     */
    @GetMapping("getInternById/{internId}")
    Interns getInternById(@PathVariable final Integer internId);
}
