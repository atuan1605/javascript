package com.example.democar.service;

import com.example.democar.model.Car;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarService implements ICar {
    protected List<Car> collections = new ArrayList<>();

    public CarService(String csvFile){
        this.readCSV(csvFile);
    }

    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',');
            ObjectReader oReader = mapper.readerFor(Car.class).with(schema);
            Reader reader = new FileReader(file);
            MappingIterator<Car> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                Car car = mi.next();
                this.add(car);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add(Car car) {
        int id;
        if (collections.isEmpty()){
            id = 1;
        }else {
            Car lastCar = collections.get(collections.size() -1);
            id =  lastCar.getId() +1;
        }
        car.setId(id);
        collections.add(car);
    }

    @Override
    public List<Car> getAll() {
        return collections;
    }

    @Override
    public Car findById(int id) {
        for(Car car : collections){
            if (car.getId()== id){
                return car;
            }
        }
        return null;
    }

    @Override
    public void update(Car car) {
        int idCar = car.getId();
        if (findById(idCar) == null){
            collections.add(car);
        }else {
            Car newCar = findById(idCar);
            newCar.setModel(car.getModel());
            newCar.setBrand(car.getBrand());
            newCar.setYear(car.getYear());
            newCar.setImage(car.getImage());
        }
    }

    @Override
    public void deleteById(int id) {
        if (findById(id) != null){
            collections.remove(findById(id));
        }
    }

    @Override
    public void sortByModel(List<Car> list) {
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
    }

    @Override
    public void sortByBrand(List<Car> list) {
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        });
    }

}
