package com.arcade.user.service;

import com.arcade.user.entity.UserModel;
import com.arcade.user.repository.UserRepo;
import com.arcade.user.valueobjects.Department;
import com.arcade.user.valueobjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    public UserModel saveUser(UserModel user) {
        log.info("Service : user save method");
        return userRepo.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Service : get user with department");
        ResponseTemplate obj = new ResponseTemplate();
        UserModel user = userRepo.findByUserId(userId);

//        Department department = restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId(), Department.class);
//        DEPARTMENT-MICROSERVICE hostname will be used from eureka service registry
        Department department = restTemplate.getForObject("http://DEPARTMENT-MICROSERVICE/departments/" + user.getDepartmentId(), Department.class);

        obj.setUser(user);
        obj.setDepartment(department);
        return obj;
    }
}
