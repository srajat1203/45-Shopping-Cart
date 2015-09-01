
public class Prod {

	private String name;
	private double price;
	private int quant;
	
	public Prod()
	{
		name = "";
		price = 0.0;
		quant = 0;
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
	
}
