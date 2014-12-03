package es.uc3m.tiw.dominios;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * {@link XmlRootElement} Permite el uso del API JAXB y convierte 
 * automaticamente esta clase a XML y JSON
 * 
 * @author David Palomar
 *
 */
@XmlRootElement
public class Usuario {

	private Integer edad;
	private String nombre;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(Integer edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}


	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
