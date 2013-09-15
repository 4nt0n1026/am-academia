package br.com.acad.activity.treino;

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
import br.com.acad.entity.treino.ParteCorpo;

public class TreinoExerciciosParteCorpoActivity extends Activity {

	private List<ParteCorpo> partesCorpo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_exercicios_parte_corpo_layout);
		
		partesCorpo = new ArrayList<ParteCorpo>();
		
		// TODO - puxar ws-----------------------------
			partesCorpo.add(new ParteCorpo(1, "Costas"));
			partesCorpo.add(new ParteCorpo(2, "Peito"));
			partesCorpo.add(new ParteCorpo(3, "Ombro"));
			partesCorpo.add(new ParteCorpo(4, "Biceps"));
			partesCorpo.add(new ParteCorpo(5, "Triceps"));
			partesCorpo.add(new ParteCorpo(6, "Coxa"));
			partesCorpo.add(new ParteCorpo(7, "Gluteos"));
			partesCorpo.add(new ParteCorpo(8, "Panturrilha"));
			partesCorpo.add(new ParteCorpo(9, "Lombar"));
		//---------------------------------------------
		
		// Cria ArrayAdapter e preenche listView
		ArrayAdapter<ParteCorpo> adapter = new ArrayAdapter<ParteCorpo>(this, android.R.layout.simple_list_item_1, partesCorpo);
		
		ListView listPartesCorpo = (ListView) findViewById(R.idTreinoExerciciosPartesCorpo.listPartesCorpo);
		listPartesCorpo.setAdapter(adapter);
		//---------------------------------------------
		
		// Ao clicar no item da lista--------------------------------
		listPartesCorpo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				// Pega o item clicado
				ParteCorpo parteCorpo = partesCorpo.get(posicao);
				
				// TODO - Encaminha para pagina de lista de exercicios
				Intent goExerciciosList = new Intent(TreinoExerciciosParteCorpoActivity.this, TreinoExerciciosListActivity.class);
				goExerciciosList.putExtra("parteCorpo", parteCorpo);
				startActivity(goExerciciosList);
			}
		});
		//-----------------------------------------------------------
		
	}


}
