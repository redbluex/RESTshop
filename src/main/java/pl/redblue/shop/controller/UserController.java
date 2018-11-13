package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Users;
import pl.redblue.shop.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserService userService;

        @PostMapping("/register")
        public Users createUser(@RequestBody Users user){
           return userService.create(user);
        }


        @RequestMapping(value="/bbb", method = RequestMethod.GET)
        public String printWelcome(Principal principal) {

            String name = principal.getName();

            return name;

        }
}
