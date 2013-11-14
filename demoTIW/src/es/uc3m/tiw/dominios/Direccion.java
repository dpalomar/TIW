package es.uc3m.tiw.dominios;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;

@Entity
@Table(name="direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long Id;
	private String calle;
	private String poblacion;
	@Column(name = "c_postal")
	private Integer cp;
	//Esto agrega bidireccionalidad hacia usuario
	@OneToOne(mappedBy="direccion")
	private Usuario usuario; 
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public Direccion(String calle, String poblacion, Integer cp) {
		super();
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
	
}
