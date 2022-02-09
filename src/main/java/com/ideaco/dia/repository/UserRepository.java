package com.ideaco.dia.repository;

import com.ideaco.dia.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//JobModel ->  model yang kita buat, integer tipe data dari jobmodel
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUserName(String username);

    @Query("SELECT u from UserModel u where u.userEmail = :email and u.userPassword = :password")
    Optional<UserModel> getUserLogin(String email, String password);
}

