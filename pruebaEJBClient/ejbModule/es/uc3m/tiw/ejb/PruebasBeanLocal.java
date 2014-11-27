package es.uc3m.tiw.ejb;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import dominios.Usuario;

@Local
public interface PruebasBeanLocal {


	public abstract Usuario guardarUnUsuarioEnLaBaseDeDatos(String nombre,
			String password) throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public abstract String saludo();

	public abstract int suma(int operador1, int operador2);

}
