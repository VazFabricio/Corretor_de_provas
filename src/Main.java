import java.util.Scanner;

public class Main {
    private static String []  gabarito(Scanner sc) {
        String[] arrGabarito = new String[8];
        System.out.println("=======================");
        System.out.println("|--Digite o gabarito--|");
        System.out.println("|    A, B, C ou D     |");
        System.out.println("=======================");
        for (int i = 0; i < arrGabarito.length; i++) {
            System.out.println("Questão " + (i + 1) + ": ");
            arrGabarito[i] = sc.nextLine().toUpperCase();
            if (!arrGabarito[i].equals("A") && !arrGabarito[i].equals("B") && !arrGabarito[i].equals("C") && !arrGabarito[i].equals("D")) {
                System.out.println("Alternativa Inválida");
                break;
            }
        }
        return arrGabarito;
    }

    private static String[][] alunos(Scanner sc) {
        String[][] arr = new String[10][8];
        int i = 0;
        int j = 0;
        for (i = 0; i < arr.length; i++){
            System.out.println("Digite a nota do aluno nº" + (i + 1) + ": ");
            for (j = 0; j < arr[i].length; j++) {
                System.out.print("Questao " + (j + 1)+": ");
                arr[i][j] = (String) sc.nextLine().toUpperCase();
                if (!arr[i][j].equals("A") && !arr[i][j].equals("B") && !arr[i][j].equals("C") && !arr[i][j].equals("D")){
                    System.out.println("Alternativa Inválida");
                    break;
                }
            }
        }
        return arr;
    }

    private static String[][] corrigirProva (String [] gabarito, String [][] alunos){
        String [][] pontuacao = new String[10][8];
        for (int i = 0; i< alunos.length; i++){
                for (int j= 0; j<alunos[i].length; j++){
                    if (alunos[i][j].equals(gabarito[j])){
                        pontuacao[i][j] = "1";
                    }else{
                        pontuacao[i][j]="0";
                    }

                }
        }
        return pontuacao;
    }

    private static int[]pontuar(String [][] correcao){
        int [] pontos = new int[10];
        for (int i = 0; i< correcao.length; i++){
            int somatoria = 0;
            for (int j = 0; j < correcao[i].length; j++){
                if (correcao[i][j].equals("1")){
                    somatoria++;
                    pontos[i] = somatoria;
                }
            }
        }

        return pontos;
    }

    private static void aprovado (int [] pontuacao){
        for (int i = 0; i<pontuacao.length; i++){
            if (pontuacao[i] >= 6){
                System.out.println("O aluno "+ (i+1) + " foi aprovado");
            } else {
                System.out.println("O aluno "+ (i+1) + " foi reprovado");
            }
        }
    }

    private static void exibirLista (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("aluno " + (i+1)+" fez : "+arr[i]+" pontos");
            System.out.println(" ");
        }
    }
    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);
        String[] gabarito = gabarito(sc);
        System.out.println("---");
        System.out.println(" ");
        String[][] alunos = alunos(sc);
        String[][] correcao = corrigirProva(gabarito, alunos);
        int[] pontuacao = pontuar(correcao);

        exibirLista(pontuacao);
        System.out.println(" ");
        aprovado(pontuacao);
    }
}
