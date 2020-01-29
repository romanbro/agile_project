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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Database db = new Database();
        dbConnection = db.getConnection();
        
        if(dbConnection != null) {
            Scanner input = new Scanner(System.in);
            System.out.println("SQL Query: ");
            String search = input.nextLine();
            
            
            
//            searchBySubstrings(splitSearchIntoKeywords(search));
            printResultsList(resultSetToList(runSQLQuery(search)));
        }

    }
  
    
    //runs a given SQL query on the database
    public static ResultSet runSQLQuery(String query){
        ResultSet results = null;
        try {
            Statement statement = dbConnection.createStatement();
            results = statement.executeQuery(query);
        }
        catch (SQLException e)
        {
            System.out.println("Encountered an error when executing given sql statement");
        }        
        return results;
    }
    
    
    //converts the ResultSet object into a linked list filled with String arrays that represent rows
    public static LinkedList<String[]> resultSetToList(ResultSet results) throws SQLException{
        ResultSetMetaData resultsMeta = results.getMetaData();
        int columnNumber = resultsMeta.getColumnCount();
        
        LinkedList<String[]> resultsList = new LinkedList<String[]>();
        
        //gets an array of headings and adds it to the linked list
        String[] headings = new String[columnNumber];
        for(int i = 0; i < columnNumber; i++){
            headings[i] = resultsMeta.getColumnName(i + 1);
        }
        resultsList.add(headings);
        
        //turns each row of the resultset into a string array and then adds it to the linked list
        while (results.next()) {
            String[] row = new String[columnNumber];
            for(int i = 0; i < columnNumber; i++){
                row[i] = String.format(results.getString(i + 1));              
            }
            resultsList.add(row);
        }
        
        return resultsList;
    }
    
    //prints the results
    public static void printResultsList(LinkedList<String[]> resultsList){
        
        for(String[] array: resultsList){
            for(String element: array){
                System.out.printf(element + "\t");
            }
            System.out.println("");
        }
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
    
    
    public static String[] splitSearchIntoKeywords(String search){
        String[] keywords = search.split(" ");
        
        
        return keywords;
    }
    
}

//DATABASE CODE https://docs.microsoft.com/en-us/azure/mysql/connect-java
