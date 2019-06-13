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

import com.teamroster.models.Player;
import com.teamroster.models.Roster;
import com.teamroster.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if not trying to display or delete a specific team
		if (request.getParameter("id") == null) {
			System.out.println("We want to add a new team!");
			// deliver teamsNew form view
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/teamsNew.jsp");
			view.forward(request, response);
		} else {
			// establish session
			HttpSession session = request.getSession();

			// get the current roster out of session
			Roster currRoster = (Roster) session.getAttribute("roster");
			System.out.println("current roster " + currRoster);

			// get the team and place in request
			int teamID = Integer.parseInt(request.getParameter("id"));
			ArrayList<Team> allTeams = currRoster.getTeams();
			Team team = allTeams.get(teamID);

			if (Boolean.valueOf(request.getParameter("delete")).booleanValue() == true) {
				System.out.println("we want to delete a team");

				// delete the team
				allTeams.remove(teamID);

				// redirect the view
				response.sendRedirect("/TeamRoster/Home");
			} else {
				// place team and teamID in request
				request.setAttribute("team", team);
				request.setAttribute("teamID", teamID);

				// deliver the team view (players)
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/players.jsp");
				view.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// establish session
		HttpSession session = request.getSession();

		// get the current roster out of session
		Roster currRoster = (Roster) session.getAttribute("roster");
		System.out.println("current roster " + currRoster);

		// validate form data
		ArrayList<String> errors = new ArrayList<String>();
		if ((request.getParameter("name") == null) || (request.getParameter("name").equals(""))) {
			errors.add("Please enter the team name.");
		} else if (request.getParameter("name").length() < 2) {
			errors.add("The team name must be a minimum of 2 characters.");
		} else {
			System.out.print("Team name passed validations.");
		}

		// check if errors after validation
		if (errors.size() > 0) {
			// return to form and display errors
			session.setAttribute("errors", errors);
			response.sendRedirect(String.format("/TeamRoster/Teams"));
		} else {
			if(session.getAttribute("errors") != null) {
				// remove old errors
				session.removeAttribute("errors");
			}
			
			// process form data, create new team
			Team newTeam = new Team(request.getParameter("name"));
			System.out.println(String.format("New team name is %s", newTeam.getTeamName()));

			// add the new team to the roster
			currRoster.setTeams(newTeam);

			// save updated roster in session
			session.setAttribute("roster", currRoster);

			// redirect the view
			response.sendRedirect("/TeamRoster/Home");
		}

	}

}
