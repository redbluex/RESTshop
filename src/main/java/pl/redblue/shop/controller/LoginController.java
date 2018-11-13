package pl.redblue.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

        @RequestMapping(value="/bbb", method = RequestMethod.GET)
        public String printWelcome(ModelMap model, Principal principal ) {

            String name = principal.getName(); //get logged in username

            return name;

        }
}
