import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {
    static Connection con;
    public static Connection createc() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "Raghu@620";
            String url = "jdbc:mysql://localhost:3306/project_One";
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
