package academetrics.repository;

import academetrics.entity.CourseOffering;
import academetrics.entity.CourseOfferingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, CourseOfferingId> {
    CourseOffering findByCourseOfferingId(CourseOfferingId courseOfferingId);
    void deleteByCourseOfferingId(CourseOfferingId courseOfferingId);
}

