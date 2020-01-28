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
            System.out.println("Search: ");
            String substring = input.nextLine();
            searchBySubstring(substring);
        }

    }
  
    
    public static void searchBySubstring(String substring) throws Exception{
        substring = substring.toUpperCase();
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery("SELECT DISTINCT drg_definition "
                    + "FROM medicare "
                    + "WHERE drg_definition LIKE '%" + substring + "%'");
            
            int counter = 1;
            while (results.next()) {
                String definition = String.format(results.getString(1));
                System.out.println(valueOf(counter) + ')' + " " + definition);
                counter++;
                
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement", e);
        }		
    }
    
}

/*
sql statement:
SELECT DISTINCT "DRG Definition", FROM "database"
WHERE "DRG Definition" LIKE "%userSearch%"

like statement searches for the substring "userSearch" in the field

then the user selects one of the results which runs 

*/

//DATABASE CODE https://docs.microsoft.com/en-us/azure/mysql/connect-java
