package academetrics.repository;

import academetrics.entity.Assesment;
import academetrics.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssesmentRepository extends JpaRepository<Assesment, Integer> {

    Assesment findByAssesId(Integer id);
    void deleteByAssesId(Integer id);

    Iterable<Assesment> findAllByCourseOffering(CourseOffering courseOffering);

}
