package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PDETAILS database table.
 * 
 */
@Entity
@Table(name="PDETAILS", schema="TESTDB")
@NamedQuery(name="Pdetail.findAll", query="SELECT p FROM Pdetail p")
public class Pdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String genre;

	private double price;

	public Pdetail() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}