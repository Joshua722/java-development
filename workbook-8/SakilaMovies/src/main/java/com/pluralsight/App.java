package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static PreparedStatement pStmt = null;
    static Connection conn = null;
    static BasicDataSource dataSource = new BasicDataSource();
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("****");

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Last name of an actor you like? ");
            String userLast = myScanner.nextLine().trim();

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM actor WHERE Last_Name = ?")) {

                pStmt.setString(1, userLast);

                try (ResultSet rs = pStmt.executeQuery()) {
                    if (rs.next()) {
                        validInput = true;
                        do {
                            System.out.println("Actor ID: " + rs.getInt("actor_id"));
                            System.out.println("First Name: " + rs.getString("first_name"));
                            System.out.println("Last Name: " + rs.getString("last_name"));
                            System.out.println("---------------------------------------------------");
                        } while (rs.next());

                        System.out.println("Please choose first and last name of the actor you would like to see the movies of.");
                        String userActor = myScanner.nextLine().trim();
                        String[] actorSplit = userActor.split(" ");
                        try (PreparedStatement pStmt2 = conn.prepareStatement("SELECT f.Title,f.description FROM film f INNER JOIN Film_Actor fa ON fa.film_id = f.film_id " +
                                "INNER JOIN actor a ON a.actor_id = fa.actor_id WHERE a.first_name = ? AND a.last_name = ?")) {
                            pStmt2.setString(1, actorSplit[0]);
                            pStmt2.setString(2, actorSplit[1]);
                            try (ResultSet rs2 = pStmt2.executeQuery()) {
                                if (!rs2.next()) {
                                    System.out.println("No movies found for actor: " + userActor);
                                } else {
                                    while (rs2.next()) {
                                        System.out.println("Title: " + rs2.getString("Title"));
                                        System.out.println("Description: " + rs2.getString("description"));
                                        System.out.println("---------------------------------------------------");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No actors found with the last name: " + userLast);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}