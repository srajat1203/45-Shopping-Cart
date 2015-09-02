

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Product;
import model.User;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String plist = "";
	String goToCart = "<form action=\"Checkout\" method = \"post\"> <button type=\"submit\" class=\"btn btn-default\">Checkout</button> </form>";
	String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		message = "";
		HttpSession session = request.getSession();
		User curuser = (User) session.getAttribute("curuser");
		if(curuser != null)
		{
			message = goToCart;
		}
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		String qString = "SELECT p FROM Product p";
		TypedQuery<Product> q =  em.createQuery(qString, Product.class);
		List<Product> products = q.getResultList();
		
		try {
			plist = "";
			for (Product cur : products) {
			
				int id = (int) cur.getId();
				String name = cur.getGame();
				plist = plist + "<a href=\"Details?pid=" + id + "\">" + name + "</a><br><br>";
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				em.close();
			}
		
		
		response.setContentType("text/html");
		request.setAttribute("plist", plist);
		request.setAttribute("message", message);
		request.setAttribute("ps", products);
		getServletContext().getRequestDispatcher("/ProductListDisp.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
