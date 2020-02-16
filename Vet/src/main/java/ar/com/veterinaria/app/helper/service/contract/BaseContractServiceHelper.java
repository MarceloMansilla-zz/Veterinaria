package ar.com.veterinaria.app.helper.service.contract;

public interface BaseContractServiceHelper<T> {

	boolean isValidName(T t);

	boolean isValidLengthname(T t);

}
