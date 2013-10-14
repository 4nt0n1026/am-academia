package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.annotation.Show;
import br.com.acad.model.GenericEntity;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ACAD_DIETA")
public class Dieta implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DIETA")
    private int id;

    @Temporal(TemporalType.DATE)
    @Show(label = "Data", order = true, filter = true)
    private Calendar data;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", order = true, filter = true)
    private String nome;

    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(length = 2, nullable = false)
    private int tempo;

    @Column(nullable = false)
    private TipoTreinoDieta tipoDieta;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID", nullable = true)
    @Show(label = "Professor", mappedName = "professor.nome", order = true, filter = true)
    private ProfessorFunc professor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DIETA_ID", nullable = true)
    private Set<DiaDieta> diasDieta = new HashSet<DiaDieta>();

    // Metodos
    public boolean addDiaDieta(DiaDieta dia)
    {
        return diasDieta.add(dia);
    }

    public boolean removeDiaDieta(DiaDieta dia)
    {
        return diasDieta.remove(dia);
    }

    /**
     * Apaga lista de DiaDieta
     */
    public void resetDiasDieta()
    {
        this.diasDieta = new HashSet<DiaDieta>();
    }

    public Dieta()
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

    public Calendar getData()
    {
        return data;
    }

    public void setData(Calendar data)
    {
        this.data = data;
    }

    public ProfessorFunc getProfessor()
    {
        return professor;
    }

    public void setProfessor(ProfessorFunc professor)
    {
        this.professor = professor;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public int getTempo()
    {
        return tempo;
    }

    public void setTempo(int tempo)
    {
        this.tempo = tempo;
    }

    public TipoTreinoDieta getTipoDieta()
    {
        return tipoDieta;
    }

    public void setTipoDieta(TipoTreinoDieta tipoDieta)
    {
        this.tipoDieta = tipoDieta;
    }

    public Set<DiaDieta> getDiasDieta()
    {
        return diasDieta;
    }

    public void setDiasDieta(Set<DiaDieta> diasDieta)
    {
        this.diasDieta = diasDieta;
    }

}
