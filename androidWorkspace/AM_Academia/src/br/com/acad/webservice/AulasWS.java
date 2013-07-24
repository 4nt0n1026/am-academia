package br.com.acad.webservice;


public class AulasWS {
	
	final String NAMESPACE = "http://webservice.acad.com.br/";
	final String SOAP_ACTION = "HorarioWS";
	final String URL = "http://10.0.2.2:8080/AMAcademiaEJB/HorarioWS?wsdl";
	
//	public Modalidade[] buscarModalidades() {
//
//		final String METHOD_NAME = "buscarTodasModalidades";
//
//		// MONTANDO AS INFORMACOES DO SOAP
//		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
//
//		// CRIANDO O ENVELOPE DE ENVIO
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//		
//		// ADICIONANDO O SOAP AO ENVELOPE
//		envelope.setOutputSoapObject(request);
//
//		// TRANSPORTAR
//		HttpTransportSE transport = new HttpTransportSE(URL);
//
//		Modalidade[] modalidades= null;
//		
//		try {
//
//			// FAZER A CHAMADA		
//			transport.call(SOAP_ACTION, envelope);
//			
//			
//			
//			// OBTER O RETORNO
//			@SuppressWarnings("unchecked")
//			Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();
//
//			modalidades = new Modalidade[response.size()];
//			
//			int i = 0;
//			for (SoapObject soapObject : response) {
//				
//				Modalidade modalidade = new Modalidade();
//				modalidade.setId((Integer)soapObject.getProperty(0));
//				modalidade.setNome(soapObject.getProperty(1).toString());
//				
//				modalidades[i] = modalidade;
//				i++;
//			}
//			
//			for (Modalidade modalidade : modalidades) {
//				
//				Log.i("TESTE_WS", modalidade.getNome());
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (XmlPullParserException e) {
//			e.printStackTrace();
//		}
//		
//		return modalidades;
//	}
}
