package entities;

import java.io.Serializable;

//Clase para crear objetos que se van a dar de alta en la base de datos
public class Alta implements Serializable  {

	private static final long serialVersionUID = 5900521895734675928L;
	
	private String agente;
	private String extension;
	private String host;
	private String evento;
	private String descripcion;
	
	public Alta() {
		
	}
	
	public Alta(String agente, String extension, String host, String evento, String descripcion) {
		this.agente = agente;
		this.extension = extension;
		this.host = host;
		this.evento = evento;
		this.descripcion = descripcion;
	}


	public void setAgente(String agente) {
		this.agente = agente;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Altas [agente=" + agente + ", extension=" + extension + ", host=" + host + ", evento=" + evento
				+ ", descripcion=" + descripcion + "]";
	}
	
	public String getAgente() {
		return agente;
	}

	public String getExtension() {
		return extension;
	}

	public String getHost() {
		return host;
	}

	public String getEvento() {
		return evento;
	}

	public String getDescripcion() {
		return descripcion;
	}
		
}

