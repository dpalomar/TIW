package daos;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dominios.Direccion;

public interface DireccionDao {

	public Direccion saveDireccion(Direccion direccion) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	public Direccion updateDireccion(Direccion direccion) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;
	public void removeDireccion(Direccion direccion) throws Exception;
	public Direccion findDireccion(Long pk);
	public List<Direccion> findAll();
	
	
	
}
