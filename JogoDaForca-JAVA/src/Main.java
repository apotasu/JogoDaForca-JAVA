import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scn = new  Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scn.nextLine();

        char[] PalavraEscondida = new char[palavra.length()];

        System.out.println(palavra);

        esconder(palavra, PalavraEscondida);
        descobrir(palavra, PalavraEscondida);

        System.out.println("");
        scn.close();

    }
    public static void esconder (String palavra, char[] PalavraEscondida){

        for (int i = 0; i<palavra.length(); i++){
            PalavraEscondida[i] = '_';
            System.out.print(PalavraEscondida[i]);
        }

    }

    public static void descobrir (String palavra, char[] PalavraEscondida){
        Scanner scn = new Scanner(System.in);
        boolean escolha = true;
        ArrayList <String> tentativas = new ArrayList<String>();
        int tamanho = 0;
            do {
                System.out.print("\n" + "Digite uma letra: ");
                char letra = scn.next().charAt(0);
                boolean tentativa = false;
                for (int i = 0; i < palavra.length(); i++) {
                    if (letra == palavra.charAt(i)) {
                        PalavraEscondida[i] = letra;
                        tentativa = true;
                        tamanho++;
                    }
                    System.out.print(PalavraEscondida[i]);
                }
                if (tamanho == palavra.length()){
                    System.out.println("\n"+"Voce venceu!");
                    break;
                }

                if (!tentativa) {
                    tentativas.add(String.valueOf(letra));
                }
                System.out.println("");
                System.out.println("Restam " + (6 - tentativas.size()) + " tentativas");
                System.out.println("Letras já tentadas: ");

                for (int i = 0; i < tentativas.size(); i++) {
                    System.out.print(tentativas.get(i)+" ");

                }

                if (tentativas.size() == 6) {
                    System.out.println("\n"+"Fim de jogo");
                    System.out.println("A palavra correta era " +palavra);
                    break;
                }

                System.out.println("\n" + "Escolha uma opção:");
                System.out.println("1 = de novo / 2 = sair");
                if (scn.nextInt() == 2) {
                    escolha = false;
                }

            } while (escolha);
        scn.close();

    }

}
