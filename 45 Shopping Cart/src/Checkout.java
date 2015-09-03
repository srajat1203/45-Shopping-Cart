

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
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String inames = "";
	private String iprices = "";
	private String iquants = "";
    private double sum = 0.0;
    private double taxrate = 0.06;
    private double tax = 0.0;
    private double total = 0.0;
    private double credit = 0.0;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		List<Prod> items = (List<Prod>) session.getAttribute("items");
		User curuser = (User) session.getAttribute("curuser");
		String uemail = curuser.getEmail();
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		/*
		trans.begin(); 
		try {
			for(Prod prod: items)
			{	
				Cart cartentry = new Cart();
				cartentry.setName(prod.getName());
				cartentry.setPrice(prod.getPrice());
				cartentry.setQuant(prod.getQuant());
				cartentry.setUemail(uemail);
				cartentry.setBought(0);
			
				em.persist(cartentry);
			}	
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		//em.close();
		}
		*/
		
		
		
		/*
		for(Prod prod: items)
		{
			Cart cartentry = new Cart();
			cartentry.setName(prod.getName());
			cartentry.setPrice(prod.getPrice());
			cartentry.setQuant(prod.getQuant());
			cartentry.setUemail(uemail);
			cartentry.setBought(0);
		
			Utils<Cart> db = new Utils<Cart>();
			db.insert(cartentry);
			
		}
		*/
		String qString = "SELECT c FROM Cart c where c.uemail = '" + uemail + "' and c.bought = 0";
		TypedQuery<Cart> q =  em.createQuery(qString, Cart.class);
		List<Cart> cartitems = q.getResultList();
		
		try {
			inames = "";
			iprices = "";
			iquants = "";
			sum = 0.0;
			for (Cart cur : cartitems) {
			
				inames = inames + cur.getName() + "<br><br>";
				iprices = iprices +  cur.getPrice() + "<br><br>"; 
				iquants = iquants + cur.getQuant() + "<br><br>";
				
				sum = sum + cur.getPrice()*cur.getQuant();
				
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				//em.close();
			}
		
		
		tax = sum*taxrate;
		
		
		String qString2 = "SELECT u FROM User u where u.email = '" + uemail + "'";
		TypedQuery<User> q2 =  em.createQuery(qString2, User.class);
		User user = new User();
		try{
			user = q2.getSingleResult();
		}
		catch(Exception e){
			
		}
		finally {
			em.close();
		}
		
		credit = user.getCredit();
		
		total = sum + tax - credit;
		
		response.setContentType("text/html");		
		request.setAttribute("inames", inames);
		request.setAttribute("iprices", iprices);
		request.setAttribute("iquants", iquants);
		request.setAttribute("sum", sum);
		request.setAttribute("tax", tax);
		request.setAttribute("total", total);
		request.setAttribute("credit", credit);
		//request.setAttribute("genre", genre);
		getServletContext().getRequestDispatcher("/CheckoutDisp.jsp")
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
