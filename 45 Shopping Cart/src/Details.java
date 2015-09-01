

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

import model.Pdetail;
import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String name = "";
	double price = 0.0;
	String genre = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		String temp_pid = request.getParameter("pid");
		int pid = Integer.parseInt(temp_pid);
		String qString = "SELECT p FROM Product p where p.id = " + pid;
		TypedQuery<Product> q =  em.createQuery(qString, Product.class);
		Product product = q.getSingleResult();
		name = product.getGame();
		
		String qString2 = "SELECT d FROM Pdetail d where d.id = " + pid;
		TypedQuery<Pdetail> q2 =  em.createQuery(qString2, Pdetail.class);
		Pdetail pdetail = q2.getSingleResult();
		price = pdetail.getPrice();
		genre = pdetail.getGenre();
		
		HttpSession session = request.getSession();
		session.setAttribute("cname", name);
		session.setAttribute("cprice", price);
		
		
		/*
		try {
			price = 0.0;
			genre = "";
			for (Pdetail cur : details) {
				
				price = cur.getPrice(); 
				genre = cur.getGenre();
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				em.close();
			}
		*/
		
		

		response.setContentType("text/html");		
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("genre", genre);
		getServletContext().getRequestDispatcher("/DetailsDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
