package br.com.acad.logic;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaLogic {
	
	public static String encriptar(String valor){
		try{
			//Obt�m a inst�ncia de um algoritmo
			MessageDigest md = MessageDigest.getInstance("MD5"); //MD5 ou SHA-1ou SHA-256
			
			//Passa os dados a serem criptografados e estipula enconding padr�o
			md.update(valor.getBytes("ISO-8859-1"));
			
			//Gera a chave criptografada em array de Bytes para posterior hashing
			BigInteger hash = new BigInteger(1, md.digest());
			String senhaCriptografada = hash.toString(16); //Hash em Base16 Encoding
			
			return senhaCriptografada;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
