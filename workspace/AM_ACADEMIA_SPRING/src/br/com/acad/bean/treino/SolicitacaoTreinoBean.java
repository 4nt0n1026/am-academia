package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.SolicitacaoTreino;
import br.com.acad.model.treino.TreinoEspecifico;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class SolicitacaoTreinoBean extends Bean<SolicitacaoTreino> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private SolicitacaoTreinoDAO solicitacaoTreinoDAO;
    @Autowired
    private AlunoDAO alunoDAO;
    @Autowired
    private TreinoEspecificoDAO treinoEspecificoDAO;
    @Autowired
    private ProfessorFuncDAO professorFuncDAO;

    private boolean showTreino;
    private TreinoEspecifico treino;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void init()
    {
        dao = solicitacaoTreinoDAO;
        super.init();
    }

    /**
     * show form de entity
     */
    @Override
    public void showNewEntity()
    {
        showEntity = true;
        entity = new SolicitacaoTreino();
        entity.setDataSolicitacao(Calendar.getInstance());
        entity.setRespondido(false);
        entity.setAluno(new Aluno());
    }

    /**
     * Responde a solicitacao criando um treinoEspecico
     */
    public void responder()
    {
        if (entity != null)
        {
            if (!entity.isRespondido())
            {
                showTreino = true;
                treino = new TreinoEspecifico();
                treino.setProfessor(new ProfessorFunc());
            }
            else
            {
                MessagesLogic.addErrorMessage("Erro", "Solicitação já respondida");
            }
        }
        else
        {
            MessagesLogic.addWarnMessage("Erro", "Selecione uma solicitação para ser respondida");
        }
    }

    /**
     * Sobreescrita do metodo close forms para fecha o form de treino junto
     */
    @Override
    public void closeForms()
    {
        showTreino = false;
        super.closeForms();
    }

    /**
     * inclui treino especifico no banco referente a solicitacao respondida
     */
    public void incluirTreinoResposta()
    {
        treino.setSolicitacao(entity);
        treino.setData(Calendar.getInstance());

        // Nome do treino
        Aluno aluno = treino.getSolicitacao().getAluno();
        aluno = alunoDAO.searchById(aluno.getId());
        aluno.incrementNumSolicitacao();
        // Salva aluno
        aluno = alunoDAO.update(aluno);

        // Seta nome
        treino.setNomePronto(aluno);

        // Salva o treino
        treino = treinoEspecificoDAO.insert(treino);

        // Inclui nos treinos do aluno
        aluno.addTreino(treino);

        // Salva aluno
        aluno = alunoDAO.update(aluno);

        entity.setRespondido(true);
        incluirEntity();

        closeForms();
        atualizar();

    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /**
     * busca todos alunos para preencher o field
     */
    public List<Aluno> getAlunosField()
    {
        return alunoDAO.buscarFieldNome();
    }

    /**
     * busca todos ProfessorFunc para preencher o field
     */
    public List<ProfessorFunc> getProfessorFuncField()
    {
        return professorFuncDAO.buscarFieldNomeProf();
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

    public boolean getShowTreino()
    {
        return showTreino;
    }

    public TreinoEspecifico getTreino()
    {
        return treino;
    }

    public void setTreino(TreinoEspecifico treino)
    {
        this.treino = treino;
    }

}
