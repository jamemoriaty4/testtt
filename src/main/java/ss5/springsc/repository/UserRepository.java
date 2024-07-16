package ss5.springsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ss5.springsc.model.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
