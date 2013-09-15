package br.com.acad.activity.treino;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import br.com.acad.R;

public class TreinoBuscaDetalheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_busca_detalhe_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalhe_busca_treino, menu);
		return true;
	}

}
