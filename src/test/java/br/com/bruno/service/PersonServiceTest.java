package br.com.bruno.service;

import br.com.bruno.model.Person;
import br.com.bruno.service.impl.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    private Person person;
    private IPersonService personService;

    @BeforeEach
    void beforeEach() {
        this.personService = new PersonService();
        this.person = new Person("John", "Doe", "Wembley - UK", "Male", "john.doe@gmail.com");
    }

    @Test
    @DisplayName("When Create a Person with Success Should Return a Person Object")
    void testCreatePerson_WhenSuccess_ShouldReturn_PersonObject() {
        // When
        Person actual = personService.createPerson(person);

        // Then
        assertNotNull(actual, "The createPerson() should not have return null");
    }

    @Test
    @DisplayName("When Create a Person with Success Should Contains FirstName in Returned Object")
    void testCreatePerson_WhenSuccess_ShouldContains_CorrectAttributes() {
         // When
        Person actual = personService.createPerson(person);

        // Then
        assertNotNull(actual.getId(), "Person ID is missing");
        assertEquals(person.getFirstName(), actual.getFirstName(), "The FirstName is Incorrect");
        assertEquals(person.getLastName(), actual.getLastName(), "The LastName is Incorrect");
        assertEquals(person.getAddress(), actual.getAddress(), "The address is Incorrect");
        assertEquals(person.getGender(), actual.getGender(), "The gender is Incorrect");
        assertEquals(person.getEmail(), actual.getEmail(), "The email is Incorrect");
    }

}
