package jbr.webshop.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.webshop.user.model.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

}
