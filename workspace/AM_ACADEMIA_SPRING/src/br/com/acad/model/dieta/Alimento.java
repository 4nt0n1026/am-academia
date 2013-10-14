package br.com.acad.model.dieta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_ALIMENTO")
public class Alimento implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALIMENTO")
    private int id;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", order = true, filter = true)
    private String nome;

    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(precision = 2, nullable = false)
    @Show(label = "Valor Energetico", Type = FieldType.DOUBLE, order = true, filter = true)
    private double valorEnergetico;

    @Column(precision = 2, nullable = false)
    @Show(label = "Qtd Proteina", Type = FieldType.DOUBLE, order = true, filter = true)
    private double qtdProteina;

    @Column(precision = 2, nullable = false)
    @Show(label = "Qtd Carboidrato", Type = FieldType.DOUBLE, order = true, filter = true)
    private double qtdCarboidrato;

    @Column(precision = 2, nullable = false)
    @Show(label = "Qtd Gordura", Type = FieldType.DOUBLE, order = true, filter = true)
    private double qtdGordura;

    @Column(precision = 2, nullable = false)
    @Show(label = "Unidade", Type = FieldType.DOUBLE, order = true, filter = true)
    private double unidade;

    @ManyToOne
    @JoinColumn(name = "UNIDADE_MEDIDA_ID", nullable = false)
    @Show(label = "Unidade", mappedName = "unidadeMedida.nome", linkMap = "/xhtml/dieta/unidadeMedida.xhtml", order = true, filter = true)
    private UnidadeMedida unidadeMedida;

    public Alimento()
    {
    }

    public Alimento(String nome, double valorEnergetico, double proteina, double gordura, double carboidrato, double unidade,
            UnidadeMedida unidadeMedida)
    {
        this.nome = nome;
        this.valorEnergetico = valorEnergetico;
        this.qtdProteina = proteina;
        this.qtdGordura = gordura;
        this.qtdCarboidrato = carboidrato;
        this.unidade = unidade;
        this.unidadeMedida = unidadeMedida;
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

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public double getValorEnergetico()
    {
        return valorEnergetico;
    }

    public void setValorEnergetico(double valorEnergetico)
    {
        this.valorEnergetico = valorEnergetico;
    }

    public double getQtdProteina()
    {
        return qtdProteina;
    }

    public void setQtdProteina(double qtdProteina)
    {
        this.qtdProteina = qtdProteina;
    }

    public double getQtdGordura()
    {
        return qtdGordura;
    }

    public void setQtdGordura(double qtdGordura)
    {
        this.qtdGordura = qtdGordura;
    }

    public double getQtdCarboidrato()
    {
        return qtdCarboidrato;
    }

    public void setQtdCarboidrato(double qtdCarboidrato)
    {
        this.qtdCarboidrato = qtdCarboidrato;
    }

    public double getUnidade()
    {
        return unidade;
    }

    public void setUnidade(double unidade)
    {
        this.unidade = unidade;
    }

    public UnidadeMedida getUnidadeMedida()
    {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida)
    {
        this.unidadeMedida = unidadeMedida;
    }

}
