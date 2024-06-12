package gestionclientesgimnasio;

import java.sql.*;

public class ClienteDAO {

    private Connection conexion;
    final String URL = "jdbc:mysql://localhost:3306/gimnasio";
    final String USER = "root";
    final String PASSWORD = "";
    final String DRIVER = "com.mysql.jc.jdbc.Driver";

    public ClienteDAO() {
        this.conexion = conectar();
    }

    private Connection conectar() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Class.forName(DRIVER);
            System.out.println("Estás conectado");

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void create(Cliente cliente) {
        if (cliente != null) {
            if (read(cliente.getDni()) == null) {
                String sql = "insert into clientes values (?, ?, ?, ?)";
                try {
                    PreparedStatement smt = conexion.prepareStatement(sql);
                    smt.setString(1, cliente.getNombre());
                    smt.setString(2, cliente.getDni());
                    smt.setDate(3, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
                    smt.setString(4, cliente.getApellidos());
                    smt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                }
            } else {
                System.out.println("El cliente existe");
            }
        }
    }

    public Cliente read(String dniCliente) {
        Cliente cliente = null;
        String sql = "select * from clientes where dni = ?";

        try {
            PreparedStatement smt = conexion.prepareStatement(sql);
            smt.setString(1, dniCliente);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String apellidos = rs.getString("apellidos");
                cliente = new Cliente(nombre, dni, fechaNacimiento, apellidos);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        
        return cliente;
    }
    
    public void update(Cliente cliente) {
        if (cliente != null) {
            if (read(cliente.getDni()) != null) {
                String sql = "update clientes set dni = ?, nombre = ?, apellidos = ?, fechaNacimiento = ?";

                try {
                    PreparedStatement smt = conexion.prepareStatement(sql);
                    smt.setString(1, cliente.getDni());
                    smt.setString(2, cliente.getNombre());
                    smt.setString(3, cliente.getApellidos());
                    smt.setDate(4, java.sql.Date.valueOf(cliente.getFechaNacimiento()));

                    smt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                }
            } else {
                System.out.println("El cliente no existe");
            }
        }
    }

    public Cliente delete(String dni) {
        Cliente cliente = read(dni);

        if (cliente != null) {
            try {
                String sql = "Delete from clientes where dni = ?";
                PreparedStatement smt = conexion.prepareStatement(sql);
                smt.setString(1, dni);
                smt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error " + e.getMessage());
            }

        } else {
            System.out.println("El cliente no existe");
        }
        return cliente;
    }
}
