package UI.Web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Usuario;
import Entities.Rol;
import Logic.UsuarioLogic;
import Logic.RolLogic;

@WebServlet("/login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Login() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UsuarioLogic usrLogic = new UsuarioLogic();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		Usuario u = usrLogic.getOne(user, pass);
		
		// u = ctrl.validate(u);
		
		request.getSession().setAttribute("usuario", u);
		// LinkedList<Usuario> usuarios = usrLogic.getAll();
		
		response.getWriter().append("Bienvenido ").append(u.getNombre()).append(' ').append(u.getApellido()).append(" y su rol es: ").append(u.getRol().getDescripcion());
	}

}
