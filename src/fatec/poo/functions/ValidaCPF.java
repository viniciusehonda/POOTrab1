package fatec.poo.functions;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.InputMismatchException;

/**
 *
 * @author honda
 */
public class ValidaCPF {
    
    public static boolean isCPF(String CPF) {
            if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
        CPF.equals("22222222222") || CPF.equals("33333333333") ||
        CPF.equals("44444444444") || CPF.equals("55555555555") ||
        CPF.equals("66666666666") || CPF.equals("77777777777") ||
        CPF.equals("88888888888") || CPF.equals("99999999999") ||
       (CPF.length() != 11))
       return(false);
            
            char d10, d11;
            int sm = 0, i, r, num, peso;
            
            
            try {
                peso = 10;
                
                for(i = 0; i < 9;i++) {
                    num = (int)(CPF.charAt(i) - 48);
                    sm = sm + (num * peso);
                   
                    peso = peso -1;
                }
                
                r = 11 - (sm % 11);
                if((r == 10) || (r == 11)) {
                    d10 = '0';
                } else {
                    d10 = (char)(r + 48);
                }
                
                sm = 0;
                peso = 11;
                for(i=0; i<10; i++) {
                  num = (int)(CPF.charAt(i) - 48);
                  sm = sm + (num * peso);
                  peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                   d11 = '0';
                else d11 = (char)(r + 48);
                
                 if ((d10 == CPF.charAt(9)) && (d11 == CPF.charAt(10)))
                    return(true);
                 else return(false);
               } catch (InputMismatchException erro) {
                   return(false);
    }
    }
}
