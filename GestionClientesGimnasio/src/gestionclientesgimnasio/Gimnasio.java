package gestionclientesgimnasio;
import java.sql.Date;

public class Gimnasio {

    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente=new Cliente("nayara","113","2005-09-05","diaz leon");
        ClienteDAO dao=new ClienteDAO();
        dao.create(cliente);
    }

}
