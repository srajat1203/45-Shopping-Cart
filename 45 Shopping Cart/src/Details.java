

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import model.Rev;
import model.User;
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
	String message = "";
	String addToCart = "<form role=\"form\" action = \"Addtocart\" method = \"post\"> <div class=\"form-group\"> <label for=\"quantity\">Enter quantity:</label> <input type=\"number\" class=\"form-control\" id=\"quantity\" name=\"quantity\" placeholder=\"Enter a number\"> </div> <button type=\"submit\" class=\"btn btn-default\">Add to Cart</button> </form>";
    
	String form = "";
	
  String comts = "";
	String users = "";
	String sts = "";
	String dates = "";
	String revs = "";
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
		
		//System.out.println(comment + " " + rating + " " +pid);
		
		
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
		User curuser = (User) session.getAttribute("curuser");
		message = "";
		if(curuser != null)
		{
			message = addToCart;
		}
		session.setAttribute("cname", name);
		session.setAttribute("cprice", price);
		
		
	//Reviews
		
		//show form if signed in
		form = "";
		if(curuser != null)
		{
			String form_present = "";
			form_present = "<br> <form role=\"form\" action = \"Details\" method = \"post\"> <div class=\"form-group\"> <label for=\"comment\">Comment</label> <input type=\"text\" class=\"form-control\" id=\"comment\" name = \"comment\" placeholder=\"Enter comment\"> </div> <br> <select name=\"rating\"> <optgroup label=\"Rating\" > <option value=\"1\" >1</option> <option value=\"2\">2</option> <option value=\"3\">3</option> <option value=\"4\">4</option> <option value=\"5\">5</option> </optgroup> </select> <input type=\"hidden\" name=\"pid\" value="+pid+"> <br><br> <button type=\"submit\" class=\"btn btn-default\" >Submit</button> </form>";

			form = form_present;
		}
		
		
		//store review if written
		String comment = request.getParameter("comment");
		
		//System.out.println(review);
		
		if(comment != null)
		{
			if(!comment.isEmpty())
			{
				//System.out.println("writing");
				//String comment = request.getParameter("comment");
				String temp_rating = request.getParameter("rating");
				int rating = Integer.parseInt(temp_rating);
				Date d = new Date();
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				String reportDate = df.format(d);
				
				Rev r = new Rev();
				r.setUemail(curuser.getEmail());
				r.setPid(pid);
				r.setComt(comment);
				r.setStars(rating);
				r.setRdate(reportDate);
				
				Utils<Rev> db = new Utils<Rev>();
				db.insert(r);
			}
		}
		
		//read all reviews
	
		
		String findRevs = "SELECT r FROM Rev r where r.pid = " + pid;
		TypedQuery<Rev> z =  em.createQuery(findRevs, Rev.class);
		List<Rev> reviews = z.getResultList();
		
		try {
			revs = "";
			comts = "";
			users = "";
			sts = "";
			dates = "";
			for (Rev cur : reviews) {
			
				int strs = cur.getStars();
				String stars = "";
				if(strs == 1)
				{
					stars = "*";
				}
				else if(strs == 2)
				{
					stars = "**";
				}
				else if(strs == 3)
				{
					stars = "***";
				}
				else if(strs == 4)
				{
					stars = "****";
				}
				else 
				{
					stars = "*****";
				}
				
				//revs = revs + cur.getUemail() + "     " + cur.getComt() + "     " + cur.getRdate() + "     " + stars;
				users += cur.getUemail() + "<br><br>";
				comts += cur.getComt() + "<br><br>";
				sts += stars + "<br><br>";
				dates += cur.getRdate() + "<br><br>";
			}	
			}catch (Exception e){
				e.printStackTrace();
			} finally {
				em.close();
			}
		
		
		
		
		
		
		
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
		request.setAttribute("message", message);
		
		request.setAttribute("form", form);
		//request.setAttribute("revs", revs);
		
		request.setAttribute("users", users);
		request.setAttribute("comts", comts);
		request.setAttribute("sts", sts);
		request.setAttribute("dates", dates);
		
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
