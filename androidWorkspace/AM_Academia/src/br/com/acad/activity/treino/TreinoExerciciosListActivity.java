package br.com.acad.activity.treino;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.acad.R;
import br.com.acad.activity.noticias.NoticiasDetalheActivity;
import br.com.acad.adapter.ListaExerciciosAdapter;
import br.com.acad.entity.treino.Exercicio;
import br.com.acad.entity.treino.ParteCorpo;

public class TreinoExerciciosListActivity extends Activity {

	private ArrayList<Exercicio> exercicios;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_exercicios_list_layout);
		
		// Busca parteCorpo selecionada da intent------------------------------------
		ParteCorpo parteCorpo = null;
		
		Intent itPartesCorpo = getIntent();
		if(itPartesCorpo!=null){
			parteCorpo = (ParteCorpo) itPartesCorpo.getSerializableExtra("parteCorpo");
		}
		//---------------------------------------------------------------------------
		
		exercicios = new ArrayList<Exercicio>();
		
		// TODO - puxar do ws----------------------------------------
		exercicios.add(new Exercicio("Supino"));
		exercicios.add(new Exercicio("Supino Inclinado"));
		exercicios.add(new Exercicio("Supino Declinado"));
		exercicios.add(new Exercicio("Paralela"));
		//-----------------------------------------------------------
		
		//Cria Adapter e preenche lista------------------------------------
		ListaExerciciosAdapter adapter = new ListaExerciciosAdapter(this, exercicios);
		
		ListView listNoticias = (ListView) findViewById(R.idTreinoExerciciosList.listExercicios);
		listNoticias.setAdapter(adapter);
		//-----------------------------------------------------------------
		
		// Ao clicar no item da lista--------------------------------
		listNoticias.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				// Pega o item clicado
				Exercicio exercicio = exercicios.get(posicao);
				
				// Encaminha para pagina de detalhe com paramento exercicio
				Intent goExercicioDetalhe = new Intent(TreinoExerciciosListActivity.this, TreinoExercicioDetalheActivity.class);
				goExercicioDetalhe.putExtra("exercicio", exercicio);
				startActivity(goExercicioDetalhe);
			}
		});
		//-----------------------------------------------------------
	}

}
