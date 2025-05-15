package com.example.user_registration.service;

import com.example.user_registration.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service // Anotação que marca esta classe como um componente de serviço gerenciado pelo Spring
public class UserService {
    
    private final List<User> users = new ArrayList<>(); // Armazenamento em memória
    private final AtomicLong counter = new AtomicLong(); // Gerador de IDs únicos
    
    // Método para adicionar um novo usuário
    public User addUser(User user) {
        User newUser = new User(counter.incrementAndGet(), user.getNome(), user.getEmail(), user.getTelefone());
        users.add(newUser);
        return newUser;
    }
    
    // Método para listar todos os usuários
    public List<User> getAllUsers() {
        return new ArrayList<>(users); // Retorna uma cópia da lista para evitar modificações externas
    }
}
