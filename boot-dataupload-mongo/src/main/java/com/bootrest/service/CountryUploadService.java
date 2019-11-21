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
import com.bootrest.dao.CountryRepository;
import com.bootrest.dao.StateRepository;
import com.bootrest.model.Country;

@Service
public class CountryUploadService {
  private final Logger log = LoggerFactory.getLogger(CountryUploadService.class);

  @Autowired
  private CountryRepository countryRepo;

  @Autowired
  private StateRepository stateRepo;

  @Autowired
  private CityRepository cityRepo;

  public void addCountry(String fileName) {
    Stream<String> lines;
    try {
      lines = Files.lines(Paths.get(fileName));
      List<Country> countries = lines.map(countryMap).collect(Collectors.toList());
      cityRepo.deleteAll();
      stateRepo.deleteAll();
      countryRepo.deleteAll();
      List<Country> inserted = countryRepo.insert(countries);
      log.info(inserted.size() + " countries inserted.");
      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  private Function<String, Country> countryMap = (line) -> {
    String[] data = line.split(",");
    Country country = new Country();
    country.setName(data[0]);
    country.setCode(data[1]);

    return country;
  };

}