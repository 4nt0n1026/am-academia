package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqSolicitacaoTreino", sequenceName="SEQ_SOLICITACAO_TREINO", allocationSize=1)
@Table(name="ACAD_SOLICITACAO_TREINO")
public class SolicitacaoTreino implements Serializable {

	public static final String[] STATIC_FIELDS = {"dataSolicitacao", "aluno.nome", "descricao" };
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"dataSolicitacao", "aluno.nome", "respondido"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Data", "Aluno", "Respondido"};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSolicitacaoTreino")
	@Column(name="ID_SOLICITACAO_TREINO")
	private int id;
	
	@Column(length=500, nullable=false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_SOLICITACAO", nullable=false)
	private Calendar dataSolicitacao;
	
	@Column(nullable=false)
	private boolean respondido;

	@ManyToOne
	@JoinColumn(name="ALUNO_ID", nullable=false)
	private Aluno aluno;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TREINO_ESPECIFICO_ID", nullable=true)
	private TreinoEspecifico treinoEspecifico;
	
	public SolicitacaoTreino(){}
	
	public SolicitacaoTreino(int id, String descricao,
			Calendar dataSolicitacao, boolean respondido) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataSolicitacao = dataSolicitacao;
		this.respondido = respondido;
	}

	public SolicitacaoTreino(Integer id, Calendar dataSolicitacao) {
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
	
}
