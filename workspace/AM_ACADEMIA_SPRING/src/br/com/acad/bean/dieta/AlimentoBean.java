package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.model.dieta.Alimento;
import br.com.acad.model.dieta.UnidadeMedida;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class AlimentoBean extends Bean<Alimento> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private AlimentoDAO alimentoDAO;
    @Autowired
    private UnidadeMedidaDAO unidadeMedidaDAO;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void init()
    {
        dao = alimentoDAO;
        super.init();
    }

    /**
     * show form de entity
     */
    @Override
    public void showNewEntity()
    {
        showEntity = true;
        entity = new Alimento();
        entity.setUnidadeMedida(new UnidadeMedida());
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /**
     * busca todas as unidades de medida para preencher o field
     */
    public List<UnidadeMedida> getUnidadeMedidaField()
    {
        return unidadeMedidaDAO.buscarFieldNome();
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

}
