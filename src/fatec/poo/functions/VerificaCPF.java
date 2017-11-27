package fatec.poo.functions;

/**
 *
 * @author Giovane Haddad
 */
public class VerificaCPF {
    private String cpf;
    
    public VerificaCPF(String CPF){
        cpf = CPF;
    }
    
    public boolean validar(){         
        if(
           cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||           
           cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
           cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
           cpf.equals("99999999999") || cpf.length() != 11){
            return false;
        }
                  
        return primeiroDigito(cpf) && segundoDigito(cpf);
    }
    
    public boolean primeiroDigito(String cpf){
        int soma=0;
        
        try {
           for(int i=0; i<9; i++){
            soma += Integer.parseInt(cpf.substring(i, i+1)) * i+1;
            }
            soma %= 11;
            if(soma == 10)
                soma = 0;  
        } catch (Exception e) {
            soma = 11;
        }  
        return soma == Integer.parseInt(cpf.substring(9,10));
    }
    
    public boolean segundoDigito(String cpf){
        int soma=0;
        
        try {
            for(int i=0, j=11; j>=2; i++, j--)
                soma += Integer.parseInt(cpf.substring(i,i+1)) * j;
            soma = (soma * 10) % 11;
            if(soma == 10)
                soma = 0;
        } catch (Exception e) {
            soma = 11;
        }        
        return soma == Integer.parseInt(cpf.substring(10));
    }
}
