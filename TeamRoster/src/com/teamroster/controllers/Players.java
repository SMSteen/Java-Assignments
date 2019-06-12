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
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Boolean.valueOf(request.getParameter("delete")).booleanValue() == true) {
			System.out.println("we want to delete a player");
			// get session
			HttpSession session = request.getSession();

			// get the team id
			int teamID = Integer.parseInt(request.getParameter("teamid"));
			System.out.println("team id we're deleting player from " + teamID);

			// get the player id
			int playerID = Integer.parseInt(request.getParameter("playerid"));
			System.out.println("id of the player we're deleting is " + playerID);

			// get the current roster out of session
			Roster currRoster = (Roster) session.getAttribute("roster");
			System.out.println("current roster " + currRoster);

			// get the team
			ArrayList<Team> allTeams = currRoster.getTeams();
			Team team = allTeams.get(teamID);
			ArrayList<Player> players = team.getPlayers();

			// remove the player
			players.remove(playerID);

			// redirect the view
			response.sendRedirect(String.format("/TeamRoster/Teams?id=%d", teamID));

		} else {
			// get the team and place in request
			int teamID = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("teamID", teamID);
			System.out.println("team id we're adding player to is " + teamID);

			// deliver the new player form view
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/playersNew.jsp");
			view.forward(request, response);
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

		// get the team and place in request
		int teamID = Integer.parseInt(request.getParameter("id"));
		ArrayList<Team> allTeams = currRoster.getTeams();
		Team team = allTeams.get(teamID);
		System.out.println("team in question is " + team);

		// process form data, create new player
		Player newPlayer = new Player(request.getParameter("firstName"), request.getParameter("lastName"),
				Integer.parseInt(request.getParameter("age")));
		System.out
				.println(String.format("New player name is %s %s", newPlayer.getFirstName(), newPlayer.getLastName()));

		// add the new player to the team
		team.addPlayer(newPlayer);
		;

		// save updated roster in session
		session.setAttribute("roster", currRoster);

		// redirect the view
		response.sendRedirect(String.format("/TeamRoster/Teams?id=%d", teamID));
	}

}
