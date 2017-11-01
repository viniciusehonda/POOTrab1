package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author honda
 */
public class Cliente extends Pessoa{
    private double limiteCred;
    private double limiteDisp;
    
    private ArrayList<Pedido> pedidos;

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        limiteDisp = limiteCred;
    }
    
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
        pedido.setCliente(this);
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }
}
