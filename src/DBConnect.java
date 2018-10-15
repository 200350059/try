import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Blob;
import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

public class DBConnect {
    private static String user = "root";
    private static String password = "w*6A+pJD";


    public static ObservableList<TV> getAllTV() throws SQLException {
        ObservableList<TV> tvs = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://35.232.16.97:3306/tv?useSSL=false",
                    user, password);

            //2.  create a statement object
            statement = conn.createStatement();

            //3.  create the SQL query
            resultSet = statement.executeQuery("SELECT * FROM tv");

            //4.  loop over the results from the DB and add to ArrayList
            while (resultSet.next())
            {
                TV newTV = new TV(
                        resultSet.getString("brand"),
                        resultSet.getInt("size"),
                        resultSet.getInt("price"));
                     //   com.mysql.jdbc.("image"));

                tvs.add(newTV);
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn != null)
                conn.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        return tvs;
    }

    public static ObservableList<TV> searchName(String name) throws SQLException {
        ObservableList<TV> tvs = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://35.232.16.97:3306/tv?useSSL=false",
                    user, password);

            //2.  create a statement object
          //  statement = conn.createStatement();

            //3.  create the SQL query
          //  resultSet = statement.executeQuery("SELECT * FROM tv WHERE brand  like ");
            statement =conn.prepareStatement("SELECT * from tv WHERE  brand = ?");
            ((PreparedStatement) statement).setString(1, name);
         //   resultSet = statement;

            //4.  loop over the results from the DB and add to ArrayList
            while (resultSet.next())
            {
                TV newTV = new TV(
                        resultSet.getString("brand"),
                        resultSet.getInt("size"),
                        resultSet.getInt("price"));
                //   com.mysql.jdbc.("image"));

                tvs.add(newTV);
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn != null)
                conn.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        return tvs;
    }
}
