package com.game.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.models.Game;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int min = 1; // initialize random number range minimum
	private int max = 100; // initialize random number range maximum
	private int numTries = 0; // initialize number of times user has attempted
	private int numChances = (int) Math.round(((this.max - this.min) + 1) * 0.10); // initialize number of chances user
																					// gets

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// establish session
		HttpSession session = request.getSession();

		// place min, max & number of chances in session
		session.setAttribute("min", this.min);
		session.setAttribute("max", this.max);
		session.setAttribute("chances", this.numChances);

		// place random number in session
		if (session.getAttribute("randNum") == null) {
			// create a new game (i.e. number)
			Game game = new Game(this.max, this.min);
			session.setAttribute("randNum", game.getNumber());
		}

		// place number of allowed attempts in session
		if (session.getAttribute("chances") == null) {
			// figure out number of attempts (10% of range)
			this.numChances = (int) Math.round(((this.max - this.min) + 1) * 0.10);
			session.setAttribute("chances", this.numChances);
		}

		System.out.println(String.format("in doGet, the random number is %d", session.getAttribute("randNum")));
		System.out.println(String.format("in doGet, the number of chances is %d", session.getAttribute("chances")));

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

		// get the current session
		HttpSession session = request.getSession(true);

		// check if we're resetting the game
		if (request.getParameter("playagain") != null) {
			System.out.println("we want to reset the game");

			// delete the existing session
			session.removeAttribute("randNum");
			session.removeAttribute("guess");
			session.removeAttribute("result");
			session.removeAttribute("numTries");
			session.removeAttribute("chances");

			// reset numTries & numChances for next game
			this.numTries = 0;
			this.numChances = (int) Math.round(((this.max - this.min) + 1) * 0.10);
		}

		// check if we're using custom range
		else if (request.getParameter("customRange") != null) {
			System.out.println("we want to use a custom range");
			System.out.println("requested min is " + request.getParameter("min"));
			System.out.println("requested max is " + request.getParameter("max"));

			// set the min & max range
			this.min = Integer.parseInt(request.getParameter("min"));
			this.max = Integer.parseInt(request.getParameter("max"));

			// delete the existing session
			session.removeAttribute("randNum");
			session.removeAttribute("guess");
			session.removeAttribute("result");
			session.removeAttribute("numTries");
			session.removeAttribute("chances");

			// reset numTries & numChances for new game with new range
			this.numTries = 0;
			this.numChances = (int) Math.round(((this.max - this.min) + 1) * 0.10);
		}

		// we're just playing the game at this point
		else {

			// increment the number of attempts and place in session
			this.numTries++;
			session.setAttribute("numTries", this.numTries);

			// get the user guess & place in session
			int guess = Integer.parseInt(request.getParameter("guess"));
			// this will add if first time or replace prior guess
			session.setAttribute("guess", guess);

			// get the random number stored in session
			int randNum = (int) session.getAttribute("randNum");

			System.out.println(String.format("user attempt # %d", session.getAttribute("numTries")));
			System.out.println(String.format("the random number saved in session is %d", randNum));
			System.out.println(String.format("the user guess saved in session is %d", guess));

			// compare & store results in session
			if (guess > randNum) {
				session.setAttribute("result", "high");
				System.out.println("user guess too " + session.getAttribute("result"));
			} else if (guess < randNum) {
				session.setAttribute("result", "low");
				System.out.println("user guess too " + session.getAttribute("result"));
			} else {
				session.setAttribute("result", "match");
				System.out.println("user guess is a " + session.getAttribute("result"));
			}

			// check if guessed correctly within number of allowed attempts
			if (session.getAttribute("result").equals("match") && this.numTries <= this.numChances) {
				// User won! Put the final result in session
				System.out.println("winner winner chicken dinner");
				session.setAttribute("result", "win");
			} else {
				if (this.numTries == this.numChances) {
					// User lost. Put the final result in session
					System.out.println("too bad, so sad, you lose!");
					session.setAttribute("result", "lose");
				}
			}

		}

		// redirect the view
		response.sendRedirect("/GreatNumberGame/Home");
	}

}
