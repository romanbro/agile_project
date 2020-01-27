/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agileproject;

import java.sql.*;
import java.util.Properties;

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
        Database db = null;
        try {
            db = new Database();
            dbConnection = db.getConnection();
        }
        catch (ClassNotFoundException e) {
            System.out.println("MariaDB JDBC driver NOT detected in library path.");
            System.exit(1);
        }
        catch (SQLException e){
            System.out.println("Failed to create connection to database");
            System.exit(1);
        }
        
        if(dbConnection != null) {
            String substring = "headache"; //would be user entered
            searchBySubstring(substring);
        }

    }
  
    
    public static void searchBySubstring(String substring) throws Exception{
        substring = substring.toUpperCase();
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery("SELECT DISTINCT 'DRG Definition' "
                    + "FROM 'database' "
                    + "WHERE 'DRG Definition' LIKE '%" + substring + "%'");
            while (results.next())
            {
                String outputString = String.format(results.getString(1));
                System.out.println(outputString);
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
