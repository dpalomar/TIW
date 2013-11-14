package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.DireccionDAO;
import es.uc3m.tiw.daos.DireccionDAOImpl;
import es.uc3m.tiw.daos.UsuarioDAO;
import es.uc3m.tiw.daos.UsuarioDAOImpl;
import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.utilidades.ACCIONES;

/**
 * Servlet implementation class GestionUsuariosServlet
 */
@WebServlet("/gestionusuarios")
public class GestionUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoTIW")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private UsuarioDAO usDao;
	private DireccionDAO dirDAO;

	private static final String ALTA = "GUARDAR", BAJA = "BORRAR",
			MODIFICAR = "ACTUALIZAR", PREACTUALIZAR = "PRE_ACTUALIZAR",VERLISTA="VERLISTA";
	private ServletConfig config2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionUsuariosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		config2 = config;
		usDao = new UsuarioDAOImpl(em, ut);
		dirDAO = new DireccionDAOImpl(em, ut);

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		usDao = null;
		dirDAO = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Parámetros a través de HTTP
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Long userId = null;
		String calle = request.getParameter("calle");
		String poblacion = request.getParameter("poblacion");
		Integer codigoPostal = new Integer(0);

		String accion = request.getParameter("accion");
		// mensajes y página por defecto
		String mensaje = "";
		String pagina = "gracias.jsp";

		if (accion.equalsIgnoreCase(ALTA)) {
			codigoPostal = recuperarCP(request);

			// Creación de los POJOS
			Direccion direccion = new Direccion(calle, poblacion, codigoPostal);
			Usuario usuario = new Usuario(nombre, password, apellidos, email,
					direccion);
			try {
				usuario = usDao.guardarUsuario(usuario);
				mensaje = "Gracias por registrarse";
				request.setAttribute("user", usuario);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (accion.equalsIgnoreCase(BAJA)) {
			// el usuario debe de existir en la bbdd y lo buscamos por clave
			// primaria
			userId = recuperarId(request);
			Usuario usuario = usDao.recuperarUsuarioPorPK(userId);
			try {
				usDao.borrarUsuario(usuario);
				mensaje = "Usuario borrado correctamente";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (accion.equalsIgnoreCase(MODIFICAR)) {
			codigoPostal = recuperarCP(request);
			userId = recuperarId(request);
			Usuario usuario = usDao.recuperarUsuarioPorPK(userId);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.getDireccion().setCalle(calle);
			usuario.getDireccion().setPoblacion(poblacion);
			usuario.getDireccion().setCp(codigoPostal);
			try {
				usuario = usDao.modificarUsuario(usuario);
				mensaje = "Usuario modificado correctamente";
				request.setAttribute("user", usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (accion.equalsIgnoreCase(PREACTUALIZAR)) {
			pagina = "modificar.jsp";
			userId = recuperarId(request);
			request.setAttribute("user", usDao.recuperarUsuarioPorPK(userId));
		} else if (accion.equalsIgnoreCase(VERLISTA)) {
			Collection<Usuario> listaUsuarios = usDao.buscarTodosLosUsuarios();
			request.setAttribute("listausuarios", listaUsuarios);
			pagina = "listaUsuarios.jsp";
		} else {
			mensaje = "Opción incorrecta";

		}
		request.setAttribute("Mensaje", mensaje);
		config2.getServletContext().getRequestDispatcher("/" + pagina)
				.forward(request, response);

	}

	private int recuperarCP(HttpServletRequest request) {
		return Integer.parseInt(request.getParameter("cp"));
	}

	private Long recuperarId(HttpServletRequest request) {
		return Long.parseLong(request.getParameter("id"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
