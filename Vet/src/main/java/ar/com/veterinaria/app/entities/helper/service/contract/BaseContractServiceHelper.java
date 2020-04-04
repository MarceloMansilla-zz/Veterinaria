package ar.com.veterinaria.app.entities.helper.service.contract;

public interface BaseContractServiceHelper<T> {

	boolean isValidName(T t);

	boolean isValidLengthName(T t);

}
