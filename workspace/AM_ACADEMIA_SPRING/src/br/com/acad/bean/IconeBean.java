package br.com.acad.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class IconeBean implements Serializable
{

    private String[] icones = { "Album", "Buddy", "Buddy Chat", "Buddy Group", "Calendar", "Chart Bar", "Chart Pie", "Chat", "logout",
            "config", "news", "gloves", "apple", "weight", "Help", "Document Notes", "Tag" };

    public String[] getIcones()
    {
        return icones;
    }

    public void setIcones(String[] icones)
    {
        this.icones = icones;
    }

}
