/**
 * 
 */
package com.stockmarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "Sectors")
public class Sectors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6723221370468676821L;
	private long sectorId;
	private String sectorName;
	private String brief;

	public Sectors() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSectorId() {
		return sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	@Column(name = "Sector", nullable = false)
	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	@Column(name = "Brief", nullable = false)
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "Sectors [sectorId=" + sectorId + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}

}
