package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.PessoaLogic;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class SolicitacaoDietaBean extends Bean<SolicitacaoDieta> implements Serializable
{

    // ************************************************************************************************************//*
    // ATRIBUTOS
    // ************************************************************************************************************//*

    @Autowired
    private SolicitacaoDietaDAO solicitacaoDietaDAO;
    @Autowired
    private AlunoDAO alunoDAO;
    @Autowired
    private DietaEspecificaDAO dietaEspecificaDAO;
    @Autowired
    private ProfessorFuncDAO professorFuncDAO;

    private boolean showDieta;
    private DietaEspecifica dieta;

    // ************************************************************************************************************//*
    // METODOS
    // ************************************************************************************************************//*

    @Override
    public void beforeInit()
    {
        dao = solicitacaoDietaDAO;
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new SolicitacaoDieta();
        entity.setAluno(new Aluno());
        entity.setDataSolicitacao(Calendar.getInstance());
        entity.setRespondido(false);
    }

    /**
     * Responde a solicitacao criando um dietaEspecico
     */
    public void responder()
    {
        if (entity != null)
        {
            showDieta = true;
            dieta = new DietaEspecifica();
            dieta.setProfessor(new ProfessorFunc());
        }
        else
        {
            MessagesLogic.addWarnMessage("Erro", "Selecione uma solicitação para ser respondida");
        }
    }

    /**
     * Sobreescrita do metodo close forms para fecha o form de dieta junto
     */
    @Override
    public void closeForms()
    {
        showDieta = false;
        super.closeForms();
    }

    /**
     * inclui dieta especifico no banco referente a solicitacao respondida
     */
    public void incluirDietaResposta()
    {
        dieta.setSolicitacao(entity);
        dieta.setData(Calendar.getInstance());
        closeForms();
        atualizar();
        entity.setRespondido(true);
        beforeSaveEntity();
    }

    // ************************************************************************************************************//*
    // GET FIELDS
    // ************************************************************************************************************//*

    /**
     * busca todos alunos para preencher o field
     */
    public List<Aluno> getAlunosField()
    {
        return alunoDAO.buscarFieldNome();
    }

    /**
     * Mostra a idade do aluno a partir da data de nascimento
     * 
     * @return
     */
    public int getIdadeAlunoDetail()
    {
        if (entity != null && entity.getAluno() != null && entity.getAluno().getDataNascimento() != null)
        {
            return PessoaLogic.getIdade(entity.getAluno().getDataNascimento());
        }
        else
        {
            return 0;
        }
    }

    /**
     * busca todos ProfessorFunc para preencher o field
     */
    public List<ProfessorFunc> getProfessorFuncField()
    {
        return professorFuncDAO.buscarFieldNomeProf();
    }

    // ************************************************************************************************************//*
    // GETS E SETS
    // ************************************************************************************************************//*

    public boolean getShowDieta()
    {
        return showDieta;
    }

    public DietaEspecifica getDieta()
    {
        return dieta;
    }

    public void setDieta(DietaEspecifica dieta)
    {
        this.dieta = dieta;
    }

}
