package com.ideaco.dia.service;

import com.ideaco.dia.DTO.UserDTO;
import com.ideaco.dia.repository.UserRepository;
import com.ideaco.dia.model.UserModel;
import com.ideaco.dia.request.RegisterUserRequest;
import com.ideaco.dia.request.UpdateUserRequest;
import com.ideaco.dia.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String sendMessage(String message) {
        return "Sending message " + message;
    }

    public UserModel getJobById(int userId) {
        return userRepository.findById(userId).get();
    }

    public List<UserModel> findAllUser() {
        return userRepository.findAll();
    }

    //RegisterUserRequest class untuk body
    public UserModel createUser(RegisterUserRequest registerUserRequest) {
        UserModel userModel = new UserModel();
        userModel.setUserName(registerUserRequest.getUserName());
        userModel.setUserEmail(registerUserRequest.getUserEmail());
        userModel.setUserAddress(registerUserRequest.getUserAddress());
        userModel.setUserPassword(registerUserRequest.getUserPassword());
        userModel.setUserPhone(registerUserRequest.getUserPhone());
        userModel.setUserResume(registerUserRequest.getUserResume());

        //save to table
        return userRepository.save(userModel);
    }
//method ambil semua data
    public List<UserModel> getAllUser() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    public UserModel updateUser(int userId, UpdateUserRequest updateUserRequest) {
        Optional<UserModel> user = userRepository.findById(userId);

//        if (user.isPresent()) {
        user.get().setUserName(updateUserRequest.getUserName());
        user.get().setUserEmail(updateUserRequest.getUserEmail());
        user.get().setUserPhone(updateUserRequest.getUserPhone());
        user.get().setUserAddress(updateUserRequest.getUserAddress());

        return userRepository.save(user.get());
//        }
    }

    public UserDTO userLogin(UserLoginRequest userLoginRequest) {
        Optional<UserModel> user = userRepository.getUserLogin(userLoginRequest.getUserEmail(), userLoginRequest.getUserPassword());
        if (user.isEmpty()) return null;

        return mapToDTO(user.get());
    }

    public UserDTO mapToDTO(UserModel user){
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPhone(),
                user.getUserAddress(),
                user.getUserResume());
    }
}
