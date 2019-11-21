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

import com.bootrest.model.City;
import com.bootrest.repository.CityRepository;

/**
 * Service to upload city data. 1) delete the existing city data, 2) upload the
 * new city data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
public class CityService {

  /** Logger object. */
  private final Logger log = LoggerFactory.getLogger(CityService.class);

  /** Inject City Repository Object. **/
  @Autowired
  private CityRepository cityRepository;

  /**
   * 1) Read the file line by line, 2) parse the data, 3) remove existing data
   * from db, 4) insert parsed data.
   * 
   * @param fileName - input filename.
   */
  public void addCity(String fileName) {
    Stream<String> lines;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<City> states = lines.map(cityMap).collect(Collectors.toList());

      cityRepository.deleteAll();
      log.info("All the existing city data deleted.");

      List<City> inserted = cityRepository.insert(states);
      log.info(inserted.size() + " cities inserted");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the City object from the csv.
   */
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