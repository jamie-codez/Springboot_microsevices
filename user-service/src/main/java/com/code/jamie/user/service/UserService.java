package com.code.jamie.user.service;

import com.code.jamie.user.entity.User;
import com.code.jamie.user.repository.UserRepository;
import com.code.jamie.user.valueObjects.Department;
import com.code.jamie.user.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method in "+getClass().getName());
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        log.info("Inside saveUser method in "+getClass().getName());
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
