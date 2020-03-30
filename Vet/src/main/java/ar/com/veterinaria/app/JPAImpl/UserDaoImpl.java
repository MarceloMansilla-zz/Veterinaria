package ar.com.veterinaria.app.JPAImpl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.com.veterinaria.app.dao.UserDao;
import ar.com.veterinaria.app.entities.user.User;
import ar.com.veterinaria.app.exception.notFound.ClinicalHistoryNotFoundException;
import ar.com.veterinaria.app.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private UserRepository userRepository;

	public UserDaoImpl() {
		super();
	}

	@Override
	public User findById(int id) {
		try {
			// if (!ClinicalHistoryManagerDaoImplHelper.isDeleted(id)) {
			return userRepository.findUserById(id);
			// }
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		throw new ClinicalHistoryNotFoundException(id);
	}

	@Override
	public void remove(int id) {
		//if (!ClinicalHistoryManagerDaoImplHelper.isDeleted(id)) {
			User user = userRepository.findUserById(id);
			user.setId(id);
			user.setDeleted(true);
			userRepository.save(user);
		//} // falta validar id
	}

	@Override
	public User add(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public User update(int id, User user) {
		/*
		 * if (ClinicalHistoryManagerDaoImplHelper.existId(id)) { if
		 * (!ClinicalHistoryManagerDaoImplHelper.isDeleted(id)) { userRepository
		 * .save(ClinicalHistoryManagerDaoImplHelper.updateClinicalHistory(id, user));
		 */
		return user;
		/*
		 * }
		 * 
		 * } return null;
		 */
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return null;//userRepository.findAll();
	}

	@Override
	public boolean exist(User user) {
		/*
		 * if (!ClinicalHistoryManagerDaoImplHelper.validate(user)) { return false; }
		 */
		return true;
	}

}
