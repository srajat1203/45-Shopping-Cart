

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

import model.Product;
import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private int choice = 2;
	private String npage = "";
	private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> No such user exists </div>";
	private String message = "";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = request.getParameter("email");
		if(email != null)
		{
			if(!email.isEmpty())
			{
				
				if(email.equals("master@admin.com"))
				{
					choice = 3;
				}
				else
				{	
					EntityManager em = DBUtil.getEmFactory().createEntityManager();
					EntityTransaction trans = em.getTransaction();
					
					User user = new User();
					String qString = "SELECT u FROM User u where u.email = '" + email + "'";
					TypedQuery<User> q =  em.createQuery(qString, User.class);
					try{
						user = q.getSingleResult();
					}
					catch(Exception e){
						
					}
					
					if(user.getEmail() != null)
					{
						choice = 1;
						HttpSession session = request.getSession();
						session.setAttribute("curuser", user);
						
					}
					else
					{
						choice = 2;
						message = err;
					}
					
				}
			}
		}
		
		
	    if(choice == 1)
	    {
	    	npage = "/First";
	    }
	    else if (choice == 2)
	    {
	    	npage = "/LoginDisp.jsp";
	    }
	    else if (choice == 3)
	    {
	    	npage = "/Admin";
	    }
	    
		response.setContentType("text/html");
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(npage)
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
