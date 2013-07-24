package br.com.acad.activity.noticias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.com.acad.R;
import br.com.acad.entity.noticias.Noticia;

public class NoticiasDetalheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noticia_detalhe_layout);
		
		// Seta os views----------------------------------------------
		TextView nome = (TextView) findViewById(R.idNoticiasDetalhe.nome);
		TextView data = (TextView) findViewById(R.idNoticiasDetalhe.data);
		TextView categoria = (TextView) findViewById(R.idNoticiasDetalhe.categoria);
		TextView descricao = (TextView) findViewById(R.idNoticiasDetalhe.descricao);
		//------------------------------------------------------------
		
		// Busca noticia selecionada da Intent------------------------
		Noticia noticia = null;
		
		Intent itNoticias = getIntent();
		if(itNoticias!=null){
			noticia = (Noticia) itNoticias.getSerializableExtra("noticia");
		}
		//------------------------------------------------------------

		// TODO - Busca do ws-----------------------------------------
		noticia.setDescricao("Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui " +
				"Descricao da noticia aqui Descricao da noticia aqui ");
		//------------------------------------------------------------
		
		// Preenche as views------------------------------------------
		nome.setText(noticia.getNome());
		data.setText(noticia.getData());
		categoria.setText(noticia.getCategoria());
		descricao.setText(noticia.getDescricao());
		//------------------------------------------------------------
	}

	
	
	
}
