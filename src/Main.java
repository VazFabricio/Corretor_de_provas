import java.util.Scanner;
public class Main {
    private static void gabarito (Scanner sc){
        String []arr = new String[8];
        System.out.println("=======================");
        System.out.println("|--Digite o gabarito--|");
        System.out.println("|    A, B, C ou D     |");
        System.out.println("=======================");
        for (int i = 0; i < arr.length; i++){
            System.out.println("Questão "+(i+1)+": ");
            arr[i] = sc.nextLine().toUpperCase();
            if (!arr[i].equals("A") && !arr[i].equals("B") && !arr[i].equals("C") && !arr[i].equals("D")){
                System.out.println("Alternativa Inválida");
                break;
            }
        }
    }
    private static String[][] alunos (Scanner sc) {
        String[][] arr = new String[10][8];
        int i = 0;
        int j=0;
        for (i = 0; i< arr.length; i++) {
            System.out.println("Digite a nota do aluno nº"+ (i+1) +": ");

            for (j = 0; j < arr[i].length; j++){
            arr[i][j] = (String) sc.nextLine();
            }
        }


        System.out.println("Sigite o gabarito desse aluno->");
        System.out.println("Questao " + i);
        return arr;
    }
    private static void exibirLista (String [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        gabarito(sc);
        System.out.println("---");
        System.out.println(" ");
        exibirLista(alunos(sc));

    }
}