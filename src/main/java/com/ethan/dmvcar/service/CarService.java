package com.ethan.dmvcar.service;

import com.ethan.dmvcar.dao.jpa.CarRepository;
import com.ethan.dmvcar.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public CarService() {
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(long id) {
        return carRepository.findOne(id);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.delete(id);
    }

    //http://goo.gl/7fxvVf
    public Page<Car> getAllCars(Integer page, Integer size) {
        Page pageOfCars = carRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("Ethan.CarService.getAll.largePayload");
        }
        return pageOfCars;
    }
}
