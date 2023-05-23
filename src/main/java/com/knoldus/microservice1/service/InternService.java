package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InternService {

   /**
    * Method to fetch all the interns belonging to a mentor.
    * @param mentorId the id of the mentor for whom interns need to be fetched.
    * @return List of Interns belonging to the mentor.
    */
   public  List<Interns> findInternsByMentor(Integer mentorId);

   /**
    * Method to delete a specific intern.
    * @param internId the id of the intern to be deleted.
    * @return ResponseEntity with message of successful deletion.
    */
   public ResponseEntity<String> deleteIntern(int internId);

   /**
    * Method to fetch a specific intern by their id.
    * @param internId the id of the intern to be fetched.
    * @return Interns object containing details of the intern.
    */
   public Interns getInternById(Integer internId);

}
