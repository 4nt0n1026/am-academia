package br.com.acad.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Pessoa;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Component
@Scope(value = "session")
public class LoginBean implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private ProfessorFuncDAO professorFuncDAO;

    private String email;
    private String senha;

    private String senhaAtual;
    private String senhaNova;
    private String senhaNovaConfirmacao;

    private ProfessorFunc usuario;

    private boolean showAlteraSenha = false;

    private boolean logado;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    /**
     * Loga o usuario no sistema
     * 
     * @return
     */
    public String logar()
    {
        usuario = professorFuncDAO.logar(email, senha);
        if (usuario != null)
        {
            // Cria a sessao para o usuario
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            // cocloca o usuario a sessao
            session.setAttribute("usuario", usuario);
            // Mensagem de sucesso
            MessagesLogic.addInfoMessage("Sucesso", "Logado com sucesso");

            logado = true;
            email = new String();
            senha = new String();

            // Deixa a caixa de msg ativa
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            return "home";
        }
        else
        {
            // Login e senha incorretos
            MessagesLogic.addWarnMessage("Erro", "Email ou senha incorretos");
            return null;
        }
    }

    /**
     * Tira sessao do usuario
     * 
     * @return
     */
    public String logout()
    {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        logado = false;
        usuario = null;

        return "login";
    }

    /**
     * Mostra formulario de alteração de senha
     */
    public void showFormAlteraSenha()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        usuario = (ProfessorFunc) session.getAttribute("usuario");

        showAlteraSenha = true;
    }

    /**
     * Altera senha do usuario logado
     */
    public void alterarSenha()
    {
        if (!usuario.getSenha().equals(CriptografiaLogic.encriptar(senhaAtual)))
        {
            MessagesLogic.addWarnMessage("Erro", "A senha atual est� incorreta");
            return;
        }

        if (!senhaNova.equals(senhaNovaConfirmacao))
        {
            MessagesLogic.addWarnMessage("Erro", "A confirma��o da senha nova est� incorreta");
            return;
        }

        usuario.setSenha(CriptografiaLogic.encriptar(senhaNova));
        professorFuncDAO.update(usuario);
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

    public Pessoa getUsuario()
    {
        return usuario;
    }

    public void setUsuario(ProfessorFunc usuario)
    {
        this.usuario = usuario;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public boolean getShowAlteraSenha()
    {
        return showAlteraSenha;
    }

    public boolean getLogado()
    {
        return logado;
    }

    public String getSenhaAtual()
    {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual)
    {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova()
    {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova)
    {
        this.senhaNova = senhaNova;
    }

    public String getSenhaNovaConfirmacao()
    {
        return senhaNovaConfirmacao;
    }

    public void setSenhaNovaConfirmacao(String senhaNovaConfirmacao)
    {
        this.senhaNovaConfirmacao = senhaNovaConfirmacao;
    }

}
