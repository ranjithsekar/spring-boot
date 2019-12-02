package com.bootrest.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.model.Country;
import com.bootrest.repository.CityDao;
import com.bootrest.repository.CountryDao;
import com.bootrest.repository.StateDao;
import com.bootrest.service.CountryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to upload country data. Upload the state and city data after this
 * service called since 1) it deletes city, state and country data, 2) upload
 * the country data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

  /** Inject Country Repository Object. **/
  @Autowired
  private CountryDao countryRepository;

  /** Inject State Repository Object. **/
  @Autowired
  private StateDao stateRepository;

  /** Inject City Repository Object. **/
  @Autowired
  private CityDao cityRepository;

  /**
   * 1) Read the file line by line, 2) parse the data, 3) remove existing data
   * from db, 4) insert parsed data.
   * 
   * @param fileName - input filename.
   */
  public void addCountry(String fileName) {
    Stream<String> lines;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<Country> countries = lines.map(countryMap).collect(Collectors.toList());

      cityRepository.deleteAll();
      log.info("All the existing city data deleted.");

      stateRepository.deleteAll();
      log.info("All the existing state data deleted.");

      countryRepository.deleteAll();
      log.info("All the existing country data deleted.");

      List<Country> inserted = countryRepository.insert(countries);
      log.info(inserted.size() + " countries inserted.");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the Country object from the csv.
   */
  private Function<String, Country> countryMap = (line) -> {
    String[] data = line.split(",");

    Country country = new Country();
    country.setCountryCode(data[0]);
    country.setCountryName(data[1]);
    country.setActive(Boolean.valueOf(data[2]));

    return country;
  };

}