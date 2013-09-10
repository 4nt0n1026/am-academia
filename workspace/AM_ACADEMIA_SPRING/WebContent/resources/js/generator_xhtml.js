$(function(){
	
	function geraMenuTabela(nomeBean){
		var text = "<p:commandButton  title='novo' icon='ui-icon ui-icon-plus' action='#{" + nomeBean +  ".showNewEntity}' ajax='true' update=':tabView1:formEntity' />";
//					"<p:toolbarGroup align='left'> " + 
//				    	"<p:commandButton  title='novo' icon='ui-icon ui-icon-plus' action='#{" + nomeBean +  ".showNewEntity}' ajax='true' update=':tabView1:formEntity' />" +
//				    	"<p:commandButton  title='deletar'  icon='ui-icon ui-icon-trash' action='#{" + nomeBean + ".deletarEntity}' ajax='true' update=':tabView1:tabelaEntity'  />" +
//				    	"<p:commandButton  title='Editar' icon='ui-icon ui-icon-pencil' action='#{" + nomeBean + ".showEditEntity}' ajax='true' update=':tabView1:formEntity' />" +
//				    	"<p:commandButton  title='atualizar'  icon='ui-icon ui-icon-refresh' action='#{" + nomeBean + ".atualizar}' ajax='true' update=':tabView1'/>" +
//				    	"<p:commandButton  title='filtro' icon='ui-icon ui-icon-zoomin' />" +
//				    	"<p:separator /> " +
//				    "</p:toolbarGroup>'";
//		var text = "teste" + nomeBean;
		
		$("#menuTabelaInsert").append(text);
			 
	}
	
	geraMenuTabela("noticiaCatBean");
	
	
	
	
});
	
