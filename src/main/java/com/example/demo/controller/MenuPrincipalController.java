package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPrincipalController {

    @GetMapping("/menuPrincipal")
    public String showMenu() {
        return "MenuPrincipal"; // templates/MenuPrincipal.html
    }
}
	