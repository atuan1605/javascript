package com.example.democar.controller;

import com.example.democar.model.Car;
import com.example.democar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ThymeController {
    @Autowired
    public CarService carService;

    @GetMapping(value = "/cars")
    public String index(Model model){
        List<Car> list = carService.getAll();
        model.addAttribute("cars", list);
        return "list_cars";
    }
    @GetMapping(value = "/Sort/Model")
    public String sortByModel(Model model){
        List<Car> list = carService.getAll();
        carService.sortByModel(list);
        model.addAttribute("cars", list);
        return "list_sortModel_cars";
    }
    @GetMapping(value = "/Sort/Brand")
    public String sortByBrand(Model model){
        List<Car> list = carService.getAll();
        carService.sortByBrand(list);
        model.addAttribute("cars", list);
        return "list_sortBrand_cars";
    }

    @GetMapping("/addCarForm")
    public String addCar(Model model){
        model.addAttribute("cars",new Car());
        return "car_form";
    }

    @PostMapping(value = "/saveCar")
    public String saveCar(@ModelAttribute Car car){
        carService.update(car);
        return "redirect:/cars";
    }
    @GetMapping("/update")
    public String updateForm(@RequestParam int carId, Model model){
        Car car = carService.findById(carId);
        model.addAttribute("cars",car);
        return "car_form";
    }
    @GetMapping("/delete")
    public String deleteCar(@RequestParam int carId, Model model){
        carService.deleteById(carId);
        return "redirect:/cars";
    }
}
