package br.com.acad.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope(value="session")
public class BeansControlBean implements Serializable{

	private static final String noticiaCatBean = "noticiaCatBean";

	public static String getNoticiacatbean() {
		return noticiaCatBean;
	}
	
	
	
}
