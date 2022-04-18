package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Account;
import DAO.LoginDAO;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		Account acc = LoginDAO.checkLogin(user, pass);
		if(acc != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", 1);
			session.setAttribute("fullname", acc.getFullname());
			session.setAttribute("kt", "Logout");
			response.sendRedirect("HomeController");
		}
		else request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
	}

}
