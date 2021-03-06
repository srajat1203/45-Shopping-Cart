

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.User;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class Addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtocart() {
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
		String uemail = curuser.getEmail();
		
		
		double price = (Double) session.getAttribute("cprice");
		String name = (String) session.getAttribute("cname");
		String temp_quant = request.getParameter("quantity");
		int quant = Integer.parseInt(temp_quant);
		
		
		Cart cartentry = new Cart();
		cartentry.setName(name);
		cartentry.setPrice(price);
		cartentry.setQuant(quant);
		cartentry.setUemail(uemail);
		cartentry.setBought(0);
		
		Utils<Cart> db = new Utils<Cart>();
		db.insert(cartentry);
		
		//Prod prod = new Prod();
		//prod.setName(name);
		//prod.setPrice(price);
		//prod.setQuant(quant);
		
		//List<Prod> items = (List<Prod>) session.getAttribute("items");
		//items.add(prod);
		
		response.setContentType("text/html");		
		
		getServletContext().getRequestDispatcher("/ProductList")
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
