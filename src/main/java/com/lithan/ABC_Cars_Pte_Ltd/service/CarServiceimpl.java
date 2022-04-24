package com.lithan.ABC_Cars_Pte_Ltd.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.ABC_Cars_Pte_Ltd.dao.CarRepository;
import com.lithan.ABC_Cars_Pte_Ltd.dao.UserRepository;
import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;




@Service("carService")
public class CarServiceimpl implements CarService {

	  @Autowired
	  CarRepository Carrepo;
	  @Autowired
	  UserRepository Userrepo;

	@Override
	public String addCar(Car sto) {
		// TODO Auto-generated method stub
//		Carrepo.save(sto);
//		System.out.println(sto);
//		return sto;
		Car u = Carrepo.findByCarRegNumber(sto.getCarRegNumber());
		if(u== null) {
			Carrepo.save(sto);
			 return "DATA ADDED";
		}else {
			return "RegNumber exit";
		}
		
	}
	
	@Override
	public Car UpdateaddCar(Car us) {
		// TODO Auto-generated method stub
		Carrepo.save(us);
		System.out.println(us+" "+"88 "+" "+" done");
		return us;
		
		
	}

	@Override
	public List<Car> showAllStore() {
		// TODO Auto-generated method stub
		List<Car> allData=Carrepo.findAll();
		return allData;
	}

	

	@Override
	public void deleteData(Integer storeid) {
		// TODO Auto-generated method stub
		Carrepo.deleteById(storeid);
		
	}

	@Override
	public Car updateCarData(Integer id) {
		Optional<Car> mydata=Carrepo.findById(id);
		Car p= mydata.get();
		return p;	
	}
	


	@Override
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		List<User> allUser=Userrepo.findAll();
		return allUser;
	}

//	search
	@Override
	public List<Car> searchProduct(String serach) {
		// TODO Auto-generated method stub
		List<Car> myData=Carrepo.search(serach);
	
	    
		return myData;
	}

	@Override
	public List<Car> searchByPrice(Long minp,Long maxp) {
		// TODO Auto-generated method stub
		List<Car> myList=Carrepo.findByCarPriceBetween(minp, maxp);
//				findByProdPriceBetween(minp, maxp);
		return myList;
	}





	

}
