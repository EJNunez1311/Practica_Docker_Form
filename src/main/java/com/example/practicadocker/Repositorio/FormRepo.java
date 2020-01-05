package com.example.practicadocker.Repositorio;

import com.example.practicadocker.Entidad.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;

public interface FormRepo extends JpaRepository<Formulario,Long> {
    Formulario findAllById(Long Id);

    @Query(value = "SELECT sum(pregunta1) FROM Formulario")
    public Long sumpregunta1();
    @Query(value = "SELECT sum(pregunta2) FROM Formulario")
    public Long sumpregunta2();
    @Query(value = "SELECT sum(pregunta3) FROM Formulario")
    public Long sumpregunta3();
}
