package academetrics.controller;

import academetrics.dto.StudentCourseDTO;
import academetrics.dto.StudentDTO;
import academetrics.repository.StudentRepository;
import academetrics.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model){
        double gpa = studentService.getGPA("E/10/001");
        StudentDTO student = studentService.getStudentDetails("E/10/001");
        List<StudentCourseDTO> courses = new ArrayList<>();
        try {
            courses = studentService.getFollowingCourses("E/10/001");
        } catch (Exception ex) {
            ;
        }
        System.out.println(courses);
        model.addAttribute("user", student);
        model.addAttribute("gpa", Math.round(gpa * 100.0) / 100.0);
        model.addAttribute("courses", courses);
        return "index";
    }
}
