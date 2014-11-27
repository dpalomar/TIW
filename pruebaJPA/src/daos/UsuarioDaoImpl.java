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
/**
 * 
 * Esta clase ya no necesita las transacciones manuales, estas estan delegadas al contenedor
 * Se podia haber declarado tambien como EJB y haber inyectado posteriormente 
 * en el servicio {@link PruebaBean} o bien que el propio dao pidiera ell persistencecontext
 * @author David Palomar
 *
 */
public class UsuarioDaoImpl implements UsuarioDao {
	
	EntityManager em;
	
	// no necesarioUserTransaction ut;
	
	


	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}

	/* (non-Javadoc)
	 * @see daos.UsuarioDao#guardarUsuario(dominios.Usuario)
	 */
	@Override
	public Usuario guardarUsuario(Usuario usuario) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		
		em.persist(usuario);
		
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
		
		
		em.remove(em.merge(usuario));
		
	}

}
