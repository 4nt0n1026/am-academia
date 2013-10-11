package br.com.acad.bean.cat;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.model.cat.SexoCat;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class SexoCatBean extends Bean<SexoCat> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private SexoCatDAO sexoCatDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @Override
    public void beforeInit()
    {
        dao = sexoCatDAO;
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new SexoCat();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
