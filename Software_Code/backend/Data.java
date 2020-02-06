
package agileproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author romanbrodskiy
 */
public class Data {
    private static String[] headings = null;
    private static LinkedList<String> data;
    
    public Data(ResultSet resultSet, int columnsNumber) throws SQLException {
        headings = new String[columnsNumber];
        data = new LinkedList<String>();
        while (resultSet.next()) {
            for(int i = 0; i < columnsNumber; i++){
                
                
                data.add(String.format(resultSet.getString(i + 1)));            
            }
        }
    }
    
    public static String get(int indexX, int indexY){
        return data.get(indexX * headings.length + indexY);
    }
    
    public static String get(int index){
        return data.get(index);
    }
    
    public static int getHeadingsNumber(){
        return headings.length;
    }
}
