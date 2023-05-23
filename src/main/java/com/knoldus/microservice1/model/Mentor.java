package com.knoldus.microservice1.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentors")
@Transactional
public final class Mentor {

    /**
     * The Id of the mentor in the database
     */
    @Id
    private Integer mentorId;

    /**
     * The Name of the mentor in the database
     */
    @Column
    private String mentorName;

    /**
     * A set of Interns associated with a Mentor.
     * This field represents a one-to-many relationship between a Mentor and a set of Interns.
     * The cascade attribute specifies that any changes made to a Mentor object will be cascaded
     * to the associated Interns objects, allowing for easy synchronization of changes in the database.
     * The JoinColumn annotation specifies the column name of the foreign key in the Interns table
     * that references the primary key of the Mentor table.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Mentor_Fk", referencedColumnName = "mentorId")
    private Set<Interns> interns;
}