
public class Prod {

	private String name;
	private double price;
	private int quant;
	private String uemail;
	
	public Prod()
	{
		name = "";
		price = 0.0;
		quant = 0;
		uemail = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	
}
