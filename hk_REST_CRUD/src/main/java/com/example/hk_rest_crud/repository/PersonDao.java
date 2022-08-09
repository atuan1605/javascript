package com.example.hk_rest_crud.repository;

import com.example.hk_rest_crud.model.Person;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

public class PersonDao extends Dao<Person> {

    public PersonDao(String csvFile) {
        this.readCSV(csvFile);
    }

    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',');
            ObjectReader oReader = mapper.readerFor(Person.class).with(schema);
            Reader reader = new FileReader(file);
            MappingIterator<Person> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                Person person = mi.next();
                this.add(person);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add(Person person) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = collections.get(collections.size() - 1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        collections.add(person);
    }

    @Override
    public List<Person> getAll() {
        return collections;
    }

    @Override
    public List<Person> sortByFullName() {
        collections.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return collections;
    }

    @Override
    public List<Person> sortByJob() {
        collections.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getJob().compareTo(o2.getJob());
            }
        });
        return collections;
    }

    @Override
    public List<Person> sortByCities() {
        collections.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        });
        return collections;
    }

    @Override
    public HashMap<String, Integer> groupCityByCount() {
        HashMap<String, Integer> mapCity = new HashMap<>();
        collections.forEach((n) -> {
            mapCity.put(n.getCity(), mapCity.getOrDefault(n.getCity(), 0) + 1);
        });
        return mapCity;
    }

    @Override
    public HashMap<String, List> groupPeopleByCity() {
        HashMap<String, List> map = new HashMap<>();
        for (Person person : collections) {
            if (!map.containsKey(person.getCity())) {
                List<Person> list = new ArrayList<>();
                list.add(person);
                map.put(person.getCity(), list);
            } else {
                List<Person> list = map.get(person.getCity());
                list.add(person);
                map.put(person.getCity(), list);
            }
        }
        return map;
    }


    @Override
    public HashMap<String, Integer> groupJobByCount() {
        HashMap<String, Integer> mapJob = new HashMap<>();
        collections.forEach((n) -> {
            mapJob.put(n.getJob(), mapJob.getOrDefault(n.getJob(), 0) + 1);
        });
        return mapJob;
    }

    @Override
    public Map<String, Integer> findTop5Jobs(HashMap<String, Integer> mapJob) {
        while (mapJob.size() > 5) {
            int minValue = Collections.min(mapJob.values());
            mapJob.values().remove(minValue);
        }
        return mapJob;
    }

    @Override
    public HashMap<String, Integer> findTop5Cities(HashMap<String, Integer> mapCity) {
        while (mapCity.size() > 5) {
            int minValue = Collections.min(mapCity.values());
            mapCity.values().remove(minValue);
        }
        return mapCity;
    }

    @Override
    public HashMap<String, String> findJobByCity() {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, List> subMap = groupPeopleByCity();
        for (String city : subMap.keySet()) {
            List<Person> list = subMap.get(city);
            HashMap<String, Integer> mapJob = new HashMap<>();
            list.forEach((n) -> {
                mapJob.put(n.getJob(), mapJob.getOrDefault(n.getJob(), 0) + 1);
            });
            int maxValue = Integer.MIN_VALUE;
            for (String str : mapJob.keySet()){
                if (mapJob.get(str) > maxValue){
                    map.put(city, str);
                    maxValue = mapJob.get(str);
                }
            }
        }
        return map;
    }


    @Override
    public List find5CitiesHaveMostSpecificJob(String job) {
        HashMap<String, Integer> map = new HashMap<>();
        collections.stream()
                .filter(person -> job.equals(person.getJob()))
                .forEach(filPerson -> {
                    map.put(filPerson.getCity(), map.getOrDefault(filPerson.getCity(), 0) + 1);
                });
        while (map.size() > 5) {
            int minValue = Collections.min(map.values());
            map.values().remove(minValue);
        }
        List<String> specificJob = new ArrayList<>();
        specificJob.addAll(map.keySet());
        return specificJob;
    }
}
