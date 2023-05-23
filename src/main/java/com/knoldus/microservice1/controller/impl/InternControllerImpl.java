package com.knoldus.microservice1.controller.impl;

import com.knoldus.microservice1.controller.InternController;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class InternControllerImpl implements InternController {
    @Autowired
    InternService internService;

    private static final Logger logger = LoggerFactory.getLogger(InternControllerImpl.class);

    /**
     * Finds a list of interns by mentor id.
     * @param mentorId the mentor id to search interns for.
     * @return a List of Interns objects.
     */
    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
        logger.info("Finding interns by mentorId: {}", mentorId);
        List<Interns> interns = internService.findInternsByMentor(mentorId);
        logger.info("Found interns: {}", interns);
        return interns;
    }

    /**
     * Deletes an intern with the given intern id.
     * @param internId the id of the intern to be deleted.
     * @return a ResponseEntity object with status 200 and a message if successful, or a message and status 404 if not found.
     */
    @Override
    public ResponseEntity<String> deleteIntern(@PathVariable int internId) {
        logger.info("Deleting intern with internId: {}", internId);
        ResponseEntity<String> response = internService.deleteIntern(internId);
        logger.info("Response from deleteIntern: {}", response);
        return response;
    }

    /**
     * Finds an intern by id.
     * @param internId the id of the intern to be found.
     * @return an Interns object if found, or null if not found.
     */
    @Override
    public Interns getInternById(@PathVariable final Integer internId) {
        logger.info("Finding intern by internId: {}", internId);
        Interns intern = internService.getInternById(internId);
        logger.info("Found intern: {}", intern);
        return intern;
    }
}
