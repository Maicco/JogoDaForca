import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Forca 
{
//Exibe o menu do jogo e retorna a opção selecionada
    public static char MenuJogo()
    {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\n============= MENU DO JOGO =============\n"
                + "Digite o número da opção:\n\n"
                + "1 - JOGAR\n"
                + "2 - SAIR\n\n"
                + "Escolha a sua opção:");
        
        return entrada.nextLine().charAt(0);
    }
    
    //Imprime a linha com o caractere '='
    public static void Linha()
    {
        int i = 0;
        
        for(i=0; i<=39; i++)
            System.out.printf("=");
        
        System.out.println("\n");
    }
    
    //Método para execução do jogo
    public static char Jogo()
    {
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        
        String[] palavras = {"caderno","celular","computador","monitor","programar","java","algoritmo","teclado","mouse","mesa"}, 
                 dica = {"Escrever","Atender","Hardware","Visualizar","Escrever","Linguagem","Lógica","Digitar","Clicar","Apoiar"};
        String palavraSorteada = palavras[random.nextInt(10)];; // Sorteia a palavra a ser acertada
        
        //erros - Contabiliza a quantidade erros cometidos | i - usada para os laços e para índices dos vetores | n - contagem das comparações com a palavra a ser adivinhada
        int erros = 0, i=0, n=0;
        char letraDigitada[] = new char[palavraSorteada.length() + 7], letra, mostrarPalavra[] = new char[palavraSorteada.length()];  
        
        DesenhoForca(erros);
        
        //Laço para preencher a palavra a ser mostrada com o caractere '_'
        for(i=0;i<palavraSorteada.length();i++)
        {
            mostrarPalavra[i] = '_';
            System.out.printf(mostrarPalavra[i]+" ");
        }
        
        while(erros < 7)
        {
            System.out.println("\n\nDigite uma letra: ");
            
            letra = entrada.nextLine().charAt(0);
            
            //Verificação de letra válida
            if((letra >= 'A' && letra <= 'Z') || (letra >= 'a' && letra <= 'z'))
            {
                //Laço para verificação das letras digitadas
                for(i=0; i < palavraSorteada.length(); i++) 
                {
                    if(letra == palavraSorteada.charAt(i))
                    {
                        mostrarPalavra[i] = letra;
                    }
                    
                    if(letra != palavraSorteada.charAt(i))
                    {
                        n++;
                    }
                }
                
                //Laço para 
                for(i=0; i < letraDigitada.length; i++)
                {
                    
                }
                
                //Condição para acrescentar o número de erros
                if(n > palavraSorteada.length()-1)
                {
                    erros++;
                    n = 0;
                }
                else
                    n = 0;
            }
            else
            {
            	System.out.println("Valor digitado incorreto! Digite uma letra.\n");
            }
            
            DesenhoForca(erros); //Desenha a forca de acordo com o número de erros
            
            //Laço para mostrar o progresso da adivinhação
            for(i=0;i<palavraSorteada.length();i++)
            {
                System.out.printf(mostrarPalavra[i]+" ");
            }
            
            System.out.println("\n erros: "+erros+ " n: " + n);//teste ******
        }
        
        if(erros >= 7)
        {
        	Linha();
        	System.out.println("\nVOCÊ PERDEU!\n");
        }
        
        return '0';
    }
    
    //Desenha a forca de acordo com os erros
    public static void DesenhoForca(int erros)
    {
        if(erros == 0)
            System.out.println("___\n" 
                            + "|  '\n" 
                            + "|");
        
        if(erros == 1)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "|  ");
        
        if(erros == 2)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "|  |");
        
        if(erros == 3)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "| /|");
        
        if(erros == 4)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "| /|\\");
        
        if(erros == 5)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "| /|\\\n" 
                            + "| /");
        
        if(erros == 6)
            System.out.println("___\n" 
                            + "|  O\n" 
                            + "| /|\\\n" 
                            + "| / \\");
        
        //System.out.println("\n");
    }
    
    public static void main(String[] args) 
    {
        char opcao = '0'; //Guarda a opção do usuário. | 0 - Perguntar, 1 - Jogar, 2 - Sair
      
        while(opcao != '2')
        {
            if(opcao == '0')
            {
                opcao = MenuJogo(); //Chama o menu de opções para verificação do início do jogo
                Linha(); //Imprime uma linha com o caractere '='
                
                if(opcao == '1')
                {
                    System.out.println("Começou!\n");
                    
                    opcao = Jogo(); //Chama o método para iniciar a execução do jogo
                }
                else
                {
                    if(opcao == '2')
                    {
                        break;
                    }
                    else //Mensagem de erro para inserção de valores inválidos no menu do jogo
                    {
                        System.out.println("Opção Inválida! Digite novamente.\n");
                        opcao = '0';
                    }
                }
            }
        }
    }    
}
