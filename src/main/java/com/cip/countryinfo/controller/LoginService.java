package com.cip.countryinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cip.countryinfo.dao.CityDAO;
import com.cip.countryinfo.dao.CountryDAO;
import com.cip.countryinfo.dao.LanguageDAO;
import com.cip.countryinfo.dao.SportDAO;
import com.cip.countryinfo.dao.UserDAO;
import com.cip.countryinfo.model.Cities;
import com.cip.countryinfo.model.Countries;
import com.cip.countryinfo.model.Languages;
import com.cip.countryinfo.model.Sports;

@WebServlet("/loginservice")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryName = request.getParameter("countryName");
		String cityName = request.getParameter("cityName");
		String languageName = request.getParameter("languageName");
		String sportsName = request.getParameter("sportsName");

		if (countryName != null) {
			Countries country = new Countries();
			country.setCountryName(countryName);
			CountryDAO.addCountryName(countryName);
			response.sendRedirect("addcityname.jsp");
		} else if (cityName != null) {
			Cities city = new Cities();
			city.setCityName(cityName);
			CityDAO.addCityName(cityName);
			response.sendRedirect("addlanguagename.jsp");
		} else if (languageName != null) {
			Languages language = new Languages();
			language.setLanguageName(languageName);
			LanguageDAO.addLanguageName(languageName);
			response.sendRedirect("addsportsname.jsp");
		} else if (sportsName != null) {
			Sports sport = new Sports();
			sport.setSportsName(sportsName);
			SportDAO.addSportName(sportsName);
			response.sendRedirect("addcountryinfo.jsp");
		}
	}

}