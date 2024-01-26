package edu.iu.aurabaza.Homework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


    @RestController
    public class HomeController {

        @GetMapping("/")
        public String greetings() {
            return "Welcome to the Guitar Shop!";
        }
}
