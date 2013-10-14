package br.com.acad.model.treino;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_EXERCICIO_TREINO")
public class ExercicioTreino implements Serializable, GenericEntity
{

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EXERCICIO_TREINO")
    private int id;

    @ManyToOne
    @JoinColumn(name = "EXERCICIO_ID", nullable = false)
    private Exercicio exercicio = new Exercicio();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EXERCICIO_TREINO_ID")
    private Set<Serie> series = new HashSet<Serie>();

    // Metodos
    public boolean addSerie(Serie serie)
    {
        serie.setOrdem(series.size());
        return series.add(serie);
    }

    public void resetSerie()
    {
        series = new HashSet<Serie>();
    }

    public String getSeriesString()
    {
        return TreinoLogic.getSerieString(this);
    }

    // Construtores
    public ExercicioTreino()
    {
    }

    public ExercicioTreino(int id, Exercicio exercicio, Set<Serie> series)
    {
        super();
        this.id = id;
        this.exercicio = exercicio;
        this.series = series;
    }

    // Gets e Sets
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Exercicio getExercicio()
    {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio)
    {
        this.exercicio = exercicio;
    }

    public Set<Serie> getSeries()
    {
        return series;
    }

    public void setSeries(Set<Serie> series)
    {
        this.series = series;
    }

}
