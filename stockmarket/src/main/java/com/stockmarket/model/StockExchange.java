/**
 * 
 */
package com.stockmarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "StockExchange")
public class StockExchange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7224806142700772709L;
	@Id
	private long stockExchangeId;
	private String stockExchangeName;
	private String brief;
	private String contactAddress;
	private String remarks;

	public StockExchange() {

	}



	public long getStockExchangeId() {
		return stockExchangeId;
	}

	public void setStockExchangeId(long stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}

	@Column(name = "stockExchangeName", nullable = false)
	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	@Column(name = "Brief", nullable = false)
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "ContactAddress", nullable = false)
	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Column(name = "Remarks", nullable = true)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StockExchange [stockExchangeId=" + stockExchangeId + ", stockExchangeName=" + stockExchangeName
				+ ", brief=" + brief + ", contactAddress=" + contactAddress + ", remarks=" + remarks + "]";
	}

}
