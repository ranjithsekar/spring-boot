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
import com.bootrest.dao.StateRepository;
import com.bootrest.model.State;

@Service
public class StateUploadService {

  private final Logger log = LoggerFactory.getLogger(StateUploadService.class);

  @Autowired
  private StateRepository stateRepo;

  @Autowired
  private CityRepository cityRepo;

  public void addState(String fileName) {
    Stream<String> lines;
    try {
      lines = Files.lines(Paths.get(fileName));
      List<State> states = lines.map(stateMap).collect(Collectors.toList());
      cityRepo.deleteAll();
      stateRepo.deleteAll();
      List<State> inserted = stateRepo.insert(states);
      log.info(inserted.size() + " states inserted.");
      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  private Function<String, State> stateMap = (line) -> {
    String[] data = line.split(",");
    State state = new State();
    state.setName(data[0]);
    state.setCode(data[1]);
    state.setCountryCode(data[2]);

    return state;
  };

}