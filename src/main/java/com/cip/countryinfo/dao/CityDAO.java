package com.cip.countryinfo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.Cities;

public class CityDAO {

	public static void addCityName(String cityName) {
		Session session = HibernateUtil.openSession();
		Cities city = new Cities();
		try {
			city.setCityName(cityName);
			session.beginTransaction();
			session.save(city);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Object getCityList() {
		Session session = HibernateUtil.openSession();
		List<String> cityList = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Cities.class);
			criteria.setProjection(Projections.property("cityName"));
			cityList = criteria.list();
			session.getTransaction().commit();
			return cityList;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cityList;

	}
	
}
