
package ConnectionDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionTest {
   private final String DRIVER = "com.mysql.jdbc.Driver";
   private final  String url = "jdbc:mysql://localhost:3306/test";
   private final  String user = "root";
   private final  String password = "31012001200";

   public Connection getConnection(){
       try {
           Class.forName(DRIVER);
           
             return DriverManager.getConnection(url, user, password);
    
       } catch (ClassNotFoundException | SQLException ex) {
        throw new RuntimeException("test", ex);
       }
     
   }
       public static void closeConnection(Connection con) {
     if (con!=null) 
           {try {
               con.close();
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
         }
   }}
             public static void closeConnection(Connection con, PreparedStatement statement) {
                 closeConnection(con);
           {try {
               
               if (statement!=null){
               statement.close();
               }
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
         }
   }}
                      public static void closeConnection(Connection con, PreparedStatement statement, ResultSet resultset) {
                 closeConnection(con,statement);
           {try {
               
               if (resultset!=null){
               resultset.close();
               }
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
         }
   }}
}