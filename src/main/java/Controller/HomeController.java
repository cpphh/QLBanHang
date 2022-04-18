package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Account;
import BEAN.Product;
import DAO.LoginDAO;
import DAO.ProductDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = "Login";
		HttpSession session = request.getSession();
		if(session.getAttribute("login") != null) s = "";
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		int limit = 3;
		int start = (page - 1) * limit;
		int count = ProductDAO.getCount();
		int maxPage = count/limit;
		if(count%limit != 0) maxPage ++;
		if(request.getParameter("work") != null) {
			String work = request.getParameter("work");
			String id = "";
			
			if(work.equals("delete")) {
				id = request.getParameter("id");
				ProductDAO.deleteProduct(id);
			}
			if(work.equals("edit")) {
				id = request.getParameter("id");
				Product product = ProductDAO.selectProduct(id);
				request.setAttribute("product", product);
				request.getRequestDispatcher("views/AddProduct.jsp").forward(request, response);
			}
			if(work.equals("add")) {
				request.getRequestDispatcher("views/AddProduct.jsp").forward(request, response);
			}
		}
		
		List<Product> list = ProductDAO.DisplayProduct(start, limit);
		request.setAttribute("listProduct", list);
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("checkLogin", s);
		request.setAttribute("checkLogout", "");
		request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("work") != null) {
			String work = request.getParameter("work");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String classify = request.getParameter("classify");
			String picture = request.getParameter("picture");
			
			if(work.equals("edit")) {
				ProductDAO.editProduct(id, name, price, classify, picture);
				
				String contextPath = request.getContextPath();
	            response.sendRedirect(contextPath);
			}
			if(work.equals("add")) {
				ProductDAO.addProduct(id, name, price, classify, picture);
				
				String contextPath = request.getContextPath();
	            response.sendRedirect(contextPath);
			}
		}
	}

}
