package com.demo.example;

import java.sql.Connection;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class HelloWorld {

	public static void main(String[] args) {
		Connection connection=ConnectionFactory.getConnection();
		 DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
//         Result<Record> result = dslContext.select().from(Author).fetch();
//
//         for (Record r : result) {
//             Integer id = r.getValue(AUTHOR.ID);
//             String firstName = r.getValue(AUTHOR.FIRST_NAME);
//             String lastName = r.getValue(AUTHOR.LAST_NAME);
//
//             System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
//		
	}
}
