package com.example.practicadocker.Entidad;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import java.lang.String;

@Entity
@EnableAutoConfiguration
public class Rol implements Serializable {
    @Id
    private
    String role;

    public Rol(){
    }
    public Rol(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}