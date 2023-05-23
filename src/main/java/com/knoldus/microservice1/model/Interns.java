package com.knoldus.microservice1.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

/**
 * This class represents an intern in the organization.
 * It contains the intern's ID, name, phone number, and address details.
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Transactional
@Entity
public class Interns {

    /**
     * The ID of the intern.
     */
    @Id
    private Integer internId;

    /**
     * The name of the intern.
     */
    private String name;

    /**
     * The phone number of the intern.
     */
    Integer phoneNumber;

    /**
     * The address of the intern.
     */
    @Embedded
    private Address address;
}
