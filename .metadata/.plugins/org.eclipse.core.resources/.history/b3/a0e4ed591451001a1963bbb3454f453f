package ar.com.veterinaria.app.helper.daoImpl.contract;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseContractDaoImplHelper<T> {

	boolean isDuplicated(JpaRepository<T, Integer> repository, T t);

	boolean existId(JpaRepository<T, Integer> repository, Integer id);
}
