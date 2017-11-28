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

    public void setNome(String nome) {
        super.setNome(nome);
    }
    
    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
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

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }
    
    
}
