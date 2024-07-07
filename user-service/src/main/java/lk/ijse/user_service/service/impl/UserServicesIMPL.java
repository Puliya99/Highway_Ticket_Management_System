package lk.ijse.user_service.service.impl;

import lk.ijse.user_service.convert.DataConvert;
import lk.ijse.user_service.dao.UserRepo;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.UserEntity;
import lk.ijse.user_service.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesIMPL implements UserServices {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DataConvert dataConvert;

    Logger logger = LoggerFactory.getLogger(UserServicesIMPL.class);

    @Override
    public String saveUser(UserDTO userDTO) {
        try {
            UserEntity userEntity = dataConvert.userDTOConvertUserEntity(userDTO);
            userRepo.save(userEntity);
            return "User saved successfully";
        } catch (Exception e) {
            logger.error("Error while saving user", e);
            return "Failed to save user";
        }
    }

    @Override
    public String updateUser(String updateUserId, UserDTO userDTO) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepo.findById(updateUserId);
            if (optionalUserEntity.isPresent()) {
                UserEntity userEntity = dataConvert.userDTOConvertUserEntity(userDTO);
                userEntity.setUserId(updateUserId); // Ensure the ID remains the same
                userRepo.save(userEntity);
                return "User updated successfully";
            } else {
                return "User not found";
            }
        } catch (Exception e) {
            logger.error("Error while updating user", e);
            return "Failed to update user";
        }
    }

    @Override
    public String deleteUser(String deleteUserId) {
        try {
            Optional<UserEntity> optionalUserEntity = userRepo.findById(deleteUserId);
            if (optionalUserEntity.isPresent()) {
                userRepo.deleteById(deleteUserId);
                return "User deleted successfully";
            } else {
                return "User not found";
            }
        } catch (Exception e) {
            logger.error("Error while deleting user", e);
            return "Failed to delete user";
        }
    }

    public String getUser(String userId) {
        if (userRepo.existsById(userId)){
            UserEntity user = userRepo.findById(userId).orElse(null);
            return "User Id : " + user.getUserId() + "\n" +
                    "User Mail : " + user.getUserMail() + "\n" +
                    "User Name : " + user.getUserName() + "\n" +
                    "Password: " + user.getPassword();
        } else {
            logger.info("This Id Has No User");
            return "This Id Has No User";
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userRepo.findAll();
        return dataConvert.usersEntityListConvertUserDTOList(allUsers);
    }
}
