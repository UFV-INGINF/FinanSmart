package com.proyectos.FinanSmart;

import static org.assertj.core.api.Assertions.assertThat;

import com.proyectos.FinanSmart.model.Usuario;
import com.proyectos.FinanSmart.services.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class DatabaseTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        // ✅ Crear un usuario utilizando el constructor vacío y setters
        Usuario usuario = new Usuario();
        usuario.setUsername("testuser");
        usuario.setEmail("test@example.com");
        usuario.setPassword("securepassword");

        // Guardar el usuario en la base de datos
        userRepository.save(usuario);

        // Buscar el usuario por nombre
        Optional<Usuario> foundUser = userRepository.findByUsername("testuser");

        // Verificar que el usuario fue encontrado
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("test@example.com");
    }
}