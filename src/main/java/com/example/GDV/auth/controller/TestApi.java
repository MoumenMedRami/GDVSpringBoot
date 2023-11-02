package com.example.GDV.auth.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class TestApi {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('USER')")
    public String testAdmin(){
        System.out.println("jai entrer admin ++++++++++++++++++++++++++");
        return "je suis admin ";
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
   // @PreAuthorize("hasRole('USER')")
    public String testUser(){

        System.out.println("jai entrer user ++++++++++++++++++++++++++");return "je suis user ";
    }
    @GetMapping("/no")
    public String testnoUser(){
        System.out.println("jai entrer no priv +++++++++++++++++++++++");return "je suis no securise  ";
    }
}