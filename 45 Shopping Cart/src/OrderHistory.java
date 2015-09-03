

import java.io.IOException;
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

import model.Cart;
import model.Product;
import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	String inames = "";
	String iprices = "";
	String iquants = "";
	String iuemails = "";
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session = request.getSession();
		User curuser = (User) session.getAttribute("curuser");
		String email = curuser.getEmail();
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		
		String oHistory = "<li class = \"active\"><a href=\"OrderHistory?curemail = " + curuser.getEmail() + "\">Order History</a></li>";
		
		
		String qString = "SELECT c FROM Cart c where c.uemail = '" + email + "' and c.bought = 1";
		TypedQuery<Cart> q =  em.createQuery(qString, Cart.class);
		List<Cart> items = q.getResultList();
		
		inames = "";
		iprices = "";
		iquants = "";
		iuemails = "";
		for(Cart cur: items)
		{
			inames = inames + cur.getName() + "<br><br>";
			iprices = iprices +  cur.getPrice() + "<br><br>"; 
			iquants = iquants + cur.getQuant() + "<br><br>";
			iuemails = iuemails + cur.getUemail() + "<br><br>";
		}
		
		
		response.setContentType("text/html");	
		request.setAttribute("inames", inames);
		request.setAttribute("iprices", iprices);
		request.setAttribute("iquants", iquants);
		request.setAttribute("iuemails", iuemails);
		request.setAttribute("oHistory", oHistory);
		getServletContext().getRequestDispatcher("/OrderHistoryDisp.jsp")
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
