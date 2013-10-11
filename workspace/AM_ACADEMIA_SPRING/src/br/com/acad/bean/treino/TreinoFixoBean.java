package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoFixo;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
@ManagedBean(name = "treinoFixoBean")
public class TreinoFixoBean extends Bean<TreinoFixo> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private TreinoFixoDAO treinoFixoDAO;
    @Autowired
    private DiasTreinoCatDAO diasTreinoCatDAO;
    @Autowired
    private DuracaoTreinoCatDAO duracaoTreinoCatDAO;
    @Autowired
    private FaixaEtariaCatDAO faixaEtariaCatDAO;
    @Autowired
    private ObjetivoCatDAO objetivoCatDAO;
    @Autowired
    private SexoCatDAO sexoCatDAO;
    @Autowired
    private ProfessorFuncDAO professorFuncDAO;
    @Autowired
    private DiaTreinoDAO diaTreinoDAO;
    @Autowired
    private ExercicioTreinoDAO exercicioTreinoDAO;

    private String textoTreino;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @Override
    public void beforeInit()
    {
        dao = treinoFixoDAO;
        superClasses = new Class<?>[] { Treino.class };
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new TreinoFixo();
        entity.setProfessor(new ProfessorFunc());
        entity.setData(Calendar.getInstance());
        entity.setTipoTreino(TipoTreinoDieta.FIXO);
    }

    @Override
    public void beforeShowFormDetail()
    {
        textoTreino = TreinoLogic.getTreinoString(entity);
        super.beforeShowFormDetail();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /**
     * busca todos DiasSemanasCat para preencher o field
     */
    public List<DiasTreinoCat> getDiasTreinoCatField()
    {
        return diasTreinoCatDAO.buscarTodos();
    }

    /**
     * busca todos DuracaoTreinoCat para preencher o field
     */
    public List<DuracaoTreinoCat> getDuracaoTreinoCatField()
    {
        return duracaoTreinoCatDAO.buscarTodos();
    }

    /**
     * busca todos FaixaEtariaCat para preencher o field
     */
    public List<FaixaEtariaCat> getFaixaEtariaCatField()
    {
        return faixaEtariaCatDAO.buscarTodos();
    }

    /**
     * busca todos ObjetivoCat para preencher o field
     */
    public List<ObjetivoCat> getObjetivoCatField()
    {
        return objetivoCatDAO.buscarTodos();
    }

    /**
     * busca todos SexoCat para preencher o field
     */
    public List<SexoCat> getSexoCatField()
    {
        return sexoCatDAO.buscarTodos();
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

    public String getTextoTreino()
    {
        return textoTreino;
    }

}
