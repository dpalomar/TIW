package daos;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dominios.Usuario;

public interface UsuarioDao {

	public abstract Usuario guardarUsuario(Usuario usuario) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public abstract Usuario buscarUsuario(Long id);

	public abstract void deleteUsuario(Usuario usuario)
			throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException;

	public abstract void actualizarUsuario(Usuario usuario);

}