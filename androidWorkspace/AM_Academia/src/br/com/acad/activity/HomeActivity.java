package br.com.acad.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.acad.R;
import br.com.acad.activity.aulas.AulasActivity;
import br.com.acad.activity.dieta.DietaActivity;
import br.com.acad.activity.noticias.NoticiasActivity;
import br.com.acad.activity.treino.TreinoActivity;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
	}

	
	/**
	 * Vai para a tela de treino
	 */
	public void goTreino(View btnTreino){
		Intent goTreino = new Intent(this, TreinoActivity.class);
		startActivity(goTreino);
	}
	
	/**
	 * Vai para a tela de dieta
	 */
	public void goDieta(View btnDieta){
		Intent goTreino = new Intent(this, DietaActivity.class);
		startActivity(goTreino);
	}
	
	/**
	 * Vai para a tela de noticias
	 */
	public void goNoticias(View btnNoticias){
		Intent goNoticias = new Intent(this, NoticiasActivity.class);
		startActivity(goNoticias);
	}
	
	/**
	 * Vai para a tela de aulas
	 */
	public void goAulas(View btnAulas){
		Intent goAulas = new Intent(this, AulasActivity.class);
		startActivity(goAulas);
	}
	
}
