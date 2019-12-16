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
@Table(name = "Company")
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1986838745254967596L;
	@Id
	private int companyId;
	private String companyName;
	private long turnover;
	private String ceoName;
	private String boardofDirectors;
	private Boolean listedInStockExchanges;
	private String sector;
	private String briefWriteUp;
	private String stockCode;
	private boolean isCompanyBlocked;

	public Company() {

	}
	

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "companyName", nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "turnover", nullable = false)

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	@Column(name = "CEO", nullable = false)
	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	@Column(name = "BoardofDirectors", nullable = false)
	public String getBoardofDirectors() {
		return boardofDirectors;
	}

	public void setBoardofDirectors(String boardofDirectors) {
		this.boardofDirectors = boardofDirectors;
	}

	@Column(name = "ListedInStockExchanges", nullable = false)
	public Boolean getListedInStockExchanges() {
		return listedInStockExchanges;
	}

	public void setListedInStockExchanges(Boolean listedInStockExchanges) {
		this.listedInStockExchanges = listedInStockExchanges;
	}

	@Column(name = "Sector", nullable = false)
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Column(name = "BriefWriteUp", nullable = false)
	public String getBriefWriteUp() {
		return briefWriteUp;
	}

	public void setBriefWriteUp(String briefWriteUp) {
		this.briefWriteUp = briefWriteUp;
	}

	@Column(name = "StockCode", nullable = false)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public boolean getIsCompanyBlocked() {
		return isCompanyBlocked;
	}


	public void setIsCompanyBlocked(boolean isCompanyBlocked) {
		this.isCompanyBlocked = isCompanyBlocked;
	}


	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", turnover=" + turnover
				+ ", ceoName=" + ceoName + ", boardofDirectors=" + boardofDirectors + ", listedInStockExchanges="
				+ listedInStockExchanges + ", sector=" + sector + ", briefWriteUp=" + briefWriteUp + ", stockCode="
				+ stockCode + ", isCompanyBlocked=" + isCompanyBlocked + "]";
	}


	
}
