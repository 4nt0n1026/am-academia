package br.com.acad.activity.treino;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.acad.R;
import br.com.acad.adapter.ListaMenuTreinoAdapter;
import br.com.acad.entity.util.MenuItem;

public class TreinoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_layout);
		
		//Map com foto e nome-----------------------------------
		List<MenuItem> itens = new ArrayList<MenuItem>();
		itens.add(new MenuItem(R.drawable.ic_launcher, "Meus Treinos"));
		itens.add(new MenuItem(R.drawable.ic_launcher, "Buscar Treinos Prontos"));
		itens.add(new MenuItem(R.drawable.ic_launcher, "Solicitar Treino"));
		itens.add(new MenuItem(R.drawable.ic_launcher, "Exercicios"));
		//-----------------------------------------------------------------
		
		//Cria Adapter e preenche lista------------------------------------
		ListaMenuTreinoAdapter adapter = new ListaMenuTreinoAdapter(this, itens);
		
		ListView listMenuTreino = (ListView) findViewById(R.idTreino.listMenuTreino);
		listMenuTreino.setAdapter(adapter);
		//-----------------------------------------------------------------
		
		// Ao clicar no item da lista--------------------------------------
		listMenuTreino.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				switch (posicao) {
				
				// Meus treinos-----------------------------------
				case 0:
					// TODO - vai para meus treinos
					break;
				//------------------------------------------------
				
				// Buscar Treinos Prontos-------------------------
				case 1:
					// Vai para busca de treinos
					Intent goFormBuscaTreino =  new Intent(TreinoActivity.this, FormBuscaTreinoActivity.class);
					startActivity(goFormBuscaTreino);
					break;
				//------------------------------------------------
			
				// Solicitar Treino-------------------------------
				case 2:
					// Vai para solicitacao de treino
					Intent goFormSolicitacao =  new Intent(TreinoActivity.this, FormSolicitacaoTreinoActivity.class);
					startActivity(goFormSolicitacao);
					break;
				//------------------------------------------------

				// Exercicios-------------------------------------
				case 3:
					// TODO - vai para lista de exercicios
					break;
				//------------------------------------------------

				default:
					break;
				}
				
				
			}
		});
		//-----------------------------------------------------------------
	}


}
