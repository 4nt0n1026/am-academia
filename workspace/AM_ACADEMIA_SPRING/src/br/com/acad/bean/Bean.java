package br.com.acad.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlForm;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.Filterlogic;
import br.com.acad.logic.FormLogic;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.SqlLogic;
import br.com.acad.logic.TableLogic;
import br.com.acad.logic.model.DataField;
import br.com.acad.logic.model.DataFilter;
import br.com.acad.model.GenericEntity;

/**
 * Bean generico com metodos, atributos e assinaturas que todos beans devem possuir.
 * 
 * @author Christian Storch
 * 
 * @param <T>
 */
public abstract class Bean<T extends GenericEntity>
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    // DAO
    protected DAO<T, Integer> dao;

    // Navigation Bean
    @Autowired
    private NavigationBean navigationBean;

    // Bean Name
    protected String beanName;

    // Entity
    protected T entity;
    protected List<T> entities;

    // Super Classes
    protected Class<?>[] superClasses;

    // Style Classes
    protected String[] tableClasses;
    protected String[] rowClasses;

    // Dynamic Form
    protected HtmlForm panelForm;
    protected DataField[] formValues;

    // Dynamic Table
    protected HtmlDataTable dataTable;
    protected HtmlColumn selectButtonColumn;
    protected DataField[] tableValues;

    // Search
    protected String[] staticFields;
    protected String search;

    // Filter
    protected boolean showFilter = false;
    protected DataFilter[] dataFilters;

    // Paginação
    protected int page = 1;
    protected long totalPages;
    protected long totalEntities;

    // View
    protected String permanentView;
    protected String view;
    protected String[] staticViewsValue;
    protected String[] staticViewsLabel;

    // Ordenacao
    protected String order;
    protected int initialOrder = 0;
    protected String[] staticFieldsOrderValue;
    protected String[] staticFieldsOrderLabel;

    // Navigation
    protected boolean showEntity;
    protected boolean showEntity2;
    protected boolean showEntity3;
    protected boolean showEntity4;

    // Detail
    protected boolean showEntityDetail;

    /************************************************************************************************************/
    // ASSINATURAS E METODOS A SER HERDADOS
    /************************************************************************************************************/

    public abstract void beforeShowNewEntity();

    public abstract void beforeInit();

    public void beforeShowEditEntity()
    {
    }

    public void beforeShowFormDetail()
    {
    }

    public void beforeSaveEntity()
    {
    }

    public void afterSaveEntity()
    {
    }

    public void beforeDeleteEntity()
    {
    }

    public void afterDeleteEntity()
    {
    }

    public void beforeInitRefresh()
    {
    }

    /************************************************************************************************************/
    // DYNAMIC FILTER
    /************************************************************************************************************/
    public void showResult()
    {
        for (DataFilter filter : dataFilters)
        {
            System.out.println(filter.getLabel() + " " + filter.getOperator() + " " + filter.getValue());
        }
    }

    /************************************************************************************************************/
    // DYNAMIC FORM
    /************************************************************************************************************/

    private void prepareForm()
    {
        panelForm = new HtmlForm();
        // InputText inputText = new InputText();
        // inputText.setValueExpression("#{diasTreinoCatBean.entsity.nome}",
        // createValueExpression(inputValue.getValue(), Object.class));
        // panelForm.getChildren().add(inp)
        if (formValues != null)
        {
            for (int i = 0; i < formValues.length; i++)
            {
                FormLogic.prepareFormField(panelForm, formValues[i]);
            }
        }
    }

    /************************************************************************************************************/
    // DYNAMIC TABLE
    /************************************************************************************************************/
    private void populateDynamicDataTable()
    {

        // Create <h:dataTable >.
        dataTable = new HtmlDataTable();

        // Create <h:column>.
        // selectButtonColumn = new HtmlColumn();
        // dataTable.getChildren().add(0, selectButtonColumn);

        // Iterate over columns.
        if (tableValues != null)
        {
            for (int i = 0; i < tableValues.length; i++)
            {
                // Create <h:column>.
                HtmlColumn column = new HtmlColumn();
                dataTable.getChildren().add(column);

                TableLogic.prepareColumnValue(column, tableValues[i]);

                TableLogic.prepareColumnLink(column, tableValues[i], navigationBean);
            }
        }

    }

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    public void init()
    {
        beforeInit();

        Class<?>[] arrayClasses = buildClassArray();

        if (staticFields == null)
        {
            staticFields = AnnotationsLogic.getSearchValueFields(arrayClasses);
        }
        if (staticFieldsOrderLabel == null)
        {
            staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(arrayClasses);
            staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(arrayClasses);
        }
        if (order == null && staticFieldsOrderLabel != null)
        {
            order = staticFieldsOrderLabel[initialOrder];
        }
        if (order == null && staticFields != null)
        {
            order = staticFields[initialOrder];
        }
        if (staticViewsLabel == null)
        {
            staticViewsLabel = AnnotationsLogic.getViewLabelFields(arrayClasses);
            staticViewsValue = AnnotationsLogic.getViewValueFields(arrayClasses);
        }
        if (staticViewsLabel != null)
        {
            view = staticViewsLabel[0];
        }

        if (tableValues == null)
        {
            tableValues = TableLogic.getTableValues(arrayClasses);
        }

        if (formValues == null)
        {
            formValues = FormLogic.getFormValues(beanName, arrayClasses);
        }

        if (dataFilters == null)
        {
            dataFilters = Filterlogic.getFilterValues(arrayClasses);
        }

        beforeInitRefresh();

        atualizar();
    }

    /**
     * Ao selecionar uma linha da tabela
     */
    public void selectRow(T entity)
    {
        this.entity = entity;
        showFormDetail();
    }

    /**
     * Abre painel de inclusao de nova entity
     */
    public final void showFormFilter()
    {
        if (showFilter == false)
        {
            showFilter = true;
        }
        else
        {
            showFilter = false;
        }
        System.out.println(showFilter);
    }

    /**
     * Abre painel de inclusao de nova entity
     */
    public final void showNewEntity()
    {
        showEntity = true;
        beforeShowNewEntity();
    }

    /**
     * fecha painel de edicao de uma entity
     */
    public final void dontShowEntity()
    {
        closeForms();
    }

    /**
     * mostra painel de edicao de uma Entity
     */
    public final void showEditEntity()
    {
        if (entity != null)
        {
            showEntity = true;
            showEntity2 = false;
            showEntity3 = false;
            showEntity4 = false;
            showEntityDetail = false;

            beforeShowEditEntity();
        }
        else
        {
            MessagesLogic.addWarnMessage("Erro", "Selecione um para editar");
        }
    }

    /**
     * atualiza pagina
     */
    public final void atualizar()
    {
        try
        {
            closeForms();
            atualizaPages();
            entities = buscarTodos();
        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o administrador");
            e.printStackTrace();
        }
    }

    /**
     * Apaga o filtro de search
     */
    public final void resetSearch()
    {
        search = "";
        atualizar();
    }

    /**
     * atualiza pagina com msg de sucesso
     */
    public final void atualizarComMsg()
    {
        atualizar();
        MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
    }

    /**
     * proxima tela da tabela.
     */
    public final void nextPageTable()
    {
        if (page < totalPages)
        {
            page++;
            atualizar();
        }
        else
        {
            MessagesLogic.addWarnMessage("Aviso", "ultima pagina");
        }
    }

    /**
     * tela anterior da tabela.
     */
    public final void previousPageTable()
    {
        if (page > 1)
        {
            page--;
            atualizar();
        }
        else
        {
            MessagesLogic.addWarnMessage("Aviso", "primeira pagina");
        }
    }

    /**
     * abre formulario 1. Utilizado somente para casos de formularios mais complexos
     */
    public final void showForm1()
    {
        showEntity = true;
        showEntity2 = false;
        showEntity3 = false;
        showEntity4 = false;
    }

    /**
     * fecha formulario 1 e abre o 2. Utilizado somente para casos de formularios mais complexos
     */
    public final void showForm2()
    {
        showEntity = false;
        showEntity2 = true;
        showEntity3 = false;
        showEntity4 = false;
    }

    /**
     * fecha formulario 2 e abre o 3. Utilizado somente para casos de formularios mais complexos
     */
    public final void showForm3()
    {
        showEntity = false;
        showEntity2 = false;
        showEntity3 = true;
        showEntity4 = false;
    }

    /**
     * fecha formulario 3 e abre o 4. Utilizado somente para casos de formularios mais complexos
     */
    public final void showForm4()
    {
        showEntity = false;
        showEntity2 = false;
        showEntity3 = false;
        showEntity4 = true;
    }

    /**
     * Mostra detalhes da entidade selecionada Utilizado somente para casos de formularios mais complexos
     */
    public final void showFormDetail()
    {
        beforeShowFormDetail();
        closeForms();
        showEntityDetail = true;
    }

    /**
     * Mostra detalhes da entidade selecionada Utilizado somente para casos de formularios mais complexos
     */
    public final void hideFormDetail()
    {
        showEntityDetail = false;
    }

    /**
     * fecha todos formularios. Utilizado somente para casos de formularios mais complexos
     */
    public void closeForms()
    {
        showFilter = false;
        showEntity = false;
        showEntity2 = false;
        showEntity3 = false;
        showEntity4 = false;
    }

    /************************************************************************************************************/
    // METODOS INTERNOS
    /************************************************************************************************************/

    /**
     * Atualiza o total de entities e o total de paginas
     */
    private final void atualizaPages() throws Exception
    {
        totalEntities = contarTodos();
        totalPages = (totalEntities / SqlLogic.TABLE_SIZE);
        totalPages += totalEntities % SqlLogic.TABLE_SIZE != 0 ? 1 : 0;
        if (totalPages == 0)
        {
            totalPages = 1;
        }
    }

    /**
     * inclui ou edita Entity no banco
     * 
     * @param dao
     *            DAO da entity a ser inserida
     * @param id
     *            id do objeto que sera inserido no banco
     */
    public final void incluirEntity()
    {
        try
        {
            beforeSaveEntity();
            if (entity.getId() == 0)
            {
                entity = dao.insert(entity);
            }
            else
            {
                entity = dao.update(entity);
            }
            atualizar();
            MessagesLogic.addInfoMessage("Sucesso", "Salvo com sucesso");
            afterSaveEntity();
        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o administrador");
        }
    }

    /**
     * Deleta Entity do banco
     * 
     * @param dao
     *            DAO referente a entity a ser excluida
     * @param entity
     *            objeto que sera excluido
     * @param id
     *            id da entity que sera excluida
     */
    public final void deletarEntity()
    {
        if (entity != null)
        {
            try
            {
                beforeDeleteEntity();
                dao.removeById(entity.getId());
                atualizar();
                showEntityDetail = false;
                MessagesLogic.addInfoMessage("Sucesso", "Deletado com sucesso");
                afterDeleteEntity();
            }
            catch (Exception e)
            {
                MessagesLogic.addErrorMessage("Erro", "O objeto não pode ser deletado pois está relacionado a outro objeto");
                return;
            }
        }
        else
        {
            MessagesLogic.addWarnMessage("Erro", "Selecione um para deletar");
        }
    }

    /**
     * retorna busca de todas as entities para tabela
     * 
     * @return
     */
    protected final List<T> buscarTodos() throws Exception
    {

        if (search != null && search.length() > 0)
        {
            page = 1;
        }

        if (page > totalPages)
        {
            page = (int) totalPages;
            MessagesLogic.addWarnMessage("Erro", "Número de paginação da tabela invalido");
        }
        if (page < 1)
        {
            page = 1;
            MessagesLogic.addWarnMessage("Erro", "Número de paginação da tabela invalido");
        }

        if (staticFieldsOrderLabel != null)
        {
            int posicao = Arrays.asList(staticFieldsOrderLabel).indexOf(order);
            return dao.buscarTodos(staticFields, page, search, staticFieldsOrderValue[posicao], getTempView());
        }
        else
        {
            return dao.buscarTodos(staticFields, page, search, order, getTempView());
        }
    }

    /**
     * retorna contagem de todos as entities
     * 
     * @return
     */
    protected final long contarTodos()
    {
        return dao.contarTodos(staticFields, search, getTempView());
    }

    /**
     * retorna uma string temporaria de view, juntando a permanetView e a view
     * 
     * @return
     */
    private final String getTempView()
    {
        String tempView = new String();
        if (staticViewsLabel != null && view != null)
        {
            int posicao = Arrays.asList(staticViewsLabel).indexOf(view);
            tempView = staticViewsValue[posicao];
        }
        if (view != null && view.length() > 0 && permanentView != null && permanentView.length() > 0)
        {
            tempView += " and ";
        }
        tempView += permanentView == null ? "" : permanentView;
        return tempView;
    }

    /**
     * Constroi um array de classes para a criação de paginas dinamica. <br/>
     * As classes sao todas que vao constituir o modelo principal da pagina
     * 
     * @return
     */
    private final Class<?>[] buildClassArray()
    {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (superClasses != null)
        {
            // Preapre SuperClasses
            for (Class<?> clazz : superClasses)
            {
                classes.add(clazz);
            }
        }
        classes.add(dao.getEntityClass());

        return classes.toArray(new Class<?>[classes.size()]);
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

    public List<T> getEntities()
    {
        return entities;
    }

    public boolean getShowEntity()
    {
        return showEntity;
    }

    public T getEntity()
    {
        return entity;
    }

    public void setEntity(T entity)
    {
        this.entity = entity;
    }

    public boolean getShowEntity2()
    {
        return showEntity2;
    }

    public boolean getShowEntity3()
    {
        return showEntity3;
    }

    public boolean getShowEntity4()
    {
        return showEntity4;
    }

    public boolean getShowEntityDetail()
    {
        return showEntityDetail;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public String getSearch()
    {
        return search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public long getTotalPages()
    {
        return totalPages;
    }

    public long getTotalEntities()
    {
        return totalEntities;
    }

    public String[] getStaticFieldsOrderValue()
    {
        return staticFieldsOrderValue;
    }

    public String[] getStaticFieldsOrderLabel()
    {
        return staticFieldsOrderLabel;
    }

    public String getView()
    {
        return view;
    }

    public void setView(String view)
    {
        this.view = view;
    }

    public String getPermanentView()
    {
        return permanentView;
    }

    public String[] getStaticViewsValue()
    {
        return staticViewsValue;
    }

    public String[] getStaticViewsLabel()
    {
        return staticViewsLabel;
    }

    public HtmlDataTable getDataTable()
    {
        if (dataTable == null)
        {
            populateDynamicDataTable();
        }
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable)
    {
        this.dataTable = dataTable;
    }

    public HtmlForm getPanelForm()
    {
        if (panelForm == null)
        {
            prepareForm();
        }
        return panelForm;
    }

    public void setPanelForm(HtmlForm panelForm)
    {
        this.panelForm = panelForm;
    }

    public HtmlColumn getSelectButtonColumn()
    {
        return selectButtonColumn;
    }

    public void setSelectButtonColumn(HtmlColumn selectButtonColumn)
    {
        this.selectButtonColumn = selectButtonColumn;
    }

    public DataFilter[] getDataFilters()
    {
        return dataFilters;
    }

    public void setDataFilters(DataFilter[] dataFilters)
    {
        this.dataFilters = dataFilters;
    }

    public boolean getShowFilter()
    {
        return showFilter;
    }

}
