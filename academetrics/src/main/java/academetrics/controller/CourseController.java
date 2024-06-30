package academetrics.controller;

import academetrics.dto.CourseDTO;
import academetrics.service.CourseService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String courses(Model model){
        List<CourseDTO> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/courses";
    }

    @GetMapping("/new")
    public String newCourse(){
        return "courses/course-form";
    }

    @GetMapping("/course-list")
    public String getCourses(Model model) {

        List<CourseDTO> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/course-list";
    }

    @PostMapping("/")
    public String createCourse(
            // TODO: Add form validation
            CourseDTO courseDTO
            //@Valid CourseDTO courseDTO,
            //BindingResult bindingResult
    ) {
//        if (bindingResult.hasErrors()) {
//            return "courses/";
//        }

        courseService.saveCourse(courseDTO);
        return "redirect:/courses/";
    }

    /*
    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute CourseDTO courseDTO, RedirectAttributes redirectAttributes) {
        courseService.updateCourse(id, courseDTO);
        redirectAttributes.addFlashAttribute("message", "Course updated successfully");
        return "redirect:/courses/";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        courseService.deleteCourse(id);
        redirectAttributes.addFlashAttribute("message", "Course deleted successfully");
        return "redirect:/courses/";
    }

 */
}
