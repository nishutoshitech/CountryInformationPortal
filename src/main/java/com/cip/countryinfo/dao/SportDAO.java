package com.cip.countryinfo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.Countries;
import com.cip.countryinfo.model.Sports;
import com.cip.countryinfo.model.User;

public class SportDAO {

	public static void addSportName(String sportsName) {
		Session session = HibernateUtil.openSession();
		Sports sport = new Sports();
		try {
			sport.setSportsName(sportsName);
			session.beginTransaction();
			session.save(sport);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Object getsportsList() {
		Session session = HibernateUtil.openSession();
		List<String> sportsList = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Sports.class);
			criteria.setProjection(Projections.property("sportsName"));
			sportsList = criteria.list();
			session.getTransaction().commit();
			return sportsList;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return sportsList;

	}

}
