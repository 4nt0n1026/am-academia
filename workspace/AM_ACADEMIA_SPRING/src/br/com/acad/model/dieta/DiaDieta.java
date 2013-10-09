package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_DIA_DIETA")
public class DiaDieta implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DIA_DIETA")
    private int id;

    @Column(length = 255, nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DIA_DIETA_ID")
    private Set<Refeicao> refeicoes = new HashSet<Refeicao>();

    // Metodos
    public boolean addRefeicao(Refeicao refeicao)
    {
        return refeicoes.add(refeicao);
    }

    public boolean removeRefeicao(Refeicao refeicao)
    {
        return refeicoes.remove(refeicao);
    }

    /**
     * Apaga lista de Refeicao
     */
    public void resetRefeicoes()
    {
        this.refeicoes = new HashSet<Refeicao>();
    }

    public DiaDieta()
    {
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

    public Set<Refeicao> getRefeicoes()
    {
        return refeicoes;
    }

    public void setRefeicoes(Set<Refeicao> refeicoes)
    {
        this.refeicoes = refeicoes;
    }

}
