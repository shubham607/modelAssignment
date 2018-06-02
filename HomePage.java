
package com.bean;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.bean.table.Cab_Pojo;
import com.bean.table.Location_Pojo;
import com.bean.table.Longitude_Latitude_Pojo;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static List data;

	public HomePage() {
		super();

	}

	public static double routeDistance(Cab_Pojo c, int longitude, int latitude) {
		int x = c.getLongitude() - longitude;
		int y = c.getLatitude() - latitude;
		return  Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static double totalRideDistance(Entry<Double, Cab_Pojo> minDistance) {
		if (minDistance.getValue().getCabColor().equals("Pink"))
			return (2 * minDistance.getKey()) + 2;
		else
			return (2 * minDistance.getKey());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();

		String currentLocation = request.getParameter("currentLocation");
		String destinationLocation = request.getParameter("destinationLocation");
		String color = request.getParameter("color");
		// HttpSession session = request.getSession();

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure().buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			
			 /* Location_Pojo loc1 = new Location_Pojo("Udupi Garden(BTM)","BTM", 2, 2); 
			  Location_Pojo loc2 = new Location_Pojo("Chai Point(BTM)", "BTM", 3, 1);
			  Location_Pojo loc3 = new Location_Pojo("Wine Shop(BTM)", "BTM", 3, 2); 
			  Location_Pojo loc4= new Location_Pojo("Beer Cafe(Kormangala)", "Kormangala", 10,10); 
			  Location_Pojo loc5 = new Location_Pojo("Sherlock(Kormangala)", "Kormangala", 11, 10);
			  
			  Cab_Pojo cab1 = new Cab_Pojo(1,"2123456789", "BMW", "Pink","BTM", "Available", 1, 1);
			  Cab_Pojo cab2 = new Cab_Pojo(2,"7349085737", "Ferrari", "Pink", "BTM", "Available", 2, 3);
			  Cab_Pojo cab3 = new Cab_Pojo(3,"9872654321", "Audi", "Green","BTM", "Available", 5, 7);
			  Cab_Pojo cab4 = new Cab_Pojo(4,"7343285737", "Lambo", "Pink", "Kormangala", "Available", 10, 11);
			  Cab_Pojo cab5 = new Cab_Pojo(5,"1987654321", "RollysRoyce", "Green","Kormangala", "Available", 11, 12);
			  
			  Longitude_Latitude_Pojo long_lat1 = new Longitude_Latitude_Pojo("Udupi Garden(BTM)","BTM", 2, 2); 
			  Longitude_Latitude_Pojo long_lat2 = new Longitude_Latitude_Pojo("Chai Point(BTM)", "BTM", 3, 1);
			  Longitude_Latitude_Pojo long_lat3 = new Longitude_Latitude_Pojo("Wine Shop(BTM)", "BTM", 3, 2); 
			  Longitude_Latitude_Pojo long_lat4	= new Longitude_Latitude_Pojo("Beer Cafe(Kormangala)", "Kormangala", 10,10); 
			  Longitude_Latitude_Pojo long_lat5 = new Longitude_Latitude_Pojo("Sherlock(Kormangala)", "Kormangala", 11, 10);
			  
			  session.persist(loc1);
			  session.persist(loc2); 
			  session.persist(loc3);
			  session.persist(loc4);
			  session.persist(loc5);
			  session.persist(cab1); 
			  session.persist(cab2);
			  session.persist(cab3);
			  session.persist(cab4);
			  session.persist(cab5);
			  session.persist(long_lat1); 
			  session.persist(long_lat2);
			  session.persist(long_lat3);
			  session.persist(long_lat4);
			  session.persist(long_lat5);*/
			  
			if (currentLocation.equals("SelectOne") || destinationLocation.equals("SelectOne")) {
				request.setAttribute("ErrorMessage", "Select Location!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
				dispatcher.forward(request, response);
			}

			else if (color.equals("SelectOne")) {
				request.setAttribute("ErrorMessage", "select cab color!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
				dispatcher.forward(request, response);
			} else if (currentLocation.equals(destinationLocation)) {
				request.setAttribute("ErrorMessage", "Select Correct Location!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
				dispatcher.forward(request, response);
			}else {

				Location_Pojo loc_P = (Location_Pojo) session.get(Location_Pojo.class, currentLocation);
				Location_Pojo loc_P1 = (Location_Pojo) session.get(Location_Pojo.class, destinationLocation);
				ArrayList<Cab_Pojo> pinkCabList = new ArrayList<Cab_Pojo>();
				ArrayList<Cab_Pojo> normalCabList = new ArrayList<Cab_Pojo>();
				ArrayList<Cab_Pojo> cabList = new ArrayList<Cab_Pojo>();
				HashMap<Double, Cab_Pojo> disMap = new HashMap<Double, Cab_Pojo>();

				List data = session.createQuery("from Cab_Pojo ").list();

				Iterator i = data.iterator();

				while (i.hasNext()) {
					Object o = (Object) i.next();
					Cab_Pojo c = (Cab_Pojo) o;

					if (c.getPlace().equals(loc_P.getPlace()) && c.getCabColor().equals("Pink")
							&& c.getStatus().equals("Available")) {
						pinkCabList.add(c);
					} else if (c.getPlace().equals(loc_P.getPlace()) && c.getStatus().equals("Available")) {
						normalCabList.add(c);
					}
				}
				if(color.equals("Pink"))
					cabList = pinkCabList;
				else
					cabList = normalCabList;
				
				if (cabList.isEmpty()) {
					request.setAttribute("ErrorMessage", "No cabs Available!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
					dispatcher.forward(request, response);
				} else {
					Iterator i1;
					if (color.equals("Pink"))
						i1 = pinkCabList.iterator();
					else
						i1 = normalCabList.iterator();
						while (i1.hasNext()) {
							Cab_Pojo c = (Cab_Pojo) i1.next();
							double cabDistance = routeDistance(c, loc_P.getLongitude(), loc_P.getLatitude());
							disMap.put(cabDistance, c);
						}
						Entry<Double, Cab_Pojo> minDistance = Collections.min(disMap.entrySet(),
								new Comparator<Entry<Double, Cab_Pojo>>() {
									public int compare(Entry<Double, Cab_Pojo> entry1, Entry<Double, Cab_Pojo> entry2) {
										return entry1.getKey().compareTo(entry2.getKey());
									}
								});
						double rideDistance = routeDistance(minDistance.getValue(), loc_P1.getLongitude(),loc_P1.getLatitude());
						request.setAttribute("CabDriverNo", minDistance.getValue().getDriverNo());
						request.setAttribute("CabNo", minDistance.getValue().getCabNo());
						request.setAttribute("CabColor", minDistance.getValue().getCabColor());
						request.setAttribute("CabModel", minDistance.getValue().getCabModel());
						request.setAttribute("Destination", destinationLocation);
						request.setAttribute("CabStatus", "Assigned");

						DecimalFormat df = new DecimalFormat("0.00");
						request.setAttribute("rideDistance", df.format(rideDistance));
						Cab_Pojo cab_Update = (Cab_Pojo) session.get(Cab_Pojo.class, minDistance.getValue().getCabNo());
						cab_Update.setStatus("Assigned");
						session.update(cab_Update);

						RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCabDetails.jsp");
						dispatcher.forward(request, response);

				}
			}
		}

		catch (NullPointerException e) {
			request.setAttribute("ErrorMessage", "Invalid Data!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(request, response);

		}

		finally {
			t.commit();
			session.close();
			factory.close();
		}

	}

}
