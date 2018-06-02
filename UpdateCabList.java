package com.bean;

import java.io.IOException;

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
import com.bean.table.Longitude_Latitude_Pojo;

@WebServlet("/UpdateCabList")
public class UpdateCabList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateCabList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String CabNo = request.getParameter("CabNo");
		String destination = request.getParameter("destination");
		// HttpSession session = request.getSession();

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure().buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
				Cab_Pojo cab_Update = (Cab_Pojo) session.get(Cab_Pojo.class, Integer.parseInt(CabNo));
				Longitude_Latitude_Pojo longitude_Latitude = (Longitude_Latitude_Pojo) session.get(Longitude_Latitude_Pojo.class, destination);
				cab_Update.setStatus("Available");
				cab_Update.setPlace(longitude_Latitude.getPlace());
				cab_Update.setLatitude(longitude_Latitude.getLatitude());
				cab_Update.setLongitude(longitude_Latitude.getLongitude());
				
				session.update(cab_Update);
				response.sendRedirect("HomePage.jsp");

		}

		catch (NullPointerException e) {
			// out.println("<Script>alert('invalid Data')</Script>");
			request.setAttribute("Login_Erorr", " Invalid!");
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
