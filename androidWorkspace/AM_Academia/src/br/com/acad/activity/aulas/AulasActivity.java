package br.com.acad.activity.aulas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.acad.R;
import br.com.acad.entity.aulas.Aula;

public class AulasActivity extends Activity {

	private List<Aula> aulas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aulas_layout);

		aulas = new ArrayList<Aula>();
		
		// TODO - puxar do ws ------------------------------------
		aulas.add(new Aula(1, "Abdominal"));
		aulas.add(new Aula(2, "Boxe"));
		aulas.add(new Aula(3, "Jiu Jitsu"));
		// -------------------------------------------------------
		
		// Cria adapter e preenche listaView----------------------
		ArrayAdapter<Aula> adapter = new ArrayAdapter<Aula>(this, android.R.layout.simple_list_item_1, aulas);
		
		ListView listAulas = (ListView) findViewById(R.idAulas.listModalidade);
		listAulas.setAdapter(adapter);
		// -------------------------------------------------------
		
		// Ao clicar em item da lista-----------------------------
		listAulas.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				// Pega item clicado
				Aula modalidadeClicada = aulas.get(posicao); 
				
				// Encaminha para pagina de detalhe com parametro modalidade
				Intent goAulasDetalhe =  new Intent(AulasActivity.this, AulasDetalheActivity.class);
				goAulasDetalhe.putExtra("aula", modalidadeClicada);
				startActivity(goAulasDetalhe);
			}
		});
		// -------------------------------------------------------
	}


}
