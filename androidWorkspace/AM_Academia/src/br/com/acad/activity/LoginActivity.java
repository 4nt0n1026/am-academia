package br.com.acad.activity;

import br.com.acad.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText login;
	private EditText senha;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		
		// Preenche os valores do formulario nas variaveis
		login = (EditText) findViewById(R.idLogin.login);
		senha = (EditText) findViewById(R.idLogin.senha);
	}
	
	public void logar(View btnLogar){
		
		// TODO - Logica para login
		
		Intent goHome = new Intent(this, HomeActivity.class);
		
		startActivity(goHome);
		
	}


}
