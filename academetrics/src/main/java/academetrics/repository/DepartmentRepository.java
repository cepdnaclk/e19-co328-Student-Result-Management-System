package academetrics.repository;

import academetrics.entity.Department;
import academetrics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
