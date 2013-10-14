package br.com.acad.model.cat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_SEXO_CAT")
public class SexoCat implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SEXO_CAT")
    private int id;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", filter = true)
    private String nome;

    public SexoCat()
    {
    }

    public SexoCat(int id, String nome)
    {
        super();
        this.id = id;
        this.nome = nome;
    }

    public SexoCat(String nome)
    {
        this.nome = nome;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

}
