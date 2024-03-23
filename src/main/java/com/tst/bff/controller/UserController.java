package com.tst.bff.controller;


import com.google.common.collect.ImmutableMap;
import com.tst.bff.client.UserClient;
import com.tst.user.client.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yaxio
 */
@Slf4j
@RestController
@RequestMapping("/bff/user")
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/get-user-by-id")
    public UserDTO getUserById(@RequestParam("id") Long id){
        log.info("getUserById id: {}", id);
        return userClient.getUserById(id);
    }
}
