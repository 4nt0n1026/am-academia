package br.com.fiap.utils.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import br.com.fiap.cliente.entity.Sexo;

@ManagedBean
@ApplicationScoped
public class SexoBean {

	public SelectItem[] getSexo() {
		SelectItem[] itens = new SelectItem[Sexo.values().length];
		int i = 0;
		for (Sexo g : Sexo.values()) {
			itens[i++] = new SelectItem(g, g.getLabel());
		}
		return itens;
	}
}
