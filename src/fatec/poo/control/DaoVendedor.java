package fatec.poo.control;

import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author honda
 */
public class DaoVendedor {
    
    private Connection conn;
    
    public DaoVendedor(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT into tbVendedor("
                    + "Cpf_Vend, Nome_Vend, End_Vend, Cid_Vend, Uf_Vend, Cep_Vend, "
                    + "Ddd_Vend, Tel_Vend, SalBase_Vend, TaxaCom_Vend) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getTelefone());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getCep());
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getComissao());
            
            ps.execute();
                    
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE tbVendedor set Nome_Vend = ?, "
                    + "End_Vend = ?, Cid_Vend = ?, Uf_Vend = ?, Cep_Vend = ?, "
                    + "Ddd_Vend = ?, Tel_Vend = ?, SalBase_Vend = ?, TaxaCom_Vend = ?"
                    + "where Cpf_Vend = ?");
            
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getUf());
            ps.setString(5, vendedor.getDdd());
            ps.setString(6, vendedor.getTelefone());
            ps.setString(7, vendedor.getCep());
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getComissao());
            
            ps.setString(10, vendedor.getCpf());
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Vendedor consultar (String Cpf) {
        Vendedor vd = null;
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * from tbVendedor where Cpf_Vend = ? ");
            
            ps.setString(1, Cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                vd = new Vendedor(Cpf, rs.getString("Nome_Vend"), rs.getDouble("SalBase_Vend"));
            }
            
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        return (vd);
    }
    
    public void excluir (Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE from tbVendedor where Cpf_Vend = ?");
            
            ps.setString(1, vendedor.getCpf());
            ps.execute();
            
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
