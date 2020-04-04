package ar.com.veterinaria.app.entities.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserById(Integer id);

	List<User> findAll();

	@SuppressWarnings("unchecked")
	User save(User user);

	void delete(User user);
}
