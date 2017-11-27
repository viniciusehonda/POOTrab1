package fatec.poo.control;

import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author honda
 */
public class DaoCliente {
    
    private Connection conn;
    
    public DaoCliente(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("Insert into tbCliente("
                    + "Cpf_Cli, Nome_Cli, End_Cli, Cid_Cli, Uf_Cli, Ddd_Cli, "
                    + "Tel_Cli, Cep_Cli, LimCred_Cli, LimDisp_Cli) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            ps.setString(8, cliente.getCep());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());
            
            ps.execute();
                    
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE tbCliente set Nome_Cli = ?, End_Cli = ?, "
                    + "Cid_Cli = ?, Uf_Cli = ?, Ddd_Cli = ?, "
                    + "Tel_Cli = ?, Cep_Cli = ?, LimCred_Cli = ?, LimDisp_Cli = ?"
                    + "where Cpf_Cli = ? ");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getUf());
            ps.setString(5, cliente.getDdd());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCep());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            
            ps.setString(10, cliente.getCpf());
            
                    
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    public Cliente consultar (String Cpf) {
        Cliente cl = null;
        
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbCliente where Cpf_Cli = ?");
            
            ps.setString(1, Cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                cl = new Cliente(Cpf, rs.getString("Nome_Cli"), rs.getDouble("LimCred_Cli"));
            
            }
        } 
            catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return (cl);
    }
    
    public void excluir (Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE from tbCliente where Cpf_Cli = ?");
            
            ps.setString(1, cliente.getCpf());
            ps.execute();
                    
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
