package academetrics.service;

import academetrics.dto.CourseDTO;
import academetrics.entity.Course;
import academetrics.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }


    public CourseDTO courseEntityToDTO(Course course){
        // TODO: Remove since outdated function due to use of modelmapper
        /*
        if (course == null) return null;

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());
        courseDTO.setCredits(course.getCredits());

        return courseDTO;
        */
        return modelMapper.map(course, CourseDTO.class);
    }


    public List<CourseDTO> getAllCourses() {
        Iterable<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course : courses) {
            courseDTOList.add(courseEntityToDTO(course));
        }

        return courseDTOList;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCode(courseDTO.getCode());
        course.setName(courseDTO.getName());
        course.setCredits(courseDTO.getCredits());
        // Set other properties manually if needed
        courseRepository.save(course);

        return getCourse(courseDTO.getCode());
    }



    public CourseDTO getCourse(String courseCode) {
        Course course = new Course();
        course = courseRepository.findByCode(courseCode);
        return courseEntityToDTO(course);
    }

/*
    public CourseDTO updateCourse(String courseCode, CourseDTO updatedCourseDTO) {
        Course existingCourse = courseRepository.findByCode(courseCode);
        if (existingCourse != null) {
            existingCourse.setName(updatedCourseDTO.getName());
            existingCourse.setCredits(updatedCourseDTO.getCredits());

            courseRepository.save(existingCourse); // save in the course repo
        }
        else {
            // handling the case where course is not found (courseCode == null)
            throw new RuntimeException("Course not found with code: " + courseCode);
        }
        return updatedCourseDTO;
    }

 */
 /*
    public void deleteCourse(String courseCode) {
        courseRepository.deleteByCode(courseCode);
    }
*/

}

