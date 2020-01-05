package com.example.practicadocker.Entidad;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
public class Formulario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer pregunta1;
    private Integer pregunta2;
    private Integer pregunta3;
    private String  pregunta4;


    public Formulario(){

    }

    public Formulario(Integer pregunta1, Integer pregunta2, Integer pregunta3, String pregunta4) {
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
        this.pregunta4 = pregunta4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(Integer pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public Integer getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(Integer pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public Integer getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(Integer pregunta3) { this.pregunta3 = pregunta3; }
    public String getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(String pregunta4) {
        this.pregunta4 = pregunta4;
    }
}