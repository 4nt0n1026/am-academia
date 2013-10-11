package br.com.acad.bean.cat;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.model.cat.ObjetivoCat;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class ObjetivoCatBean extends Bean<ObjetivoCat> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private ObjetivoCatDAO objetivoCatDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @Override
    public void beforeInit()
    {
        dao = objetivoCatDAO;
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new ObjetivoCat();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
