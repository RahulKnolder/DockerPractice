
/**

 This class represents an embedded object that stores the address details of a user.
 It contains the city name and the sector of the address.
 */

package com.knoldus.microservice1.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    /**
     * The name of the city where the address is located.
     */
    private String cityName;

    /**
     * The sector of the address.
     */
    private String sector;
}
