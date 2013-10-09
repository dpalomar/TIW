package es.uc3m.tiw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		this.getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los contenidos del request del cliente y añadimos un atributo que no estaba inicialmente al request
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		//si el nombre/clave concuerdan con usuario1 le damos la bienvenida si no le devolvemos al formulario de login
		if(nombre.equalsIgnoreCase("usuario1") && clave.equalsIgnoreCase("usuario1")){
			this.getServletContext().getRequestDispatcher("/bienvenido.jsp").forward(request, response);
		}
		else{
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					
		}
	}

}
