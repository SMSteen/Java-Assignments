package com.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamroster.models.Roster;
import com.teamroster.models.Team;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// establish session
		HttpSession session = request.getSession();

		// store the roster in session
		if(session.getAttribute("roster") == null) {
			// create a new roster
			Roster roster = new Roster();
			session.setAttribute("roster", roster);
		}

		Roster currRoster = (Roster) session.getAttribute("roster");
		System.out.println("current roster " + currRoster);
		System.out.println(currRoster.getTeams());
		ArrayList<Team> teams = currRoster.getTeams();

		request.setAttribute("teams", teams);
		System.out.println(request.getAttribute("teams"));
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
