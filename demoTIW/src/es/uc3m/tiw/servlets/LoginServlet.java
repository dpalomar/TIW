package es.uc3m.tiw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//actualizamos el request para añadirle un atributo
		request.setAttribute("miAtributo", "que tengo un atributo");
		
		//si accede por el formulario de manera normal y se autentica correctamente lo indicamos en la sesión.
		HttpSession sesion = request.getSession();
		//si el nombre/clave concuerdan con usuario1 le damos la bienvenida si no le devolvemos al formulario de login
		if(nombre.equalsIgnoreCase("usuario1") && clave.equalsIgnoreCase("usuario1")){
			sesion.setAttribute("autenticado", "si");
			this.getServletContext().getRequestDispatcher("/bienvenido.jsp").forward(request, response);
		}
		else{
			sesion.setAttribute("autenticado", "no");
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					
		}
	}

}
