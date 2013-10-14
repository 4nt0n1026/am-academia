package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoEspecifico;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class TreinoEspecificoBean extends Bean<TreinoEspecifico> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private TreinoEspecificoDAO treinoEspecificoDAO;
    @Autowired
    private ProfessorFuncDAO professorFuncDAO;
    @Autowired
    private DiaTreinoDAO diaTreinoDAO;
    @Autowired
    private AlunoDAO alunoDAO;

    public String textoTreino;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void beforeInit()
    {
        dao = treinoEspecificoDAO;
        superClasses = new Class<?>[] { Treino.class };
    }

    /**
     * show form de entity Não é possivel incluir um treino especifico. Precisa ser por meio de resposta a uma
     * solicitação. Metodo nao implementado
     */
    @Override
    public void beforeShowNewEntity()
    {
    }

    /**
     * inclui ou edita entity no banco
     */
    @Override
    public void beforeSaveEntity()
    {
        // incrementa numeracao de solicitacoes
        if (entity != null && entity.getId() == 0)
        {
            Aluno aluno = entity.getSolicitacao().getAluno();
            aluno.incrementNumSolicitacao();
            alunoDAO.update(aluno);
            entity.setNomePronto(aluno);
        }
        super.beforeSaveEntity();
    }

    @Override
    public void beforeShowFormDetail()
    {
        entity.generateTreinoStr(diaTreinoDAO);
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

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

    public String getTextoTreino()
    {
        return textoTreino;
    }

}
