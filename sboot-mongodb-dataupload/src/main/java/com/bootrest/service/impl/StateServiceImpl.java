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

import com.bootrest.model.State;
import com.bootrest.repository.CityDao;
import com.bootrest.repository.StateDao;
import com.bootrest.service.StateService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to upload state of a state data. Upload the city data after this
 * service is called since 1) it will delete the city and state data, 2) upload
 * the state data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
@Slf4j
public class StateServiceImpl implements StateService {

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
  public void addState(String fileName) {
    Stream<String> lines;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<State> states = lines.map(stateMap).collect(Collectors.toList());

      cityRepository.deleteAll();
      log.info("All the existing city data deleted.");

      stateRepository.deleteAll();
      log.info("All the existing state data deleted.");

      List<State> inserted = stateRepository.insert(states);
      log.info(inserted.size() + " states inserted.");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the State object from the csv.
   */
  private Function<String, State> stateMap = (line) -> {
    String[] data = line.split(",");

    State state = new State();
    state.setStateCode(data[0]);
    state.setStateName(data[1]);
    state.setCountryCode(data[2]);
    state.setActive(Boolean.valueOf(data[3]));

    return state;
  };

}