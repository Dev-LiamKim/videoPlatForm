package dev.liam.videoplatform.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.liam.videoplatform.component.dto.userDTO;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<String> userLogin(){
        return ResponseEntity.ok("Login Success");
    }

    @PostMapping(path = "/regist", consumes = "application/json")
    public ResponseEntity<String> userRegist(@RequestBody userDTO newUser){
        System.out.println("RequestBody Success");
        return ResponseEntity.ok("Regist Success");
    }
}
