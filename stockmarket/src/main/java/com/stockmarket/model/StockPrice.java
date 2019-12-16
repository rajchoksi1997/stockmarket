/**
 * 
 */
package com.stockmarket.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "StockPrice")
public class StockPrice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630135355292560952L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockpriceId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "companyId")
	private Company company;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "stockExchangeName")
	private StockExchange stockExchange;

	private double stockPrice;

	private Date date;

	private Time time;

	public StockPrice() {
	}
	

	public int getStockpriceId() {
		return stockpriceId;
	}


	public void setStockpriceId(int stockpriceId) {
		this.stockpriceId = stockpriceId;
	}


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	@Column(name = "StockPrice", nullable = false)
	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Column(name = "Date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Time", nullable = false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [company=" + company + ", stockExchange=" + stockExchange + ", stockPrice=" + stockPrice
				+ ", date=" + date + ", time=" + time + "]";
	}

}
