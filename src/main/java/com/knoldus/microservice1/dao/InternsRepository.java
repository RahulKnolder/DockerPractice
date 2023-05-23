package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Interns;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Interns data in the database.
 */
@Repository
public interface InternsRepository extends JpaRepository<Interns, Integer> {


    /**
     * Returns a list of all Interns associated with a particular Mentor.
     * @param mentorId the ID of the Mentor
     * @return a list of Interns associated with the specified Mentor
     */
    @Query(
            value = "select * from interns s where s.mentor_fk = ?",
            nativeQuery = true
    )
    List<Interns> findInternsByMentor(Integer mentorId);

}
