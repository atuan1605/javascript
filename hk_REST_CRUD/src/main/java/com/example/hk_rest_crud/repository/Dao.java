package com.example.hk_rest_crud.repository;

import com.example.hk_rest_crud.model.Person;

import java.util.*;

public abstract class Dao<T> {
     protected List<T> collections = new ArrayList<>();

     public abstract void readCSV(String csvFile);

     public abstract void add(T t);

     public abstract List<T> getAll();

     public abstract List<T> sortByFullName();

     public abstract List<T> sortByJob();

     public  abstract List<T> sortByCities();

     public abstract HashMap<String,Integer> groupCityByCount();

     public abstract HashMap<String, List> groupPeopleByCity();

     public abstract HashMap<String,Integer> groupJobByCount();

     public abstract Map<String, Integer> findTop5Jobs(HashMap<String,Integer> mapJob);

     public abstract HashMap<String, Integer> findTop5Cities(HashMap<String, Integer> map);

     public abstract HashMap<String,String> findJobByCity();

     public abstract List find5CitiesHaveMostSpecificJob(String job);
}
