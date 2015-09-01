

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// = "";
		//total = 0;
		
		for(Prod p: items)
		{
			inames = inames + p.getName() + "<br><br>";
			iprices = iprices +  p.getPrice() + "<br><br>"; 
			iquants = iquants + p.getQuant() + "<br><br>";
			
			sum = sum + p.getPrice()*p.getQuant();
		}
		
		
		
		
		
		
		
		
		response.setContentType("text/html");		
		request.setAttribute("inames", inames);
		request.setAttribute("iprices", iprices);
		request.setAttribute("iquants", iquants);
		request.setAttribute("sum", sum);
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
