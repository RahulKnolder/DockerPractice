package com.knoldus.microservice1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import lombok.Builder;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {

    /**
     * A message that describes the response.
     */
    private String message;

    /**
     * A boolean value indicating whether the operation was successful.
     */
    private boolean success;


    /**
     * An HTTP status code that describes the result of the operation.
     */
    private HttpStatus status;
}
