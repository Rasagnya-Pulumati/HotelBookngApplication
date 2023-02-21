package com.cg.hbm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserNameAndPassword(String username, String password);

}
