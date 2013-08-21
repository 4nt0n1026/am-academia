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

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_ALIMENTO")
public class Alimento implements Serializable {

	public static final String[] STATIC_FIELDS = {"nome"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"nome", "valorEnergetico", "qtdProteina", "qtdGordura", "qtdCarboidrato"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"nome", "valorEnergetico", "qtdProteina", "qtdGordura", "qtdCarboidrato"};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ALIMENTO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(precision=2, nullable=false)
	private double valorEnergetico;
	
	@Column(precision=2, nullable=false)
	private double qtdProteina;
	
	@Column(precision=2, nullable=false)
	private double qtdGordura;
	
	@Column(precision=2, nullable=false)
	private double qtdCarboidrato;
	
	@Column(precision=2, nullable=false)
	private double unidade;
	
	@ManyToOne
	@JoinColumn(name="UNIDADE_MEDIDA_ID", nullable=false)
	private UnidadeMedida unidadeMedida;
	
	public Alimento(){}

	public Alimento(String nome, double valorEnergetico, double proteina, double gordura, double carboidrato, double unidade, UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.valorEnergetico = valorEnergetico;
		this.qtdProteina = proteina;
		this.qtdGordura = gordura;
		this.qtdCarboidrato = carboidrato;
		this.unidade = unidade;
		this.unidadeMedida = unidadeMedida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorEnergetico() {
		return valorEnergetico;
	}

	public void setValorEnergetico(double valorEnergetico) {
		this.valorEnergetico = valorEnergetico;
	}

	public double getQtdProteina() {
		return qtdProteina;
	}

	public void setQtdProteina(double qtdProteina) {
		this.qtdProteina = qtdProteina;
	}

	public double getQtdGordura() {
		return qtdGordura;
	}

	public void setQtdGordura(double qtdGordura) {
		this.qtdGordura = qtdGordura;
	}

	public double getQtdCarboidrato() {
		return qtdCarboidrato;
	}

	public void setQtdCarboidrato(double qtdCarboidrato) {
		this.qtdCarboidrato = qtdCarboidrato;
	}

	public double getUnidade() {
		return unidade;
	}

	public void setUnidade(double unidade) {
		this.unidade = unidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	
}
