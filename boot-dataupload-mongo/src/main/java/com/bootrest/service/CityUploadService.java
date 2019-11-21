package com.bootrest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.dao.CityRepository;
import com.bootrest.model.City;

@Service
public class CityUploadService {
  private final Logger log = LoggerFactory.getLogger(CityUploadService.class);

  @Autowired
  private CityRepository cityRepo;

  public void addCity(String fileName) {
    Stream<String> lines;
    try {
      lines = Files.lines(Paths.get(fileName));
      List<City> states = lines.map(cityMap).collect(Collectors.toList());
      cityRepo.deleteAll();
      List<City> inserted = cityRepo.insert(states);
      log.info(inserted.size() + " cities inserted");
      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  private Function<String, City> cityMap = (line) -> {
    String[] data = line.split(",");
    City city = new City();
    city.setName(data[0]);
    city.setCountryCode(data[1]);
    city.setStateCode(data[2]);
    city.setLatitude(data[3]);
    city.setLongitude(data[4]);

    return city;
  };

}