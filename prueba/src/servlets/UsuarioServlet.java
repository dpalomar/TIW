package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import daos.UsuarioDao;
import daos.UsuarioDaoImpl;
import dominios.Direccion;
import dominios.Usuario;
import ejb.jms.EscribeEnQueue;
import es.uc3m.tiw.ejb.PruebasBeanLocal;
import es.uc3m.tiw.ejb.PruebasBeanRemote;

/**
 * El servlet delega ahora parte de su comportamiento a la capa de servicios EJB
 * En concreto a {@link PruebaBean} y por lo tanto no necesita {@link EntityManager} ni {@link UserTransaction}
 * El codigo tambien se adapta a esta nueva situacion.
 * @author David Palomar
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB(name="pruebas")
	private PruebasBeanRemote servicio;
	
	private EscribeEnQueue cola;
/*	
 * El servlet ya no instancia el Entitymanager y a cambio usa el servicio PruebaBean, 
 * por lo que tampoco necesita crear las transacciones manualmente
 * private UsuarioDao dao;
 * @PersistenceContext(unitName="pruebaJPA")
	private EntityManager em;
	@Resource
	private UserTransaction ut;*/
       
	@Override
	public void init() throws ServletException {
		cola = new EscribeEnQueue();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();

    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("password");
		try {
		
			Usuario usuario = servicio.guardarUnUsuarioEnLaBaseDeDatos(nombre, clave);
			String saludo = servicio.saludo();
			String suma = String.valueOf(servicio.suma(3, 2));
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("suma", suma);
			request.setAttribute("saludo", saludo);
			this.getServletConfig().getServletContext().getRequestDispatcher("/usuario.jsp").forward(request, response);
		
		} catch (SecurityException | IllegalStateException
				| NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String evento = request.getParameter("evento");
		if (evento.equalsIgnoreCase("direccion")) {
			String calle = request.getParameter("calle");
			String localidad = request.getParameter("localidad");
			int codigoPostal = Integer.parseInt(request.getParameter("cp"));
			String ciudad = request.getParameter("ciudad");
			Direccion direccion = new Direccion(calle, ciudad, localidad, codigoPostal);
			
			cola.enviar(direccion);
			
			PrintWriter out = response.getWriter();
			out.println("Usuario actualizado con su direccion correctamente, puedes verlo en la base de datos");
			out.close();
			
		}else{
			
		
			doGet(request, response);
		}
	}

}
