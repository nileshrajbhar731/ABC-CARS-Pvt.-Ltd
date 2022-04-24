package com.lithan.ABC_Cars_Pte_Ltd.service;

import java.util.List;

import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;






public interface CarService {
	
	public String addCar (Car sto);
	public Car UpdateaddCar(Car us);
	public List<Car> showAllStore();
	public List<User> showAllUser();
	public void deleteData(Integer storeid);
	public Car updateCarData(Integer id);
	
	public List<Car> searchByPrice(Long minp,Long maxp);
//	public List<Car> searchProduct(int parseInt);
//	public List<Car> listAll(String keyword);
//	public List<Car> searchProduct(String model);
//	public List<Car> searchCar(String select,String type,Double min,Double max);
	public List<Car> searchProduct(String serach);
	
	
//	public void UpdateaddCar(Car pro);

	
}
