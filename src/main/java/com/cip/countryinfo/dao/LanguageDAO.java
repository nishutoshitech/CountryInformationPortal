package com.cip.countryinfo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.Languages;

public class LanguageDAO {

	public static void addLanguageName(String languageName) {
		Session session = HibernateUtil.openSession();
		Languages language = new Languages();
		try {
			language.setLanguageName(languageName);
			session.beginTransaction();
			session.save(language);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Object getLanguageList() {
		Session session = HibernateUtil.openSession();
		List<String> langaugeList = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Languages.class);
			criteria.setProjection(Projections.property("languageName"));
			langaugeList = criteria.list();
			session.getTransaction().commit();
			return langaugeList;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return langaugeList;

	}
}
