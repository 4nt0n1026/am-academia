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

import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_ITEM_REFEICAO")
public class ItemRefeicao implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ITEM_REFEICAO")
    private int id;

    @Column(precision = 2, nullable = false)
    private double quantidade;

    @ManyToOne
    @JoinColumn(name = "ALIMENTO_ID", nullable = false)
    private Alimento alimento = new Alimento();

    public ItemRefeicao()
    {
    }

    @Override
    public String toString()
    {
        String item = new String();
        if (alimento != null && alimento.getUnidadeMedida() != null)
        {
            item = alimento.getNome() + " - " + quantidade + alimento.getUnidadeMedida().getSigla();
        }
        else
        {
            item = alimento.getNome();
        }
        return item;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(double quantidade)
    {
        this.quantidade = quantidade;
    }

    public Alimento getAlimento()
    {
        return alimento;
    }

    public void setAlimento(Alimento alimento)
    {
        this.alimento = alimento;
    }

}
