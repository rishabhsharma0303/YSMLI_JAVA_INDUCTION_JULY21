package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Save {

	public static void main(String[] args) throws ParseException {


		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = fmt.parse("09/11/1976");

		

		Customer customer = new Customer("ekta", "delhi", "4545454545", "ekta@r.com", date1);
		Customer customer2 = new Customer("amit", "delhi", "4545454545", "amit@r.com", date1);
		Customer customer3 = new Customer("gunika", "delhi", "4545454545", "gunika@r.com", date1);
		Customer customer4 = new Customer("keshav", "delhi", "4545454545", "keshav@r.com", date1);

		

	}
}
