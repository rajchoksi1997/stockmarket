/**
 * 
 */
package com.stockmarket.model;

import java.io.Serializable;

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
@Table(name = "IPODetails")
public class IPODetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3900068091412784952L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ipoId;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_name")
	private Company company;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "stockExchangeName")
	private StockExchange stockExchange;

	private double pricePerShare;
	private int numberofShares;
	private String remark;

	public IPODetails() {

	}

	public long getIpoId() {
		return ipoId;
	}

	public void setIpoId(long ipoId) {
		this.ipoId = ipoId;
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

	@Column(name = "PricePerShare", nullable = false)
	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	@Column(name = "NumberofShares", nullable = false)
	public int getNumberofShares() {
		return numberofShares;
	}

	public void setNumberofShares(int numberofShares) {
		this.numberofShares = numberofShares;
	}

	@Column(name = "NumberofShares", nullable = true)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "IPODetails [ipoId=" + ipoId + ", company=" + company + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", numberofShares=" + numberofShares + ", remark=" + remark
				+ "]";
	}

}

