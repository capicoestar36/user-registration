package com.example.user_registration.controller;

import com.example.user_registration.model.User;
import com.example.user_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Anotação que marca esta classe como um controlador web
public class UserController {
    
    private final UserService userService;
    
    @Autowired // Injeção de dependência automática pelo Spring
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/") // Mapeia requisições GET para a raiz da aplicação
    public String showForm(Model model) {
        // Adiciona um objeto User vazio ao modelo para o formulário
        model.addAttribute("user", new User(null, "", "", ""));
        // Adiciona a lista de usuários ao modelo para exibição
        model.addAttribute("users", userService.getAllUsers());
        return "index"; // Retorna o nome do template Thymeleaf
    }
    
    @PostMapping("/register") // Mapeia requisições POST para /register
    public String registerUser(@ModelAttribute User user, Model model) {
        // Salva o usuário através do serviço
        userService.addUser(user);
        // Redireciona para a página inicial
        return "redirect:/";
    }
    
    @GetMapping("/report") // Mapeia requisições GET para /report
    public String showReport(Model model) {
        // Adiciona a lista de usuários ao modelo para exibição no relatório
        model.addAttribute("users", userService.getAllUsers());
        return "report"; // Retorna o nome do template Thymeleaf para o relatório
    }
}
