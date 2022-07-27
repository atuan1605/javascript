package com.example.democar.service;

import com.example.democar.model.Car;

import java.util.List;

public interface ICar {
    void readCSV(String csvFile);

    void add(Car car);
     List<Car> getAll();
     Car findById(int id);
    void update(Car car);

    void deleteById(int id);

    void sortByModel(List<Car> list);

    void sortByBrand(List<Car> list);



}
