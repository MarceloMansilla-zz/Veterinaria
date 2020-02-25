package ar.com.veterinaria.app.helper.daoImpl.contract;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseContractDaoImplHelper<T> {

	boolean isDuplicated(JpaRepository<T, Integer> repository, T t);

	boolean existId(JpaRepository<T, Integer> repository, Integer id);

	boolean deleted(JpaRepository<T, Integer> repository, Integer id);

	List<Map<String, Object>> findAll(JpaRepository<T, Integer> repository);

	T findByName(JpaRepository<T, Integer> repository, String t);
	
	T update(JpaRepository<T, Integer> repository, T t);
}
