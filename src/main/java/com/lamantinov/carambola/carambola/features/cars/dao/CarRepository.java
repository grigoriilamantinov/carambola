package com.lamantinov.carambola.carambola.features.cars.dao;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {
}
