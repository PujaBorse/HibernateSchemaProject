package com.fujitsu.booking.main;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fujitsu.beans.booking.Booking;

public class HibernateBookingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// create configuration
				Configuration cfg = new  Configuration();

				// read hibernate properties from hibernate.cfg.xml
				Configuration c=cfg.configure();

				// obtain session factory through configuration 

				SessionFactory factory=c.buildSessionFactory();

				// get session from session factory 
				//represent database connection
				Session session = factory.openSession();

				// get transaction through session
				Transaction tx = session.beginTransaction();
				
				
				
				
				Booking bk = new Booking();
				//bk.setBookingdate(Date.valueOf(LocalDate.of(2019, 12, 14)));
				bk.setCheckInDate(Date.valueOf(LocalDate.of(2019, 12, 14)));
				bk.setCheckOutDate(Date.valueOf(LocalDate.of(2019, 12, 14)));
				bk.setNoOfAdults(2);
				bk.setNoOfChildren(2);
				bk.setNumberOfRooms(2);
				bk.setCheckInTime("10:20");
				bk.setCheckOutTime("12:20");
				
				
				session.save(bk);
				
				
				// commit transaction 
				
				tx.commit();

				//	close session: close database connection
				session.close();
		
	}

}
