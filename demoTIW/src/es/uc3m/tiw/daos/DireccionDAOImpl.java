package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominios.Direccion;

public class DireccionDAOImpl implements DireccionDAO {
	private final EntityManager em;
	private final UserTransaction ut;
	
	public DireccionDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.DireccionDAO#crearDireccion(es.uc3m.tiw.dominios.Direccion)
	 */
	@Override
	public Direccion crearDireccion(Direccion direccion)throws Exception{
		ut.begin();
		em.persist(direccion);
		ut.commit();
		return direccion;
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.DireccionDAO#borrarDireccion(es.uc3m.tiw.dominios.Direccion)
	 */
	@Override
	public void borrarDireccion(Direccion direccion)throws Exception{
		ut.begin();
		em.remove(em.merge(direccion));
		ut.commit();
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.daos.DireccionDAO#actualizarDireccion(es.uc3m.tiw.dominios.Direccion)
	 */
	@Override
	public Direccion actualizarDireccion(Direccion direccionActualizada) throws Exception{
		ut.begin();
		em.merge(direccionActualizada);
		ut.commit();
		return direccionActualizada;
	}

}
