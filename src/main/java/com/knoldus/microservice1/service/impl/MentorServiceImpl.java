package com.knoldus.microservice1.service.impl;

import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.dao.MentorsDBRepository;
import com.knoldus.microservice1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MentorServiceImpl implements MentorService {
    @Autowired
    private MentorsDBRepository postgresDBRepository;

    /**
     * Retrieves a list of all Mentor objects from the Postgres database.
     *
     * @return a List of Mentor objects.
     */
//    @Override
//    public List<Mentor> getAllMentor() {
//        List<Mentor> listOfMentor = new ArrayList<>();
//        postgresDBRepository.findAll().forEach(listOfMentor::add);
//        return listOfMentor;
//    }

    @Override
    public List<Mentor> findAllMentors() {
        return postgresDBRepository.findAllMentors();
    }

    /**
     * Retrieves a Model object from the
     * Postgres database with the given mentorId.
     *
     * @return the retrieved EntityModel object.
     * @throws ResourceNotFoundException if the Mentor
     * object is not found in the database.
     */
    @Override
    public Mentor getMentorById(final int mentorId) {
        Optional<Mentor> optionalMentor = postgresDBRepository.findById(mentorId);
        if (optionalMentor.isPresent()) {
            return optionalMentor.get();
        } else {
            throw new ResourceNotFoundException("Resource not Found");
        }
    }

    /**
     * Adds a Mentor object to the Postgres database.
     *
     * @param mentor the Mentor object to add.
     * @return the added Mentor object.
     */
    @Override
    public Mentor addMentor(Mentor mentor) {
        return postgresDBRepository.save(mentor);
    }

    /**
     * Updates a Mentor object in the Postgres database.
     *
     * @param updatedMentor the Mentor object to update.
     * @return the updated EntityModel object.
     * @throws ResourceNotFoundException if the Mentor
     * object is not found in the database.
     */
    @Override
    public ResponseEntity<Mentor> updateMentor(final Integer targetID , Mentor updatedMentor) {
        Optional<Mentor> optionalMentor = postgresDBRepository.findById(targetID);
        if (optionalMentor.isPresent()) {
          return ResponseEntity.ok(postgresDBRepository.save(updatedMentor));
        } else {
            throw new ResourceNotFoundException("Resource not Found");
        }
    }

    /**
     * Deletes a Mentor object from
     * the Postgres database with the given mentorId.
     *
     * @param mentorId the ID of the Mentor object to delete.
     * @throws ResourceNotFoundException if the EntityModel
     * object is not found in the database.
     */
    @Override
     public ResponseEntity<String> deleteMentor(int mentorId) {

        Optional<Mentor> mentor= postgresDBRepository.findById(mentorId);
        if(mentor.isPresent()){
            postgresDBRepository.delete(getMentorById(mentorId));
           return ResponseEntity.ok("the object has been deleted "+mentorId);
        }
        else {
            throw new ResourceNotFoundException("details not found on particular id ");
        }
    }

}
