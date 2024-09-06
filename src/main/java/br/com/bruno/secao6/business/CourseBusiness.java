package br.com.bruno.secao6.business;

import br.com.bruno.secao6.service.CourseService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// System (Method) Under Test - SUT
public class CourseBusiness {

    private CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursersRelatedToSpring(String student) {
        if (student.equals("Foo Bar")) {
            return Collections.emptyList();
        }

        List<String> allCourses = courseService.retrieveCourses(student);

        return allCourses.stream()
                .filter((c) -> c.contains("Spring"))
                .collect(Collectors.toList());
    }

}
