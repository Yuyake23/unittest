package br.com.bruno.secao6.business;

import br.com.bruno.secao6.service.CourseService;
import br.com.bruno.secao6.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given / Arrange
        CourseService courseService = new CourseServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(courseService);

        // When / Act;
        List<String> filteredCourses = courseBusiness.retrieveCoursersRelatedToSpring("Leandro");

        // Then / Assert
        Assertions.assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        // Given / Arrange
        CourseService courseService = new CourseServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(courseService);

        // When / Act;
        List<String> filteredCourses = courseBusiness.retrieveCoursersRelatedToSpring("Foo Bar");

        // Then / Assert
        Assertions.assertEquals(0, filteredCourses.size());
    }

}
