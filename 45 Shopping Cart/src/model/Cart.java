package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the CART database table.
 * 
 */
@Table(name="CART", schema="TESTDB")
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "CartSeq", sequenceName = "CART_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CartSeq")
	private long id;

	private int bought;

	private String name;

	private double price;

	private double quant;

	private String uemail;

	public Cart() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBought() {
		return this.bought;
	}

	public void setBought(int i) {
		this.bought = i;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public double getQuant() {
		return this.quant;
	}

	public void setQuant(double d) {
		this.quant = d;
	}

	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

}