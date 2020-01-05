package com.example.practicadocker.Servicio;

import com.example.practicadocker.Entidad.Formulario;
import com.example.practicadocker.Repositorio.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FormularioServices {
    @Autowired
    private FormRepo FormRepo;


    @Transactional
    public Formulario crearFormulario(Formulario formulario){
        FormRepo.save(formulario);
        return formulario;
    }

    public List<Formulario> listaFormulario(){
        return  FormRepo.findAll();
    }

    public Long SumPregunta1 (){ return FormRepo.sumpregunta1(); }
    public Long SumPregunta2 (){ return FormRepo.sumpregunta2(); }
    public Long SumPregunta3 (){ return FormRepo.sumpregunta3(); }

}
