package ar.com.veterinaria.app.service.contract;

import java.util.List;
import java.util.Map;

public interface BaseContractService<T> {

	T findById(int id);

	void remove(int id);

	List<Map<String, Object>> findAll();

	T add(T t);

	T update(int id, T t);

	boolean exist(T t);
	
	boolean isValidInputData(T t);

}
