package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    @Qualifier("usuarioservice")
    private UsuarioService usuarioService;

    @GetMapping
    public String showLoginPage() {
        return "Login";
    }

    @PostMapping("/validate")
    @ResponseBody
    public String validateUser(@RequestBody Usuario loginData) {
        Usuario user = usuarioService.findByUsernameAndPassword(loginData.getUsuario(), loginData.getPassword());

        if (user != null && user.getEstado() == 1) {
            return "SUCCESS";
        } else {
            return "INVALID";
        }
    }
}