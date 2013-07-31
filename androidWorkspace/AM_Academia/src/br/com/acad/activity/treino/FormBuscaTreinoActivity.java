package br.com.acad.activity.treino;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.acad.R;
import br.com.acad.entity.treino.DiasSemanaCat;
import br.com.acad.entity.treino.DuracaoTreinoCat;
import br.com.acad.entity.treino.FaixaEtariaCat;
import br.com.acad.entity.treino.ObjetivoCat;
import br.com.acad.entity.treino.SexoCat;

public class FormBuscaTreinoActivity extends Activity {

	private Spinner duracaoSpinner;
	private Spinner diasSemanaSpinner;
	private Spinner faixaEtariaSpinner;
	private Spinner objetivoSpinner;
	private Spinner sexoSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_busca_treino_layout);
		
		// Views-------------------------------------------------------
		diasSemanaSpinner = (Spinner) findViewById(R.idFormBuscaTreino.diasSemanaSpinner);
		duracaoSpinner = (Spinner) findViewById(R.idFormBuscaTreino.duracaoSpinner);
		faixaEtariaSpinner = (Spinner) findViewById(R.idFormBuscaTreino.faixaSpinner);
		objetivoSpinner = (Spinner) findViewById(R.idFormBuscaTreino.objetivoSpinner);
		sexoSpinner = (Spinner) findViewById(R.idFormBuscaTreino.sexoSpinner);
		//------------------------------------------------------------
		
		// Listas para spinners---------------------------------------
		List<DiasSemanaCat> diasSemana = new ArrayList<DiasSemanaCat>();
		List<ObjetivoCat> objetivos = new ArrayList<ObjetivoCat>();
		List<DuracaoTreinoCat> duracoes = new ArrayList<DuracaoTreinoCat>();
		List<FaixaEtariaCat> faixasEtarias = new ArrayList<FaixaEtariaCat>();
		List<SexoCat> sexos = new ArrayList<SexoCat>();
		//------------------------------------------------------------
		
		// TODO - puxar do ws-----------------------------------------
		// Dias Semana
		diasSemana.add(new DiasSemanaCat(1, "1 vez por semana"));
		diasSemana.add(new DiasSemanaCat(2, "2 vezes por semana"));
		diasSemana.add(new DiasSemanaCat(3, "3 vezes por semana"));
		diasSemana.add(new DiasSemanaCat(4, "4 vezes por semana"));
		diasSemana.add(new DiasSemanaCat(5, "5 vezes por semana"));
		diasSemana.add(new DiasSemanaCat(6, "6 vezes por semana"));
		diasSemana.add(new DiasSemanaCat(7, "7 vezes por semana"));
		// Objetivos
		objetivos.add(new ObjetivoCat(1, "Hipertrofia"));
		objetivos.add(new ObjetivoCat(2, "Saude"));
		objetivos.add(new ObjetivoCat(3, "Emagrecer"));
		// Duracoes
		duracoes.add(new DuracaoTreinoCat(10, "Todas as durações"));
		duracoes.add(new DuracaoTreinoCat(1, "Até 15 min."));
		duracoes.add(new DuracaoTreinoCat(2, "De 15 a 30 min."));
		duracoes.add(new DuracaoTreinoCat(3, "De 30 a 45 min."));
		duracoes.add(new DuracaoTreinoCat(4, "De 30 a 45 min."));
		duracoes.add(new DuracaoTreinoCat(5, "De 45 a 60 min."));
		duracoes.add(new DuracaoTreinoCat(6, "De 60 a 75 min."));
		duracoes.add(new DuracaoTreinoCat(7, "De 75 a 90 min."));
		duracoes.add(new DuracaoTreinoCat(8, "De 90 a 120 min."));
		duracoes.add(new DuracaoTreinoCat(9, "Mais de 120 min."));
		// Faixas Etarias
		faixasEtarias.add(new FaixaEtariaCat(1, "Todas as idades"));
		faixasEtarias.add(new FaixaEtariaCat(2, "Até 15 anos"));
		faixasEtarias.add(new FaixaEtariaCat(3, "De 16 a 19 anos"));
		faixasEtarias.add(new FaixaEtariaCat(4, "De 20 a 30 anos"));
		faixasEtarias.add(new FaixaEtariaCat(5, "De 31 a 45 anos"));
		faixasEtarias.add(new FaixaEtariaCat(6, "De 46 a 60 anos"));
		faixasEtarias.add(new FaixaEtariaCat(7, "Mais de 60 anos"));
		// Sexo
		sexos.add(new SexoCat(1, "Todos os sexos"));
		sexos.add(new SexoCat(1, "Masculino"));
		sexos.add(new SexoCat(1, "Feminino"));
		//------------------------------------------------------------
		
		// Adapters---------------------------------------------------
		ArrayAdapter<DiasSemanaCat> diasSemanaAdapter = new ArrayAdapter<DiasSemanaCat>(this, android.R.layout.simple_spinner_item, diasSemana);
		diasSemanaSpinner.setAdapter(diasSemanaAdapter);
		
		ArrayAdapter<ObjetivoCat> objetivoAdapter = new ArrayAdapter<ObjetivoCat>(this, android.R.layout.simple_spinner_item, objetivos);
		objetivoSpinner.setAdapter(objetivoAdapter);

		ArrayAdapter<DuracaoTreinoCat> duracaoAdapter = new ArrayAdapter<DuracaoTreinoCat>(this, android.R.layout.simple_spinner_item, duracoes);
		duracaoSpinner.setAdapter(duracaoAdapter);

		ArrayAdapter<FaixaEtariaCat> faixaEtariaAdapter = new ArrayAdapter<FaixaEtariaCat>(this, android.R.layout.simple_spinner_item, faixasEtarias);
		faixaEtariaSpinner.setAdapter(faixaEtariaAdapter);

		ArrayAdapter<SexoCat> sexoAdapter = new ArrayAdapter<SexoCat>(this, android.R.layout.simple_spinner_item, sexos);
		sexoSpinner.setAdapter(sexoAdapter);
		//------------------------------------------------------------
	}

	
	public void buscarTreino(View btnBuscar){
		Toast.makeText(this, "Teste", Toast.LENGTH_LONG).show();
	}
	

}
