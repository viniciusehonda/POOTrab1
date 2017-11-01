package fatec.poo.model;

/**
 *
 * @author honda
 */
public class ItemPedido {
    int numeroItem;
    int qtdeVendida;
    private Produto produto;
    
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
       produto.qtdeDisponivel = produto.getQtdeDisponivel() - this.qtdeVendida;
    }
    
    public double getValorTotal() {
        return produto.precoUnit * this.qtdeVendida;
    }   
    
}
