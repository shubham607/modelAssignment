package com.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ChargesWithSuccessRide")
public class ChargesWithSuccessRide extends HttpServlet {

	public ChargesWithSuccessRide() {
		super();
	}

	public static double costOfRide(double rideDistance, String cabColor) {
		if (cabColor.equals("Pink"))
			return (2 * rideDistance) + 2;
		else
			return (2 * rideDistance);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String CabNo = request.getParameter("CabNo");
		double rideDistance = Double.parseDouble(request.getParameter("rideDistance"));
		String cabColor = request.getParameter("cabColor");
		double totalFare = costOfRide(rideDistance, cabColor);
		String destination = request.getParameter("destination"); 
		
		request.setAttribute("CabNo", CabNo);
		request.setAttribute("TotalFare", totalFare);
		request.setAttribute("Destination", destination);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessRide.jsp");
		dispatcher.forward(request, response);

	}

}
