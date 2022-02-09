package com.ideaco.dia.controller;

import com.ideaco.dia.DTO.UserDTO;
import com.ideaco.dia.service.UserService;
import com.ideaco.dia.model.UserModel;
import com.ideaco.dia.request.RegisterUserRequest;

import com.ideaco.dia.request.UpdateUserRequest;
import com.ideaco.dia.request.UserLoginRequest;
import com.ideaco.dia.response.DataResponse;
import com.ideaco.dia.response.HandlerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController //vio khouwi
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        //response
        return "helloWorld";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        return userService.sendMessage(message);
    }

    @GetMapping("/user/{userId}")
    public UserModel getUser(@PathVariable("userId") int userId){
        return userService.getJobById(userId);
    }

    @PostMapping("/user/add")
    public UserModel createUser(@RequestBody RegisterUserRequest registerUserRequest){
        return userService.createUser(registerUserRequest);
    }

    @GetMapping("/user/all")
    public List<UserModel> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/user/{userId}")
    public UserModel updateUser(@PathVariable int userId, @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUser(userId, updateUserRequest);
    }

    @PostMapping("/user/login")
    public void auth(HttpServletResponse response, @RequestBody UserLoginRequest userLoginRequest){
        UserDTO userDTO = userService.userLogin(userLoginRequest);

        if (userDTO != null){
            DataResponse<UserDTO> dataResponse = new DataResponse<>();
            dataResponse.setData(userDTO);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        }else {
            HandlerResponse.responseBadRequest(response, "400", "Email or password wrong");
        }
    }




}
