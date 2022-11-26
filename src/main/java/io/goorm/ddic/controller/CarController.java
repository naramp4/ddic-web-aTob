package io.goorm.ddic.controller;

import io.goorm.ddic.domain.Car;
import io.goorm.ddic.service.CarService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping("/")
    public String helloMvc(Model model) throws IOException, ParseException {
//        carService.createCarUseApi();
        return "spring-index";
    }

    @GetMapping("/car/allremove")
    public String allRemove(Model model){
        carService.deleteCars();
        return "redirect:/";
    }

    @PostMapping("/car/addcars")
    public String addCars(Car carForm) throws IOException, ParseException {
        System.out.println("chanlog" + carForm.toString());
        String pageNum = carForm.getPageNum();
        String limit = carForm.getItemLimit();
        carService.createCarUseApi(pageNum, limit);
        return "redirect:/";
    }

}
