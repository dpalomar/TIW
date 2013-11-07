package es.uc3m.tiw.dominios;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;


	@Column(unique = true, length = 45)
	private String nombre;
	@Column(nullable = false, length = 10, name = "clave")
	private String password;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "email")
	private String email;
	@OneToOne(cascade = ALL)
	private Direccion direccion;
	
	
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String param) {
		this.nombre = param;
	}

	public String getNombre() {
		return nombre;
	}

}