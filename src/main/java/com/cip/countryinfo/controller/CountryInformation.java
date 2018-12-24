package com.cip.countryinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cip.countryinfo.dao.CityDAO;
import com.cip.countryinfo.dao.CountryDAO;
import com.cip.countryinfo.dao.LanguageDAO;
import com.cip.countryinfo.dao.SportDAO;

public class CountryInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CountryDAO countryList = new CountryDAO();
		CityDAO cityList = new CityDAO();
		LanguageDAO languageList = new LanguageDAO();
		SportDAO sportList = new SportDAO();
		
		request.setAttribute("countryList", countryList.getCountryList());
		request.setAttribute("cityList", cityList.getCityList());
		request.setAttribute("languageList", languageList.getLanguageList());
		request.setAttribute("sportList", sportList.getsportsList());
		
		RequestDispatcher dispacher = request.getRequestDispatcher("countryinfo.jsp");
		dispacher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
