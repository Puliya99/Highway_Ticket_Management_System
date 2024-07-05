package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/userService")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }

    @PostMapping("/save")
    public String userSave( @RequestBody  UserDTO userDTO){
        String resp = userServices.saveUser(userDTO);
        return resp;
    }

    @PutMapping("/update/{updateUserId}")
    public String userUpdate(@PathVariable("updateUserId") String updateUserId ,@RequestBody UserDTO userDTO){
        String resp = userServices.updateUser(updateUserId,userDTO);
        return resp;
    }

    @DeleteMapping("/delete/{deleteUserId}")
    public String userDelete(@PathVariable ("deleteUserId") String deleteUserId){
        String resp = userServices.deleteUser(deleteUserId);
        return resp;
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllVehicles(){
        List<UserDTO> allUsers = userServices.getAllUsers();
        return allUsers;
    }
}