package ppss.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerFactory {
  
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public static CustomerFactory getInstance()
    {
        return new CustomerFactory();
    }

    public Customer create(int id, String firstName, String lastName) {
        return new Customer(id, firstName, lastName);
    }
    
    //Insertamos un cliente en la BD
    public void insert(Customer customer) throws SQLException {
        //Los parametros de getConnection son tres: url de conexión con la BD, usuario, y password de la BD
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUNIT", "root", "ppss");
        String sql = "insert into customer (id, firstname, lastname, street, city) values ("
                   + customer.getId() + ", "
                   + "'" + customer.getFirstName() + "', "
                   + "'" + customer.getLastName() + "', "
                   + "'" + customer.getStreet() + "', "
                   + "'" + customer.getCity() + "'"
                   + ")";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        if (stmt.getUpdateCount() != 1) {
            throw new SQLException("Insert failed!");
        }
    }
    
    //Borramos un cliente de la BD
    public void delete (Customer customer) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBUNIT", "root", "ppss");
        String sql = "delete from customer where id= " 
                   + customer.getId();

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        if (stmt.getUpdateCount() != 1) {
            throw new SQLException("Delete failed!");
        }
    }
}
