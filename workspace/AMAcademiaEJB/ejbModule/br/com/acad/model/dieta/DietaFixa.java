package br.com.acad.model.dieta;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_DIETA_FIXA")
@PrimaryKeyJoinColumn(name="ID_DIETA_ESPECIFICA")
public class DietaFixa extends Dieta {

	public static final String[] STATIC_FIELDS = {"data", "nome", "professor.nome", "sexoCat.nome", "faixaEtariaCat", "objeticoCat"};
	
	@ManyToMany
	@JoinTable(name="ACAD_DIETA_FIXA_LIMITACAO_CAT", 
				joinColumns={@JoinColumn(name="DIETA_FIXA_ID")},
				inverseJoinColumns={@JoinColumn(name="LIMITACAO_ID")})
	private Set<LimitacaoDietaCat> limitacoes = new HashSet<LimitacaoDietaCat>();
	
	@ManyToOne
	@JoinColumn(name="SEXO_ID", nullable=false)
	private SexoCat sexoCat;
	
	@ManyToOne
	@JoinColumn(name="FAIXA_ETARIA_ID", nullable=false)
	private FaixaEtariaCat faixaEtariaCat;
	
	@ManyToOne
	@JoinColumn(name="OBJETIVO_ID", nullable=false)
	private ObjetivoCat objetivoCat;
	
	public DietaFixa(){}

	public Set<LimitacaoDietaCat> getLimitacoes() {
		return limitacoes;
	}

	public void setLimitacoes(Set<LimitacaoDietaCat> limitacoes) {
		this.limitacoes = limitacoes;
	}

	public SexoCat getSexoCat() {
		return sexoCat;
	}

	public void setSexoCat(SexoCat sexoCat) {
		this.sexoCat = sexoCat;
	}

	public FaixaEtariaCat getFaixaEtariaCat() {
		return faixaEtariaCat;
	}

	public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat) {
		this.faixaEtariaCat = faixaEtariaCat;
	}

	public ObjetivoCat getObjetivoCat() {
		return objetivoCat;
	}

	public void setObjetivoCat(ObjetivoCat objetivoCat) {
		this.objetivoCat = objetivoCat;
	}

	
	
	
}
