package dio.loja.services.impl;

import dio.loja.model.User;
import dio.loja.repositories.UserRepository;
import dio.loja.services.UserService;
import dio.loja.services.exceptions.UserNotFoundExc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundExc("User not found"));
    }

    @Override
    public void inserir(User user) {
        userRepository.save(user);
    }

    @Override
    public void atualizar(Long id, User user) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundExc("User not found"));
        UpdateUser(newUser, user);
        userRepository.save(newUser);
    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    private void UpdateUser (User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
    }
}
