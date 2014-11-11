package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
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

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao dao;
	@PersistenceContext(unitName="pruebaJPA")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	dao = new UsuarioDaoImpl(em,ut);
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = null;
		String evento = request.getParameter("evento");
		try {
			if (evento == null) {
				
				
				
				usuario = new Usuario("david", "123456");
				Direccion direccion = new Direccion("Gran via", "Madrid", "Madrid", 28080);
				//con esto insertariamos una sola direccion
				usuario.setDireccion(direccion);
				Direccion direccion2 = new Direccion("via Grande", "Madrid", "Madrid", 28000);
				Direccion direccion3 = new Direccion("Otra mas", "Madrid", "Majadahonda", 28220);
				//cuidado con esto, si se añade sin inicializar la coleccion en la clase Usuario dara un NullPointerException
				usuario.getDirecciones().add(direccion2);
				usuario.getDirecciones().add(direccion3);
			
					dao.guardarUsuario(usuario);
					request.setAttribute("usuario", dao.buscarUsuario(usuario.getId()));
			
			}
			else{
				Long id = Long.parseLong(request.getParameter("id"));
				Usuario u = dao.buscarUsuario(id);
				
				//esto borra el usuario y sus direcciones asociadas por el cascade
				dao.deleteUsuario(u);
				

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

			// 1º ejemplo
//			PrintWriter out = response.getWriter();
//			out.println(dao.buscarUsuario(usuario.getId()));
//			out.close();
			

			this.getServletConfig().getServletContext().getRequestDispatcher("/usuario.jsp").forward(request, response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
