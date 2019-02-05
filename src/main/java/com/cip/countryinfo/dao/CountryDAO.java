package com.cip.countryinfo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.Countries;

public class CountryDAO {

	public static void addCountryName(String countryName) {
		Session session = HibernateUtil.openSession();
		Countries country = new Countries();
		try {
			country.setCountryName(countryName);
			session.beginTransaction();
			session.save(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<String> getCountryList() {
		Session session = HibernateUtil.openSession();
		List<String> countryList = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Countries.class);
			criteria.setProjection(Projections.property("countryName"));
			countryList = criteria.list();
			session.getTransaction().commit();
			return countryList;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return countryList;

	}

}
