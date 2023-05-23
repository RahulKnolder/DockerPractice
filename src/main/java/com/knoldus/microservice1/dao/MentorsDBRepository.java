package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Mentor data in the database.
 */
@Repository
public interface MentorsDBRepository extends JpaRepository<Mentor, Integer> {

    /**
     * This method returns a list of all the mentors.
     *
     * @return a list of mentors.
     */
    @Query("select m from Mentor m")
    List<Mentor> findAllMentors();

}
