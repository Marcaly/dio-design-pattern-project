package dio.loja.controllers;

import dio.loja.model.User;
import dio.loja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    public ResponseEntity<List<User>> buscarTodos() {
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        return  ResponseEntity.ok(userService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<User> inserir(@RequestBody User user) {
        userService.inserir(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user) {
        userService.atualizar(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
