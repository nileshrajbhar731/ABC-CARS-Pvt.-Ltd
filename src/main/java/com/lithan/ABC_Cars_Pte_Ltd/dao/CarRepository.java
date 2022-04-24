package com.lithan.ABC_Cars_Pte_Ltd.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;


public interface CarRepository extends JpaRepository<Car,Integer>{

public List<Car> findByCarPriceBetween(Long minp, Long maxp);

//public Optional<Car> findBycarModel(String type);

	// SELECT * FROM PRODUCT WHERE price BETWEEN min AND max
		//SELECT * FROM prod_db WHERE prod_price BETWEEN min AND max;

@Query("SELECT p FROM Car p WHERE CONCAT(p.cardId,' ',p.carModel,' ',p.carName,' ',p.carRegNumber,' ', p.carPrice,' ', p.image,' ', p.manufaData) LIKE %?1%")
public List<Car> search(String keyword);

public Car findByCarRegNumber(String carRegNumber);




	

}
