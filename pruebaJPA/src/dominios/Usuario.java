package dominios;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 50, name = "nom")
	private String nombre;
	
	@Column(name = "passwd", nullable = false)
	private String password;
	
	@OneToOne
	private Direccion direccion;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password="
				+ password + "]";
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
