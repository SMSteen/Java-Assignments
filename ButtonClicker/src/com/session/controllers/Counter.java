package com.session.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Servlet implementation class Counter
 */
@WebServlet(description = "display home page", urlPatterns = { "/Counter" })
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if (request.getParameter("button") != null)
	// {
	// System.out.println("button clicked");
	// }
	// // establish session
	// HttpSession session = request.getSession();
	// int counter = 0;
	// session.setAttribute("numClicks", counter);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// establish session
		HttpSession session = request.getSession();

		// add counter to session
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		} else {
			if (request.getParameter("reset") != null) {
				session.setAttribute("counter", 0);
			}
		}

		System.out.println(session.getAttribute("counter"));

		// deliver the view
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// establish session
		HttpSession session = request.getSession();

		// increment counter if button clicked
		if (request.getParameter("button") != null) {
			System.out.println("button clicked");
			// increment the counter
			int counter = (int) session.getAttribute("counter");
			System.out.println("current count" + counter);
			counter++;
			System.out.println("new count" + counter);
			// reset the counter in session
			session.setAttribute("counter", counter);
		}

		// deliver the view
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

}
