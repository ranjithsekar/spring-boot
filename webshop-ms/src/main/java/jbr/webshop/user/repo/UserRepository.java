package jbr.webshop.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jbr.webshop.user.model.UserModel;
import jbr.webshop.user.model.UserResponseModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

  @Query(value = "SELECT u.firstname AS firstname, u.lastname AS lastname, u.email AS email, u.address AS address, u.phone AS phone "
      + "FROM Login l, Users u "
      + "WHERE l.username=:username AND l.password=:password AND l.userid=u.userid", nativeQuery = true)
  UserResponseModel validateUser(@Param("username") String username, @Param("password") String password);

}
