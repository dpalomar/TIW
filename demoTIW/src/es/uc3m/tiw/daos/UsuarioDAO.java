package es.uc3m.tiw.daos;

import java.util.Collection;

import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDAO {

	public abstract Usuario guardarUsuario(Usuario nuevoUsuario)
			throws Exception;

	public abstract Usuario modificarUsuario(Usuario usuario) throws Exception;

	public abstract void borrarUsuario(Usuario usuario) throws Exception;

	public abstract Usuario recuperarUsuarioPorPK(Long pk);

	public abstract Usuario recuperarUsuarioPorNombre(String nombre);

	public abstract Usuario buscarPorNombreYpassword(String nombre, String password);

	public abstract Collection<Usuario> buscarTodosLosUsuarios();

}