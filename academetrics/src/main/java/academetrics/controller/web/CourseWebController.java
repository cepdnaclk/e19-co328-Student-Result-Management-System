package academetrics.controller.web;

import academetrics.dto.CourseDTO;
import academetrics.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseWebController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String courses(Model model){
        List<CourseDTO> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/courses";
    }
}
