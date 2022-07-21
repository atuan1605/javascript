package com.example.hk_rest_crud.controller;

import com.example.hk_rest_crud.model.Person;
import com.example.hk_rest_crud.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Person> listAll() {
        return personDao.getAll();
    }

    @GetMapping(value = "/sortByFullName")
    @ResponseBody
    public List<Person> listSortFullName() {
        return personDao.sortByFullName();
    }

    @GetMapping(value = "/sortByJob")
    @ResponseBody
    public List<Person> listSortJob() {
        return personDao.sortByJob();
    }

    @GetMapping(value = "/sortByCity")
    @ResponseBody
    public List<Person> listSortCity() {
        return personDao.sortByCities();
    }

    @GetMapping(value = "/top5City")
    @ResponseBody
    public HashMap<String, Integer> top5City() {
        HashMap<String, Integer> map = personDao.groupCityByCount();
        personDao.findTop5Cities(map);
        return map;
    }
    @GetMapping(value ="/top5Job")
    @ResponseBody
    public HashMap<String, Integer> top5Job(){
        HashMap<String,Integer> map = personDao.groupJobByCount();
        personDao.findTop5Jobs(map);
        return map;
    }

    @GetMapping(value = "/{job}")
    @ResponseBody
    public List find5CitiesHaveMostSpecificJob(@PathVariable String job){
        return personDao.find5CitiesHaveMostSpecificJob(job);
    }
    @GetMapping(value = "/TopJob")
    @ResponseBody
    public HashMap<String, String> findTopJobInCity(){
        return personDao.findJobByCity();
    }
}
