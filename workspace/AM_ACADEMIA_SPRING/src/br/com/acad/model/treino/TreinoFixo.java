package br.com.acad.model.treino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_TREINO_FIXO")
@PrimaryKeyJoinColumn(name = "ID_TREINO_FIXO")
public class TreinoFixo extends Treino
{

    @ManyToOne
    @JoinColumn(name = "SEXO_ID", nullable = false)
    @Show(label = "Sexo", mappedName = "sexoCat.nome", order = true)
    private SexoCat sexoCat = new SexoCat();

    @ManyToOne
    @JoinColumn(name = "FAIXA_ETARIA_ID", nullable = false)
    @Show(label = "Faixa Etaria", mappedName = "faixaEtariaCat.nome", order = true)
    private FaixaEtariaCat faixaEtariaCat = new FaixaEtariaCat();

    @ManyToOne
    @JoinColumn(name = "OBJETIVO_ID", nullable = false)
    @Show(label = "Objetivo", mappedName = "objetivoCat.nome", order = true)
    private ObjetivoCat objetivoCat = new ObjetivoCat();

    @ManyToOne
    @JoinColumn(name = "DURACAO_TREINO_ID", nullable = false)
    @Show(label = "Duração", mappedName = "duracaoTreinoCat.nome", order = true)
    private DuracaoTreinoCat duracaoTreinoCat = new DuracaoTreinoCat();

    @ManyToOne
    @JoinColumn(name = "DIAS_SEMANA_ID", nullable = false)
    @Show(label = "Dias na Semana", mappedName = "diasTreinoCat.nome", order = true)
    private DiasTreinoCat diasTreinoCat = new DiasTreinoCat();

    public TreinoFixo()
    {
    }

    public SexoCat getSexoCat()
    {
        return sexoCat;
    }

    public void setSexoCat(SexoCat sexoCat)
    {
        this.sexoCat = sexoCat;
    }

    public FaixaEtariaCat getFaixaEtariaCat()
    {
        return faixaEtariaCat;
    }

    public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat)
    {
        this.faixaEtariaCat = faixaEtariaCat;
    }

    public ObjetivoCat getObjetivoCat()
    {
        return objetivoCat;
    }

    public void setObjetivoCat(ObjetivoCat objetivoCat)
    {
        this.objetivoCat = objetivoCat;
    }

    public DuracaoTreinoCat getDuracaoTreinoCat()
    {
        return duracaoTreinoCat;
    }

    public void setDuracaoTreinoCat(DuracaoTreinoCat duracaoTreinoCat)
    {
        this.duracaoTreinoCat = duracaoTreinoCat;
    }

    public DiasTreinoCat getDiasTreinoCat()
    {
        return diasTreinoCat;
    }

    public void setDiasTreinoCat(DiasTreinoCat diasTreinoCat)
    {
        this.diasTreinoCat = diasTreinoCat;
    }

}
