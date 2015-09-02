

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

import model.Cart;

import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String inames = "";
	String iprices = "";
	String iquants = "";
	String iuemails = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		
		String qString = "SELECT c FROM Cart c where c.bought = 1";
		TypedQuery<Cart> q =  em.createQuery(qString, Cart.class);
		List<Cart> doneitems = q.getResultList();
		
		try {
			
			for (Cart cur : doneitems) {
			
				inames = inames + cur.getName() + "<br><br>";
				iprices = iprices +  cur.getPrice() + "<br><br>"; 
				iquants = iquants + cur.getQuant() + "<br><br>";
				iuemails = iuemails + cur.getUemail() + "<br><br>";
				
				
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				//em.close();
			}
		

		
		//master
		
		String cremail = request.getParameter("cremail");
		String temp_amount = request.getParameter("amount");
		double amount = 0.0;
		if(temp_amount != null)
		{
			if(!temp_amount.isEmpty())
			{
				 amount = Double.parseDouble(temp_amount);
			}
		}
		
		if(cremail != null)
		{
			if(!cremail.isEmpty())
			{

				String qString2 = "SELECT u FROM User u where u.email = '" + cremail + "'";
				TypedQuery<User> q2 =  em.createQuery(qString2, User.class);
				User u = new User();
				try{
					u  = q2.getSingleResult();
				}
				catch(Exception e){
					
				}
				finally{
					em.close();
				}
				
				if(u.getEmail() != null)
				{
					Utils<User> db = new Utils<User>();
					u.setCredit(amount);
					db.update(u);
				}
				
				
			}
		}	
		
		
		
		
		response.setContentType("text/html");		
		request.setAttribute("inames", inames);
		request.setAttribute("iprices", iprices);
		request.setAttribute("iquants", iquants);
		request.setAttribute("iuemails", iuemails);
		getServletContext().getRequestDispatcher("/AdminDisp.jsp")
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
