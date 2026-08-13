package cr.ac.ucenfotec.dl;

import java.sql.*;

public class DBAccess {

    private Connection connection;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public DBAccess(String direccion, String usuario, String contrasenia)
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(direccion, usuario, contrasenia);
    }

    public void ejecutarStatement(String pStatement) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(pStatement);
    }

    public void ejecutarStatement(String pStatement, double pValor1, int pValor2)
            throws Exception {

        preparedStatement = connection.prepareStatement(pStatement);
        preparedStatement.setDouble(1, pValor1);
        preparedStatement.setInt(2, pValor2);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String pStatement, int pValor1)
            throws Exception {

        preparedStatement = connection.prepareStatement(pStatement);
        preparedStatement.setInt(1, pValor1);
        preparedStatement.executeUpdate();
    }

    public ResultSet ejecutarQuery(String pQuery) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(pQuery);
    }

    public ResultSet ejecutarQuery(String pQuery, int pValor)
            throws SQLException {

        preparedStatement = connection.prepareStatement(pQuery);
        preparedStatement.setInt(1, pValor);
        return preparedStatement.executeQuery();
    }
}