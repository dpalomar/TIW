package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import dominios.Direccion;

public class DireccionDaoImpl implements DireccionDao {
	
	EntityManager em;
	UserTransaction ut;
	
	
	

	public DireccionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Direccion saveDireccion(Direccion direccion) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(direccion);
		ut.commit();
		return direccion;
	}

	@Override
	public Direccion updateDireccion(Direccion direccion) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException {
		// TODO Auto-generated method stub
		
		ut.begin();
		em.merge(direccion);
		ut.commit();
		return direccion;
	}

	@Override
	public void removeDireccion(Direccion direccion) throws Exception{
		
		ut.begin();
		em.remove(em.merge(direccion));
		ut.commit();
	} 

	@Override
	public Direccion findDireccion(Long pk) {
		
		return em.find(Direccion.class, pk);
	}

	@Override
	public List<Direccion> findAll() {
		
		return em.createQuery("select from Direccion").getResultList();
	}

}
