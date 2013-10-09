package br.com.acad.model.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_ESTADO")
public class Estado implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ESTADO")
    private int id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 2, nullable = false)
    private String sigla;

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

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

}
