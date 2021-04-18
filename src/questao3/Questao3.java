/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

/**
 *
 * @author Mari
 */
import java.util.Scanner;

public class Questao3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s;
        String t;
        int k;
        
        Scanner leitura = new Scanner(System.in);
        
        s = leitura.next();  //leitura do s
        t = leitura.next();  // leitura do t
        k = leitura.nextInt(); //leitura do k
        
        
        //Validaçoes
        char c;
        int sValido = 0;  
        int sCaractere = 0;
        int tValido = 0;
        int tCaractere = 0;
        int kValido = 0;
        
        System.out.println("S: " + s);
        //limitação
        if(s.length() > 100){ // se o s for maior do que 100 entra no if e pede para digitar digitar novamente a palavra s
            while(sValido != 1){
                System.out.println("Digite s novamente contendo caracteres de 1 até 100 ");
                s = leitura.next();
                if(s.length() < 100){
                    sValido = 1;
                }
            }          
        } else {  // se s for menor do que 100, entra no else 
            sCaractere = 0;
            sValido = 0;
            while(sValido < 1){ //while para validar se possui somente caracteres do alfabeto de a - z e minuscula               
                sValido = 0;
                sCaractere = 0;
                for (int i = 0; i < s.length(); i++) {
                    c = s.charAt(i); // i-ésimo caractere da string 's
                    // verificando se é um caractere alfabético minusculo
                    if (((c >= 'a') && (c <= 'z'))) {
                        sCaractere++;
                    }    
                }
                if(sCaractere < s.length()){ // Para verificar se a palavra s digitada tem a mesma quantidade de caracteres da verificação do for anterior
                    System.out.println("Digite s novamente contendo letras minuscula de a até z ");
                    s = leitura.next();
                } else { //caso s tenha a mesma quantidade de caracteres da verificação entra no else e atribui SValido como 1
                    sValido = 1;                            
                }                
            }           
        } 
        //limitação t
        if( t.length() > 100){ // se o t for maior do que 100 entra no if e pede para digitar digitar novamente a palavra s
            while(tValido != 1){
                System.out.println("Digite t novamente contendo caracteres de 1 até 100 ");
                t = leitura.next();
                if(t.length() < 100){
                    tValido = 1;
                }
            }   
        } else { // se t for menor do que 100, entra no else
            tValido = 0;
            while(tValido < 1){ //while para validar se possui somente caracteres do alfabeto de a - z e minuscula
                
                tValido = 0;
                tCaractere = 0;
                for (int i = 0; i < t.length(); i++) {
                    c = t.charAt(i); // i-ésimo caractere da string 's
                    // verificando se é um caractere alfabético minusculo
                    if (((c >= 'a') && (c <= 'z'))) {
                        tCaractere++;
                    }
                        
                }
                    
                if(tCaractere < t.length()){ // Para verificar se a palavra t digitada tem a mesma quantidade de caracteres da verificação do for anterior
                    System.out.println("Digite t novamente contendo letras minuscula de a até z ");
                    t = leitura.next();
                } else {
                    tValido = 1; //caso t tenha a mesma quantidade de caracteres da verificação entra no else e atribui tValido como 1
                }
                
            }
            
            
        }
        
        //limitacao do k
        if( k < 1 || k > 100){ //se k for menor do que 1 ou maior do que 100 entra no if e executa o while
            while(kValido < 1){
                System.out.println("Digite k novamente contendo caracteres de 1 até 100 "); //exibe a mensagem
                k = leitura.nextInt(); //faz a leitura de k novamente
                if( k < 1 || k > 100){ // se k continuar sendo menor do que 1 e maior do que 100 executa novamente o while
                    
                } else { //se não entra no else e atribui kValido como 1 e vai para a proxima etapa
                    kValido = 1;
                }
            }   
        }
        System.out.println(s);
        System.out.println(t);
        System.out.println(k);
        ConcatERemove(s, t, k);
    }
    
    //função ConcatERemove
    public static void ConcatERemove(String s,String t,int k){
       
        int tamanhoT = t.length();
        String s2 = "";
        int contMovimentacoes = 0;
        
        int j = 0;
        
        if(s.equals(t)){ //quando as palavras s e t são iguais  
            System.out.println("Palavras iguais");
            s = ""; //1 movimentação
            contMovimentacoes++;  
            for(int z = 0; z < t.length(); z++){
                s2 = s2 + "" + t.charAt(j);
                contMovimentacoes++;
                j++;
            }
                  
        } else if(s.length() > tamanhoT){ //palavras diferentes e tamanho de s maior de t
            for (int i = 0; i < s.length(); i++) {

                if( i < tamanhoT){
                    if (s.charAt(i) ==  t.charAt(j)){ //enquanto os caracteres é igual, ele entra no if

                        s2 = s2 + "" + s.charAt(i);
                        contMovimentacoes = s.length() - s2.length();

                    }  else { // os caracteres são diferentes, entra no else e conta a quantidade de movimentações
                    s2 = s2 + "" + t.charAt(j);
                    contMovimentacoes++;

                    }
                }           
                j++;
            }

        } else { //quando t é maior que o s
            
            s = ""; // 1 movimentação
            contMovimentacoes++;
            for(int i = 0; i < t.length(); i++){
                s2 = s2 + "" + t.charAt(i);
                contMovimentacoes++;
            }
            
        
        }
            
            s = s2; //s recebe atribuição do s2 auxiliar que tem os valores da palavra t

            if(contMovimentacoes <= k) {
                System.out.println("sim");
            } else {
                System.out.println("não");
        }
    }
}
               