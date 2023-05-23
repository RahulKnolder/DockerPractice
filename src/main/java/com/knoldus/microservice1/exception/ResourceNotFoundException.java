package com.knoldus.microservice1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not Found");
    }

    /**
     * Constructs a ResourceNotFoundException with
     * the specified detail message.
     * @param message the detail message that provides
     * information about the resource that was not found.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
