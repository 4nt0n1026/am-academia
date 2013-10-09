package br.com.acad.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class TesteBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PostConstruct
    public void init()
    {
    }

    private String nomeChamada = "TesteConcluido";

    public String getNomeChamada()
    {
        return nomeChamada;
    }

    public void setNomeChamada(String nomeChamada)
    {
        this.nomeChamada = nomeChamada;
    }

}
