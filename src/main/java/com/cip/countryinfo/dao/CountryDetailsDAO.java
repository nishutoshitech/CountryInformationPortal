package com.cip.countryinfo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.Cities;
import com.cip.countryinfo.model.Countries;
import com.cip.countryinfo.model.Languages;
import com.cip.countryinfo.model.Sports;

public class CountryDetailsDAO {
	private Countries country = new Countries();
	private Cities city = new Cities();
	private Sports sports = null;
	private Languages language = new Languages();

	public void setCountryDetails(String country, String city, String language, String[] sportsList) {
		this.country.setCountryName(country);
		this.language.setLanguageName(language);
		this.city.setCityName(city);

		this.country.setCapital(this.city);
		this.country.setLanguage(this.language);
		for (int i = 0; i < sportsList.length; i++) {
			this.sports.setSportsName(sportsList[i]);
			this.country.getListSports().add(sports);
		}
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.save(this.country);
			session.save(this.city);
			session.save(this.sports);
			session.save(this.language);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
