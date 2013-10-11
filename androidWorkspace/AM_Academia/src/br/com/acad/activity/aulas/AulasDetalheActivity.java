package br.com.acad.activity.aulas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.com.acad.R;
import br.com.acad.entity.aulas.Aula;

public class AulasDetalheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aulas_detalhe_layout);
		
		// Seta os views-------------------------------------------------------------
		TextView nome = (TextView) findViewById(R.idAulasDetalhe.nome);
		TextView descricao = (TextView) findViewById(R.idAulasDetalhe.descricao);
		TextView horarios = (TextView) findViewById(R.idAulasDetalhe.horarios);
		//---------------------------------------------------------------------------
		
		// Busca aula selecionada da intent------------------------------------
		Aula aula = null;
		
		Intent itAulas = getIntent();
		if(itAulas!=null){
			aula = (Aula) itAulas.getSerializableExtra("aula");
		}
		//---------------------------------------------------------------------------

		// TODO - Busca do WS--------------------------------------------------------
		aula.setDescricao("O boxe ou pugilismo é um esporte de combate, " +
				"no qual os lutadores usam apenas os punhos, tanto para a " +
				"defesa, quanto para o ataque. A palavra deriva do inglês " +
				"to box, que significa bater, ou pugilismo (bater com os punhos), " +
				"expressão utilizada na Inglaterra entre 1000 e 1850.");
		aula.setHorarios("Seguna e quinta: 12:00 as 13:30 (Kleber)\nTerÃ§a e sexta: 19:00 as 20:30 (Jorge)");
		//---------------------------------------------------------------------------
		
		// Preenche as Views---------------------------------------------------------
		nome.setText(aula.getNome());
		descricao.setText(aula.getDescricao());
		horarios.setText(aula.getHorarios());
		//---------------------------------------------------------------------------
		
	}

	

}
