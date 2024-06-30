package academetrics.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    @NotNull
    private String code; // eg: GP106

    @NotNull
    private String name; // Computing

    @NotNull
    @Size(min=1, max=10)
    private int credits; // 3
}
