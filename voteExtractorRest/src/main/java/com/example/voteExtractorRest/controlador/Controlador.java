package com.example.voteExtractorRest.controlador;

import com.example.voteExtractorRest.dao.UsuariosDao;
import com.example.voteExtractorRest.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/")
public class Controlador {

    @Autowired
    private UsuariosDao ud;

   


    /**
     * Listamos todos los usuarios dado un rol
     *
     * @param rol
     * @return List<Usuario></Usuario>
     */
    @RequestMapping(value = "usuarios/{rol}", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findfindByRol(@PathVariable("rol") int rol) {

        // Se conecta y busca los usuarios
        List<Usuario> l = ud.findByRol(rol);
        // Devolvemos la ista de usuarios
        return ResponseEntity.ok(l);
    }


    /**
     * Metodo para realizar el login
     *
     * @param user
     * @param psw
     * @return
     */
    @RequestMapping(value = "login/{user}/{psw}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByUserAndPsw(@PathVariable("user") String user, @PathVariable("psw") String psw) {
        // Buscamos el usuario  por usuario y contraseña

        Optional<Usuario> op = ud.findByUserAndPsw(user, psw);
        // Devolvemos el usuario si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    /**
     * Método para comprobar que existe el nombre de usuario a la hora de hacer un registro
     * @param nick
     * @return
     */
    @RequestMapping(value = "comproRegistro/{user}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByUser(@PathVariable("user") String user) {
        // Buscamos el usuario por usuario

        Optional<Usuario> op = ud.findByUser(user);
        // Devolvemos el usuario si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }



    /**
     * Metodo para insertar un usuario nuevo
     *
     * @param user
     * @return Usuario
     */
    @RequestMapping(value = "registro", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
        //Se crea un usuario nuevo a partir del que ha llegado
        Usuario p = ud.save(user);

        //devolvemos el nuevo usuario
        return ResponseEntity.ok(p);
    }

    /**
     * Método para borrar un usuario
     * @param id
     * @return Usuario
     */
    @RequestMapping(value = "borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id) {
        // Buscamos el usuario por id
        Optional<Usuario> op = ud.findById(id);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Usuario p = op.get();
            ud.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para actualizar los datos del usuario
     * @param id
     * @param u
     * @return Usuario
     */
   @RequestMapping(value = "updateTok/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario u) {
    // Buscamos el usuario por id
        Optional<Usuario> op = ud.findById(id);
    // Devolvemos el usuario si existe.
        if (op.isPresent()) {
    // Le pasamos los datos
            Usuario p = op.get();
            p.setUser(u.getUser());
            p.setPsw(u.getPsw());
            p.setCpasw(u.getPsw());
            p.setRol(u.getRol());
            ud.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
