package academetrics.controller.api;

import academetrics.dto.CourseDTO;
import academetrics.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseApiController {
    @Autowired
    private CourseService courseService;

    //  Show All Courses
    @GetMapping("/") // Map only GET Requests
    public @ResponseBody List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
}
