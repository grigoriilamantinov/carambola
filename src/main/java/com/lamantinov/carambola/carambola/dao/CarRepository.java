package com.lamantinov.carambola.carambola.dao;

import com.lamantinov.carambola.carambola.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {
}
