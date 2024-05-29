package dio.loja.services;

import dio.loja.model.User;

import java.util.List;

public interface UserService {

    List<User> buscarTodos();

    User buscarPorId(Long id);

    void inserir(User user);

    void atualizar(Long id, User user);

    void deletar(Long id);

}
