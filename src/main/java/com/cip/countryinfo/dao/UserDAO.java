package com.cip.countryinfo.dao;

import org.hibernate.Session;

import com.cip.countryinfo.hibernate.util.HibernateUtil;
import com.cip.countryinfo.model.User;

public class UserDAO {
	public boolean authenticateUser(String userName, String password) {
		Session session = HibernateUtil.openSession();
		User user = new User();
		try {
			session.beginTransaction();
			user = (User) session.get(User.class, userName);
			if (user.getUserName() == null)
				return false;
			session.getTransaction().commit();
			if (userName.equals(user.getUserName()) && user.getPassword().equals(password)) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

}
