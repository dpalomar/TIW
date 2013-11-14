package es.uc3m.tiw.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import sun.rmi.runtime.Log;

import es.uc3m.tiw.daos.UsuarioDAO;
import es.uc3m.tiw.daos.UsuarioDAOImpl;
import es.uc3m.tiw.dominios.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName="demoTIW")
	private EntityManager em;
    @Resource
    private UserTransaction ut;
    private UsuarioDAO userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UsuarioDAOImpl(em, ut);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//No se permite el acceso directo hay que pasar por el formulario
		//se añade creación de sesión sólo si accede por get
		HttpSession sesion = request.getSession();
		sesion.setAttribute("autenticado", "no");
		
		this.getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los contenidos del request del cliente y añadimos un atributo que no estaba inicialmente al request
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		Usuario usuario = null;
		try {
			usuario = userDao.buscarPorNombreYpassword(nombre, clave);
		} catch (NoResultException nre) {
			System.out.println("usuario no existe en la bbdd");
		}
		//actualizamos el request para añadirle un atributo
		request.setAttribute("miAtributo", "que tengo un atributo");
		
		//si accede por el formulario de manera normal y se autentica correctamente lo indicamos en la sesión.
		HttpSession sesion = request.getSession();
		//si el nombre/clave concuerdan con usuario1 le damos la bienvenida si no le devolvemos al formulario de login
		
		if(usuario!=null){
			sesion.setAttribute("autenticado", "si");
			this.getServletContext().getRequestDispatcher("/bienvenido.jsp").forward(request, response);
		}
		else{
			sesion.setAttribute("autenticado", "no");
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					
		}
	}

}
