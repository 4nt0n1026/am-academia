package br.com.acad.model.horario;

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
@Table(name = "ACAD_UNIDADE")
public class Unidade implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_UNIDADE")
    private int id;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", filter = true)
    private String nome;

    @Column(length = 500, nullable = true)
    private String fotoLocal;

    @Column(length = 500, nullable = true)
    private String descricao;

    public Unidade()
    {
    }

    public Unidade(Integer id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public Unidade(String nome, String descricao)
    {
        this.descricao = descricao;
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

    public String getFotoLocal()
    {
        return fotoLocal;
    }

    public void setFotoLocal(String fotoLocal)
    {
        this.fotoLocal = fotoLocal;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
}
