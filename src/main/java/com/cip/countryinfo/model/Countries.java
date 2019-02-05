package com.cip.countryinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_TABLE")
public class Countries implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;
	private String countryName;
	@ManyToOne
	private Languages language;
	@OneToOne
	private Cities capital;
	@ManyToMany
	private List<Sports> listSports = new ArrayList<Sports>();
	
	public List<Sports> getListSports() {
		return listSports;
	}

	public void setListSports(List<Sports> listSports) {
		this.listSports = listSports;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
	}

	public Cities getCapital() {
		return capital;
	}

	public void setCapital(Cities capital) {
		this.capital = capital;
	}

}
