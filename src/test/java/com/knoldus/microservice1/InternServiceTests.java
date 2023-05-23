package com.knoldus.microservice1;

import com.knoldus.microservice1.dao.InternsRepository;
import com.knoldus.microservice1.model.Address;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.impl.InternServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class contains the unit tests for the InternServiceImpl class.
 */
@SpringBootTest
public class InternServiceTests {

    @Mock
    InternsRepository internsRepository;

    @InjectMocks
    InternServiceImpl internServiceImpl;

    Interns interns;

    /**
     * This method sets up the Mockito mocks and initializes the Interns object.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interns = new Interns(
                1,
                "Jane",
                1234567890,
                new Address("New York", "123")
        );
    }

    /**
     * This method tests the findInternsByMentor method of the InternServiceImpl class.
     */

    @Test
    public void testFindInternsByMentor() {
        // create a list of interns to be returned by the mock
        List<Interns> internsList = new ArrayList<>(List.of(new Interns(
                1,
                "Jane",
                1234567890,
                new Address("New York", "123")
        ), new Interns(
                2,
                "Rahul",
                1234567890,
                new Address("New York", "123")
        ), new Interns(
                3,
                "sinha",
                1234567890,
                new Address("New York", "123")
        )));

        // set up the mock to return the list of interns
        when(internsRepository.findInternsByMentor(anyInt())).thenReturn(internsList);

        // call the method to be tested
        List<Interns> result = internServiceImpl.findInternsByMentor(1);

        // verify that the mock was called with the correct parameter
        verify(internsRepository).findInternsByMentor(1);

        // assert that the result is the expected list of interns
        assertEquals(3, result.size());
        assertEquals("Jane", result.get(0).getName());
        assertEquals("Rahul", result.get(1).getName());
    }
}
