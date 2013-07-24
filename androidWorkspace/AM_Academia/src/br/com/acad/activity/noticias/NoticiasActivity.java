package br.com.acad.activity.noticias;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.acad.R;
import br.com.acad.entity.noticias.Noticia;

public class NoticiasActivity extends Activity {

	private ArrayList<Noticia> noticias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noticias_layout);
		
		noticias = new ArrayList<Noticia>();
		
		// TODO - puxar do ws----------------------------------------
		noticias.add(new Noticia(1, "noticia 1", null, "noticia", "23/04/2013"));
		noticias.add(new Noticia(2, "noticia 2", null, "noticia", "20/07/2013"));
		noticias.add(new Noticia(3, "noticia 3", null, "noticia", "20/07/2013"));
		noticias.add(new Noticia(4, "dica 1", null, "dica", "23/04/2013"));
		noticias.add(new Noticia(5, "dica 2", null, "dica", "23/04/2013"));
		noticias.add(new Noticia(6, "aviso 1", null, "aviso", "23/04/2013"));
		//-----------------------------------------------------------
		
		// Cria adapter e preenche listView--------------------------
		ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(this, android.R.layout.simple_list_item_1, noticias);
		
		ListView listNoticias = (ListView) findViewById(R.idNoticias.listNoticias);
		listNoticias.setAdapter(adapter);
		//-----------------------------------------------------------
		
		// Ao clicar no item da lista--------------------------------
		listNoticias.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				// Pega o item clicado
				Noticia noticiaClicada = noticias.get(posicao);
				
				// Encaminha para pagina de detalhe com paramento noticia
				Intent goNoticiaDetalhe = new Intent(NoticiasActivity.this, NoticiasDetalheActivity.class);
				goNoticiaDetalhe.putExtra("noticia", noticiaClicada);
				startActivity(goNoticiaDetalhe);
			}
		});
		//-----------------------------------------------------------
	}


}
