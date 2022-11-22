package io.goorm.ddic.controller;

import io.goorm.ddic.service.CarService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/")
    public String helloMvc(Model model) throws IOException, ParseException {
        carService.createCarUseApi();
        return "hello";
    }

}
