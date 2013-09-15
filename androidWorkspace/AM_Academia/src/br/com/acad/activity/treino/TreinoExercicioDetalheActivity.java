package br.com.acad.activity.treino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.com.acad.R;
import br.com.acad.entity.treino.Exercicio;

public class TreinoExercicioDetalheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_exercicio_detalhe_layout);

		// Seta os views----------------------------------------------
		TextView nome = (TextView) findViewById(R.idTreinoExercicioDetalhe.nome);
		TextView descricao = (TextView) findViewById(R.idTreinoExercicioDetalhe.descricao);
		TextView partesCorpoPrimaria = (TextView) findViewById(R.idTreinoExercicioDetalhe.parteCorpoPrimarias);
		TextView partesCorpoSecunda = (TextView) findViewById(R.idTreinoExercicioDetalhe.partesCorpoSecundaria);
		//------------------------------------------------------------
		
		// Busca exercicio selecionado da Intent------------------------
		Exercicio exercicio = null;
		
		Intent itExerciciosList = getIntent();
		if(itExerciciosList!=null){
			exercicio = (Exercicio) itExerciciosList.getSerializableExtra("exercicio");
		}
		//------------------------------------------------------------

		// TODO - Busca do ws-----------------------------------------
		exercicio.setDescricao("Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui ");
		exercicio.setPartesCorpoPrimarias("Peito");
		exercicio.setPartesCorpoSecundarias("Ombro e Triceps");
		//------------------------------------------------------------
		
		// Preenche as views------------------------------------------
		nome.setText(exercicio.getNome());
		descricao.setText(exercicio.getDescricao());
		partesCorpoPrimaria.setText(exercicio.getPartesCorpoPrimarias());
		partesCorpoSecunda.setText(exercicio.getPartesCorpoSecundarias());
		//------------------------------------------------------------
	}

}
