package com.example.voteExtractorRest.modelos;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table (name="usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user", nullable = false, length = 50, unique = true)
    private String user;
    @Column(name = "psw", nullable = false, length = 50)
    private String psw;
    @Column(name = "cpasw", nullable = false, length = 50)
    private String cpasw;
    @Column(name = "rol", nullable = false, length = 2)
    private int rol;

   

    public Usuario() {
    }

    public Usuario(int id, String user, String psw, String cpasw,int rol) {
        this.id = id;
        this.user = user;
        this.psw = psw;
        this.cpasw = cpasw;
        this.rol = rol;

    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpasw() {
        return psw;
    }

    public void setCpasw(String cpasw) {
        this.cpasw = cpasw;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario[id=%d,user='%s'psw='%s',cpsw='%s',rol=%d,",id,user,psw,cpasw,rol);
    }
}
