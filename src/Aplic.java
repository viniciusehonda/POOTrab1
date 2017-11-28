
import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;


/**
 *
 * @author Felipe Liberal
 */
public class Aplic {
    public static void main(String[] args) {
        //FAZER MENU PARA ENTRADA (SE POSSÍVEL)
        //INSTANCIAR CLASSES [ATRAVÉS DO MENU] COM DADOS "LIGADOS"
        //FAZER LIGAÇÕES`ENTRE AS CLASSES (Métodos Add/Set<NomeClasse>)
        
        //Instanciação dos clientes
        Cliente cli1 = new Cliente("12345", "João Pedro", 2000);
        
        //Instanciação dos vendedores
        Vendedor vend1 = new Vendedor("123abc", "Maria João", 700);
        
        //Instanciação de produto
        Produto produto = new Produto(1, "Sabão tira manchas");
        produto.setEstoqueMin(5);
        produto.setQtdeDisponivel(5);
        produto.setPrecoUnit(6.75);
        
        //Instanciação de pedido
        Pedido pedido = new Pedido(1010, "01/11/2017");
        
        //Instanciação de itempedido
        ItemPedido itempedido = new ItemPedido(1, 2);
        itempedido.setQtdeVendida(2);
        
        System.out.println("Limite de Crédito: " + cli1.getLimiteCred());
        System.out.println("Comissao vendedor 1: " + vend1.getComissao());
        System.out.println("Código e Descrição: " + produto.getCodigo() + produto.getDescricao());
        System.out.println("Data Pagamento: " + pedido.getDataPagto());
        System.out.println("Data Emissão: " + pedido.getDataEmissaoPedido());
        //System.out.println("Valor total: " + itempedido.getValorTotal());
    }
    
}
