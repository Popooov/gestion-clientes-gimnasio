package gestionclientesgimnasio;

import java.sql.*;



public class ClienteDAO {
    
    
    
    
    
    
    
    /*public Cliente read(String dni){
        Cliente cliente=null;
        String sql="select * from clientes where dni=?";
        try{  
            PreparedStatement smt=con.prepareStatement(sql);
            smt.setString(1, dni);
            ResultSet rs=smt.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre");
                String dni1=rs.getString("dni");
                String fechaNacimiento =rs.getString("fechaNacimiento");
                String apellidos =rs.getString("apellidos");
                cliente=new Cliente(nombre,dni1,fechaNacimiento,apellidos);
            }
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
        return cliente;
    }*/
    
    public Cliente delete(String dni){
        Cliente cliente=read(dni);
        if (cliente!=null) {
            try {
                String sql="Delete from clientes where dni=?";
                PreparedStatement smt=con.prepareStatement(sql);
                smt.setString(1, dni);
                smt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error "+e.getMessage());
            }
            
        }else System.out.println("El cliente no existe");
        return cliente;
    }
}
