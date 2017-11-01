package fatec.poo.model;

/**
 *
 * @author honda
 */
public class ItemPedido {
    private int numeroItem;
    private int qtdeVendida;
    private Produto produto;
    private Pedido pedido;
    
    
    public ItemPedido(int numeroItem, int qtdeVendida) {
        this.numeroItem = numeroItem;
        this.qtdeVendida = qtdeVendida;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public int getNumeroItem() {
        return numeroItem;
    }
    
    public void setProduto(Produto p) {
       produto = p;
       produto.setQtdeDisponivel(produto.getQtdeDisponivel() - this.qtdeVendida);  //TRATAR ISSO NO APLIC
    }
    
    public double getValorTotal() {
        return produto.getPrecoUnit() * this.qtdeVendida;
    }   
    
    public void setPedido(Pedido p) {
        pedido = p;
    }
}
