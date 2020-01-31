/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agileproject;

import static java.lang.String.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author romanbrodskiy
 */
public class AgileProject {
    public static Connection dbConnection = null;
    
    public static String[] sqlQueries = new String[]{
        "SELECT * FROM medicare WHERE provider_state = 'FL';",
        "SELECT drg_definition, provider_id, provider_name, total_discharges, average_total_payments FROM medicare WHERE average_total_payments < 10000;",
        "SELECT drg_definition, provider_id, provider_name, provider_street_address, provider_city, provider_state, provider_zip_code, average_total_payments FROM medicare ORDER BY average_total_payments ASC LIMIT 50;"
          
    };
    
    
    public static void main(String[] args) throws Exception {
        Database db = new Database();
        dbConnection = db.getConnection();
        
        if(dbConnection != null) {
            Scanner input = new Scanner(System.in);
            System.out.println("Saved queries:");
            System.out.println("1) Display all data from Florida");
            System.out.println("2) Display some data where the average total payment is under $10000");
            System.out.println("3) Display 50 cheapest treatments");
            System.out.println("SQL Query: ");
            String search = input.nextLine();
            search = existingSQLModifier(search);
            
//            searchBySubstrings(splitSearchIntoKeywords(search));
            printResultsList(resultSetToList(runSQLQuery(search)));
        }

    }
  
    
    //sees if the search query is a number and replaces the query with a preexisting one
    public static String existingSQLModifier(String search){
        try{
            Integer index = Integer.valueOf(search) - 1;
            System.out.println(sqlQueries[index]);
            return sqlQueries[index];
        }
        catch(NumberFormatException e){
            return search;
        }
    }
    
    
    //runs a given SQL query on the database
    public static ResultSet runSQLQuery(String query){
        ResultSet resultSet = null;
        try {
            Statement statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(query);
        }
        catch (SQLException e)
        {
            System.out.println("Encountered an error when executing given sql statement");
            System.exit(1);
        }        
        return resultSet;
    }
    
    
    //converts the ResultSet object into a linked list filled with String arrays that represent rows
    public static Data resultSetToList(ResultSet resultSet) throws SQLException{
        ResultSetMetaData resultsMeta = resultSet.getMetaData();
        int columnsNumber = resultsMeta.getColumnCount();
        
        try{
            Data results = new Data(resultSet, columnsNumber);
            return results;
        }
        catch(SQLException e){
            System.out.println("Encountered an error when executing given sql statement");
        }
        
        return null;
    }
    
    
    //prints the results
    public static void printResultsList(Data results){
        for(int i = 0; i < 50; i++){
            System.out.printf(results.get(i) + "\t");
            if((i + 1) % results.getHeadingsNumber() == 0){
                System.out.printf("\n");
            }
        }
        System.out.printf("\n");
    }
    
    
    //runs an sql query on the dataset looking for a "drg_definition" field that includes the user-given substring and then outputs the correct unique drf_definitions
    public static int searchBySubstring(String substring, int counter) throws Exception{
        substring = substring.toUpperCase();
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery("SELECT DISTINCT drg_definition "
                    + "FROM medicare "
                    + "WHERE drg_definition LIKE '%" + substring + "%'");

            while (results.next()) {
                String definition = String.format(results.getString(1));
                System.out.println(valueOf(counter) + ')' + " " + definition);
                counter++;
                
            }
            
            return counter;
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement", e);
        }	
    }
    
    
    //searches by a list of substrings
    public static void searchBySubstrings(String[] substrings) throws Exception{
        int counter = 1;
        
        
        //looks for a drg_definition with all the substrings in it
        for(String substring: substrings){
        
        
        }
        
 
        //runs the searching query for each keyword in the user's search
        for(String substring: substrings){
            counter = searchBySubstring(substring, counter);
        }
	
    }
    
    
    //splits the search term into words
    public static String[] splitSearchIntoKeywords(String search){
        String[] keywords = search.split(" ");
        
        
        return keywords;
    }
}

//DATABASE CODE https://docs.microsoft.com/en-us/azure/mysql/connect-java
