package es.uc3m.tiw.daos;

import es.uc3m.tiw.dominios.Direccion;

public interface DireccionDAO {

	public abstract Direccion crearDireccion(Direccion direccion)
			throws Exception;

	public abstract void borrarDireccion(Direccion direccion) throws Exception;

	public abstract Direccion actualizarDireccion(Direccion direccionActualizada)
			throws Exception;

}