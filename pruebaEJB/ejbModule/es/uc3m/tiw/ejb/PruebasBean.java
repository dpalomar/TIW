package es.uc3m.tiw.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import daos.UsuarioDao;
import daos.UsuarioDaoImpl;
import dominios.Usuario;

/**
 * Session Bean implementation class PruebasBean.
 * El mappedName permite acceder al Bean como un alias
 * y es trasaccional con delegacion en el contenedor
 */
@LocalBean
@Stateless(name="pruebas")
public class PruebasBean implements PruebasBeanLocal, PruebasBeanRemote {
	
	@PersistenceContext(unitName="pruebaJPA")
	private EntityManager em;
	private UsuarioDao dao;
    /**
     * Cuidado con inicializar el DAO en el constructor porque todavia aqui no se ha
     * inyectado el EntityManager y seria null
     */
    public PruebasBean() {
    	//FIXME: No inicializar el DAO en el constructor. Ver el javadoc anterior
   
    	System.out.println("*****CONSTRUCTOR LLAMADO");
        if (em != null) {
    			System.out.println("******EJB EM no es null");
    			
    		}else{
    			System.out.println("*****EJB EM es null");
    		}
        
        
    }
    /**
     * Este metodo no debe ir en el interfaz y se llamara despues de haber realizado
     * las inyecciones oportunas
     * 
     */
    @PostConstruct
    public void desPuesDelConstructor(){
        dao = new UsuarioDaoImpl(em); //FIXME: Aqui ya se ha inyectado el EntityManager
    	System.out.println("*******LLAMADO DESPUES DEL CONSTRUCTOR");
        if (em != null) {
    			System.out.println("******EJB EM no es null");
    			
    		}else{
    			System.out.println("*****EJB EM es null");
    		}
    }
    /**
     * Ejemplo de metodo con parametros y retorno.
     * Debe ir en el interfaz
     * @param operador1 primer sumando
     * @param operador2 segundo sumando
     * @return resultado
     */

	@Override
	public int suma(int operador1, int operador2){
    	return operador1+operador2;
    }
    /**
     * Ejemplo de metodo sin parametro de entrada y con resultado.
     * Debe ir en el interfaz
     * @return
     */
 
	@Override
	public String saludo(){
    	return "Hola";
    }
    /**
     * ejemplo de metodo transaccional que usa el {@link EntityManager} y delega las transacciones al contenedor
     * por lo que no es necesario usar {@link UserTransaction}
     * @param nombre 
     * @param password
     * @return usuario con clave primaria y por lo tanto persistente
     * @throws HeuristicRollbackException 
     * @throws HeuristicMixedException 
     * @throws RollbackException 
     * @throws SystemException 
     * @throws NotSupportedException 
     * @throws IllegalStateException 
     * @throws SecurityException 
     */

	@Override
    public Usuario guardarUnUsuarioEnLaBaseDeDatos(String nombre,String password) throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
    	Usuario u = new Usuario(nombre, password);
    	dao.guardarUsuario(u);
    	return u;
    }
	@Override
	public Usuario buscaUsuario(Long id) {
		
		return dao.buscarUsuario(id);
	}
	@Override
	public void actualizarUnUsuarioConDireccion(Usuario usuario) {
		dao.actualizarUsuario(usuario);
		
	}
}
