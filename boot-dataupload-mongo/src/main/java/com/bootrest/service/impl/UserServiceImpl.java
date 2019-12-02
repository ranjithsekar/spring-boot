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

import com.bootrest.model.User;
import com.bootrest.repository.UserDao;
import com.bootrest.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to upload the user data. 1) delete existing user data, 2) upload new
 * user data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  /** Inject User Repository Object. **/
  @Autowired
  private UserDao userRepository;

  /**
   * 1) Read the file line by line, 2) parse the data, 3) remove existing data
   * from db, 4) insert parsed data.
   * 
   * @param fileName - input filename.
   */
  public void addUser(String fileName) {
    Stream<String> lines = null;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<User> users = lines.map(userMap).collect(Collectors.toList());

      userRepository.deleteAll();
      log.info("All the existing user data deleted.");

      List<User> inserted = userRepository.insert(users);
      log.info(inserted.size() + " users inserted");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the Category object from the csv.
   */
  private Function<String, User> userMap = (line) -> {
    String[] data = line.split(",");

    User user = new User();
    user.setUserId(data[0]);
    user.setUserType(data[1]);
    user.setActive(Boolean.valueOf(data[2]));

    return user;
  };

}