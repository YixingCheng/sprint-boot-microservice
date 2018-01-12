package com.ethan.dmvcar.dao.jpa;

import com.ethan.dmvcar.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
    Car findCarByCity(String city);
    Page findAll(Pageable pageable);
}
