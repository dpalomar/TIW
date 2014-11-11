package daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import dominios.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	EntityManager em;
	UserTransaction ut;
	
	
	
	public UsuarioDaoImpl(EntityManager em, UserTransaction ut) {

		this.em = em;
		this.ut = ut;
	}

	/* (non-Javadoc)
	 * @see daos.UsuarioDao#guardarUsuario(dominios.Usuario)
	 */
	@Override
	public Usuario guardarUsuario(Usuario usuario) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.persist(usuario);
		ut.commit();
		return usuario;
	}
	
	/* (non-Javadoc)
	 * @see daos.UsuarioDao#buscarUsuario(java.lang.Long)
	 */
	@Override
	public Usuario buscarUsuario(Long id){
		return em.find(Usuario.class, id);
	}
	
	@Override
	public void deleteUsuario(Usuario usuario) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		
		ut.begin();
		em.remove(em.merge(usuario));
		ut.commit();
	}

}
