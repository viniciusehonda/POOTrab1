package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author honda
 */
public class Pedido {
    private int numero;
    private String dataEmissaoPedido;
    private String dataPagto;
    private boolean status;
    
    private ArrayList<ItemPedido> itemspedido;
    
    public Pedido(int numero, String dataEmissaoPedido) {
        this.numero = numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }
    
    public void addItemPedido(ItemPedido itp) {
        itemspedido.add(itp);
        itp.setPedido(this);
        
    }
}
