package io.goorm.ddic.controller;

import io.goorm.ddic.domain.Car;
import io.goorm.ddic.repository.CarRepository;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class apiController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/car-api")
    public JSONArray getCars(){

        JSONArray jsonArray = new JSONArray();
        List<Car> cars = carRepository.findAll();
        for (Car car: cars) {
            jsonArray.add(car);
        }

        return jsonArray;
    }
}
