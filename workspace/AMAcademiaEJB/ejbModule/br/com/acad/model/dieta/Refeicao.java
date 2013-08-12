package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqRefeicao", sequenceName="SEQ_REFEICAO", allocationSize=1)
@Table(name="ACAD_REFEICAO")
public class Refeicao implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRefeicao")
	@Column(name="ID_REFEICAO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name="REFEICAO_ID", nullable=true)
	private Set<ItemRefeicao> itens = new HashSet<ItemRefeicao>();
	
	//Metodos
	public boolean addItem(ItemRefeicao item){
		return itens.add(item);
	}
	
	public boolean removeItem(ItemRefeicao item){
		return itens.remove(item);
	}
	
	/**
	 * Apaga lista de Refeicao
	 */
	public void resetItens(){
		this.itens = new HashSet<ItemRefeicao>();
	}
	
	public Refeicao(){}

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

	public Set<ItemRefeicao> getItens() {
		return itens;
	}

	public void setItens(Set<ItemRefeicao> itens) {
		this.itens = itens;
	}
	
	
	
}
