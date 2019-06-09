package com.pets.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.models.Cat;

/**
 * Servlet implementation class Cats
 */
@WebServlet(description = "display cats page", urlPatterns = { "/Cats" })
public class Cats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get values from params
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		Integer weight = Integer.parseInt(request.getParameter("weight"));

		// create a new cat model
		Cat newCat = new Cat(name, breed, weight);

		// set model for view
		request.setAttribute("cat", newCat);

		// deliver the view
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
