package es.uc3m.tiw.daos;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private final EntityManager em;
	private final UserTransaction ut;
	
	
	
	public UsuarioDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}



	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.UsuarioDAO#guardarUsuario(es.uc3m.tiw.dominios.Usuario)
	 */
	@Override
	public Usuario guardarUsuario(Usuario nuevoUsuario) throws Exception{
		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		return nuevoUsuario;
		
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.UsuarioDAO#modificarUsuario(es.uc3m.tiw.dominios.Usuario)
	 */
	@Override
	public Usuario modificarUsuario(Usuario usuario) throws Exception{
		ut.begin();
		em.merge(usuario);
		ut.commit();
		return usuario;
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.UsuarioDAO#borrarUsuario(es.uc3m.tiw.dominios.Usuario)
	 */
	@Override
	public void borrarUsuario(Usuario usuario) throws Exception{
		ut.begin();
		em.remove(em.merge(usuario));
		ut.commit();
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.UsuarioDAO#recuperarUsuarioPorPK(java.lang.Integer)
	 */
	@Override
	public Usuario recuperarUsuarioPorPK(Long pk){
		return em.find(Usuario.class, pk);
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.UsuarioDAO#recuperarUsuarioPorNombre(java.lang.String)
	 */
	@Override
	public Usuario recuperarUsuarioPorNombre(String nombre) {
		return em.createQuery("select u from Usuario u where u.nombre="+nombre, Usuario.class).getSingleResult();
	}
	@Override
	public Usuario buscarPorNombreYpassword(String nombre,String password)throws NoResultException{
		return em.createQuery("select u from Usuario u where u.nombre='"+nombre+"' and u.password='"+password+"'",Usuario.class).getSingleResult();
	}
	
	public Collection<Usuario> buscarTodosLosUsuarios(){
		return em.createQuery("select u from Usuario u",Usuario.class).getResultList();
	}
	
}
