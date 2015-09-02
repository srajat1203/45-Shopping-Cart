

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

import customTools.DBUtil;
import model.Product;
import model.User;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pname = request.getParameter("pname");
		String pemail = request.getParameter("pemail");
		
		System.out.println(pname + pemail);
		
		User user = new User();
		user.setName(pname);
		user.setEmail(pemail);
		user.setCredit(0.0);
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		User u = new User();
		String qString = "SELECT u FROM User u where u.email = '" + pemail + "'";
		TypedQuery<User> q =  em.createQuery(qString, User.class);
		try{
			u = q.getSingleResult();
		}
		catch(Exception e){
			
		}
		
		if(u.getEmail() == null)
		{
			//System.out.println("making");
			Utils<User> db = new Utils<User>();
			db.insert(user);
		}
		
		response.setContentType("text/html");	
		getServletContext().getRequestDispatcher("/LoginDisp.jsp")
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
