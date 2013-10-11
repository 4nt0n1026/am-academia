package br.com.acad.activity.treino;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.acad.R;
import br.com.acad.entity.pessoa.Aluno;

public class TreinoSolicitacaoFormActivity extends Activity {

	private EditText descricao;
	
	private Aluno aluno;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treino_solicitacao_form_layout);
		
		descricao = (EditText) findViewById(R.idFormSolicitacaoTreino.descricao);
		
		// TODO - Pega aluno da sessao--------------------------------
		aluno = new Aluno(1, "aluno teste");
		//------------------------------------------------------------
	}
	
	public void enviarSolicitacao(View btnEnviar){
		// TODO - enviar solicitacao para o servidor------------------
		
		//------------------------------------------------------------
		Toast.makeText(this, "Solicitação enviada com sucesso!", Toast.LENGTH_LONG).show();
		finish();
	}


}
