package br.com.acad.bean.avisos;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.model.avisos.NoticiaCat;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class NoticiaCatBean extends Bean<NoticiaCat> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private NoticiaCatDAO noticiaCatDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void beforeInit()
    {
        dao = noticiaCatDAO;
    }

    /**
     * show form de entity
     */
    @Override
    public void beforeShowNewEntity()
    {
        entity = new NoticiaCat();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
