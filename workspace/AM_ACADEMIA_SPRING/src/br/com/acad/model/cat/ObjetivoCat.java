package br.com.acad.model.cat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.logic.PathLogic;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_OBJETIVO_CAT")
public class ObjetivoCat implements Serializable, GenericEntity
{

    public static final String[] STATIC_FIELDS = { "nome" };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_OBJETIVO_CAT")
    private int id;

    @Column(length = 255, nullable = true)
    @Show(label = "Icone", order = false, Type = FieldType.SMALL_IMAGE, pathName = "fotoLocalIconePath")
    private String fotoLocalIcone;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", filter = true)
    private String nome;

    public ObjetivoCat()
    {
    }

    public ObjetivoCat(int id, String nome)
    {
        super();
        this.id = id;
        this.nome = nome;
    }

    public ObjetivoCat(String nome)
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

    public String getFotoLocalIcone()
    {
        return fotoLocalIcone;
    }

    public void setFotoLocalIcone(String fotoLocalIcone)
    {
        this.fotoLocalIcone = fotoLocalIcone;
    }

    public String getFotoLocalIconePath()
    {
        if (fotoLocalIcone != null && fotoLocalIcone.length() > 1)
        {
            return "/" + PathLogic.PATH_ICONES + fotoLocalIcone + ".png";
        }
        return "/" + PathLogic.PATH_ICONES + "semFoto.jpg";
    }

}
