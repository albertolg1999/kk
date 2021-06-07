package com.example.voteExtractorRest.dao;

import com.example.voteExtractorRest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {

   //para comprobar el login
    Optional<Usuario> findByUserAndPsw (@Param("user") String user, @Param("psw") String psw);

    //para comprobar que al registrar no se repita el nombre de usuario
    Optional<Usuario> findByUser (@Param("user") String user);
    //para obtener los usuarios de un determinado rol, en nuestro caso nos servir� para obtener los del rol 1, para hacer el crud
    List<Usuario> findByRol (@Param("rol") int rol);
    

}
