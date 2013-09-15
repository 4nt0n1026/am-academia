package br.com.acad.adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.acad.R;
import br.com.acad.entity.util.MenuItem;

public class ListaMenuTreinoAdapter extends BaseAdapter {


	private List<MenuItem> itens;
	private Activity activity;

	public ListaMenuTreinoAdapter(Activity activity, List<MenuItem> itens) {
		this.activity = activity;
		this.itens = itens;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int position) {
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		

//		String uri = "drawable/album";
//
//		int imageResource = getResources().getIdentifier(uri, null, getPackageName());
//
//		ImageView imageView = (ImageView) findViewById(R.idListaLayout.image);
//		Drawable image = getResources().getDrawable(imageResource);
//		imageView.setImageDrawable(image);
		
		
		// Pega o item selecionado
		MenuItem item = itens.get(position);
		
		// Pega o layout da linha
		LayoutInflater inflater = activity.getLayoutInflater();
		View linha = inflater.inflate(R.layout.lista_foto_layout, null);
		
		// Seta o layout da linha
		ImageView image = (ImageView) linha.findViewById(R.idListaLayout.image);
		Drawable icon = activity.getResources().getDrawable(item.getIdFoto());
		image.setImageDrawable(icon);
		
		TextView texto = (TextView) linha.findViewById(R.idListaLayout.texto);
		texto.setText(item.getNome());
		
		return linha;
	}

}
