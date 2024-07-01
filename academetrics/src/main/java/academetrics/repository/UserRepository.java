package academetrics.repository;

import academetrics.dto.UserRegistrationDTO;
import academetrics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByUserName(String username);
    
//    @Query(value = "SELECT * FROM user u WHERE u.user_name = ?1", nativeQuery = true)
//    List<User> getUserFromUserName(String userName);
}
