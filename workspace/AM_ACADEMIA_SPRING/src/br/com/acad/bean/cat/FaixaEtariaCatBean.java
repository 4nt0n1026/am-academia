package br.com.acad.bean.cat;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.model.cat.FaixaEtariaCat;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class FaixaEtariaCatBean extends Bean<FaixaEtariaCat> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private FaixaEtariaCatDAO faixaEtariaCatDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void init()
    {
        dao = faixaEtariaCatDAO;
        super.init();
    }

    /**
     * show form de entity
     */
    @Override
    public void showNewEntity()
    {
        showEntity = true;
        entity = new FaixaEtariaCat();
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
