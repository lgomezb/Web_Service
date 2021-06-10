package entities;

import com.google.gson.Gson;

//Clase que transforma los JSON de llegada en Objetos
public class JsonToObject {
	
	public Alta parseJson (Alta p) {
		
		String altaJson = p.toString();
		Gson gson = new Gson();
		
		Alta jto = gson.fromJson(altaJson, Alta.class);
		return(jto);
	}
	
	

}
