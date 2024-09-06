package br.com.bruno.secao6.business;

import br.com.bruno.secao6.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseBusinessMockTest {
    
    private CourseService courseService;
    private CourseBusiness courseBusiness;
    private List<String> courses;

    @BeforeEach
    void beforeEach() {
        this.courseService = mock(CourseService.class);
        this.courseBusiness = new CourseBusiness(this.courseService);

        this.courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given / Arrange
        when(courseService.retrieveCourses("Leandro"))
                .thenReturn(this.courses);

        // When / Act;
        List<String> filteredCourses = courseBusiness.retrieveCoursersRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        // Given / Arrange
        when(courseService.retrieveCourses("Foo Bar")).thenReturn(Collections.emptyList());

        // When / Act;
        List<String> filteredCourses = courseBusiness.retrieveCoursersRelatedToSpring("Foo Bar");

        // Then / Assert
        assertEquals(0, filteredCourses.size());
    }

}
