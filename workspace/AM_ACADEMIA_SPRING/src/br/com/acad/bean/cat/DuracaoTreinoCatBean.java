package br.com.acad.bean.cat;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.model.cat.DuracaoTreinoCat;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class DuracaoTreinoCatBean extends Bean<DuracaoTreinoCat> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private DuracaoTreinoCatDAO duracaoTreinoCatDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @Override
    public void beforeInit()
    {
        dao = duracaoTreinoCatDAO;
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new DuracaoTreinoCat();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
