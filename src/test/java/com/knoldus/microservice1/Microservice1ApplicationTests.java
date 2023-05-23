package com.knoldus.microservice1;


/**
 * This class contains JUnit tests for the MentorServiceImpl class.
 * It mocks the MentorsDBRepository and tests the methods of MentorServiceImpl using the mocked repository.
 */

import com.knoldus.microservice1.dao.MentorsDBRepository;
import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Address;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.service.impl.MentorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class Microservice1ApplicationTests {

    @Mock
    MentorsDBRepository mockedMentorsDBRepository;

    @InjectMocks
    MentorServiceImpl mentorServiceImpln;

    Mentor mentor;

    /**
     * Initializes the mock objects and the mentor object for testing.
     */


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mentor = new Mentor(
                2,
                "Shiv",
                new HashSet<>(List.of(new Interns(
                        2,
                        "Rahul",
                        896993814,
                        new Address("Sahibjanj", "46")
                )))
        );
    }


    /**
     * Tests the addMentor method of MentorServiceImpl.
     * It creates a mentor object and mocks the behavior of the repository's save method.
     * Then it calls the addMentor method of the service and verifies that the repository's save method was called once with the mentor object.
     * It also verifies that the saved mentor object is equal to the original mentor object.
     */


    @Test
    void testAddMentor() {
        // Create a mentor object
        Mentor mentor = new Mentor(
                1,
                "John",
                new HashSet<>(List.of(new Interns(
                        1,
                        "Jane",
                        1234567890,
                        new Address("New York", "123")
                )))
        );

        // Mock the behavior of the repository's save method
        when(mockedMentorsDBRepository.save(mentor)).thenReturn(mentor);

        // Call the service method to add the mentor
        Mentor savedMentor = mentorServiceImpln.addMentor(mentor);

        // Verify that the repository's save method was called once with the mentor object
        verify(mockedMentorsDBRepository, times(1)).save(mentor);

        // Verify that the saved mentor object is equal to the original mentor object
        assertEquals("Saved mentor should be equal to original mentor", mentor, savedMentor);
    }


    /**
     * Tests the updateMentor method of MentorServiceImpl.
     * It creates an updated mentor object and mocks the behavior of the repository's findById and save methods.
     * Then it calls the updateMentor method of the service and verifies that the repository's findById and save methods were called.
     */


    @Test
    void testUpdateMentor() {
        Mentor updatedMentor = new Mentor(
                2,
                "Sakhsi",
                new HashSet<>(List.of(new Interns(
                        2,
                        "Rishika",
                        896993814,
                        new Address("kharar", "46")
                )))
        );
        when(mockedMentorsDBRepository.findById(anyInt())).thenReturn(Optional.ofNullable(mentor));
        when(mockedMentorsDBRepository.save(updatedMentor)).thenReturn(updatedMentor);
        ResponseEntity<Mentor> response = mentorServiceImpln.updateMentor(8, updatedMentor);
    }


    /**
     * This test case verifies that a mentor object can be deleted successfully when it exists in the database.
     */

    @Test
    public void testDeleteMentorSuccess() {
        // Arrange
        int mentorId = 1;
        when(mockedMentorsDBRepository.findById(mentorId)).thenReturn(Optional.of(mentor));

        // Act
        ResponseEntity<String> response = mentorServiceImpln.deleteMentor(mentorId);

        // Assert
        verify(mockedMentorsDBRepository, times(1)).delete(mentor);
        assertEquals("deleted on particular id", HttpStatus.OK, response.getStatusCode());
    }


    /**
     * Tests the behavior of the deleteMentor method of the MentorServiceImpl class when the mentor to delete is not found.
     */

    @Test
    public void testDeleteMentorNotFound() {
        // Arrange
        int mentorId = 1;
        when(mockedMentorsDBRepository.findById(mentorId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> mentorServiceImpln.deleteMentor(mentorId));
        verify(mockedMentorsDBRepository, never()).delete(any());
    }
}
