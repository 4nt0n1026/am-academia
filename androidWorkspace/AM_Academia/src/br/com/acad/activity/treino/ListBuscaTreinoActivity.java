package br.com.acad.activity.treino;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.acad.R;
import br.com.acad.entity.treino.DiasSemanaCat;
import br.com.acad.entity.treino.DuracaoTreinoCat;
import br.com.acad.entity.treino.FaixaEtariaCat;
import br.com.acad.entity.treino.ObjetivoCat;
import br.com.acad.entity.treino.SexoCat;
import br.com.acad.entity.treino.Treino;

public class ListBuscaTreinoActivity extends Activity {

	private ArrayList<Treino> treinos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_busca_treino_layout);
		
		treinos = new ArrayList<Treino>();
		
		// TODO - puxar ws-----------------------------
		ObjetivoCat objetivoCat = null;
		FaixaEtariaCat faixaEtariaCat = null;
		DuracaoTreinoCat duracaoTreinoCat = null;
		DiasSemanaCat diasSemanaCat = null;
		SexoCat sexoCat = null;
		
		Intent itBuscaTreino = getIntent();
		if(itBuscaTreino!=null){
			objetivoCat = (ObjetivoCat) itBuscaTreino.getSerializableExtra("objetivoCat");
			faixaEtariaCat = (FaixaEtariaCat) itBuscaTreino.getSerializableExtra("faixaEtariaCat");
			duracaoTreinoCat = (DuracaoTreinoCat) itBuscaTreino.getSerializableExtra("duracaoCat");
			diasSemanaCat = (DiasSemanaCat) itBuscaTreino.getSerializableExtra("diasSemanaCat");
			sexoCat = (SexoCat) itBuscaTreino.getSerializableExtra("sexoCat");
		}
		for(int i = 1; i<=9; i++){
			treinos.add(new Treino("treino fixo - " + i + "/" + objetivoCat, "01/07/13"));
		}
		//---------------------------------------------
		
		// Cria ArrayAdapter e preenche listView
		ArrayAdapter<Treino> adapter = new ArrayAdapter<Treino>(this, android.R.layout.simple_list_item_1, treinos);
		
		ListView listTreinos = (ListView) findViewById(R.idListBuscaTreino.listTreinos);
		listTreinos.setAdapter(adapter);
		//---------------------------------------------
		
		// Ao clicar em item da lista------------------
		
		//---------------------------------------------
		
	}

}
