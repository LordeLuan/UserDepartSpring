package br.com.devsuperior.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devsuperior.userdept.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
