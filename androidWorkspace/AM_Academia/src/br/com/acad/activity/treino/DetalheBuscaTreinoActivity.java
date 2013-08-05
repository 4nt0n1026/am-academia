package br.com.acad.activity.treino;

import br.com.acad.R;
import br.com.acad.R.layout;
import br.com.acad.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DetalheBuscaTreinoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_busca_treino_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalhe_busca_treino, menu);
		return true;
	}

}
