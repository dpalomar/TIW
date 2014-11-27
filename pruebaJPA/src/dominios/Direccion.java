package dominios;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.ManyToOne;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	
	private String calle;
	private String ciudad;
	
	private String localidad;
	private int codigoPostal;
	@ManyToOne
	private Usuario usuario;
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad="
				+ ciudad + ", localidad=" + localidad + ", codigoPostal="
				+ codigoPostal + ", usuario=" + usuario + "]";
	}
	public Direccion(String calle, String ciudad, String localidad,
			int codigoPostal) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
