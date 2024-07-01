package academetrics.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCourseDTO {
    String grade;
    CourseOfferingDTO courseOffering;
    List<StudentAssesmentDTO> assesments= new ArrayList<>();
}
