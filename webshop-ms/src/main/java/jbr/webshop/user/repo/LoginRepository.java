package jbr.webshop.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.webshop.user.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {

}
