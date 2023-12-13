import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void inputNotas(ArrayList<Integer> notas, Scanner scanner, int m) {
        int count = 1;

        try {

            while (m > 0) {
                System.out.print("Insira a nota do aluno " + count + ", entre 1 a 1000: ");
                int pi = scanner.nextInt();

                while (pi < 0 || pi > 1001) {
                    System.out.println("Error: Valor inserido menor que 0 ou maior que 1000!");
                    System.out.print("Insira a nota do aluno " + count + ", entre 1 a 1000: ");
                    pi = scanner.nextInt();
                }

                notas.add(pi);
                count++;
                m--;
            }

        } catch (Exception e) {
            System.out.println("\n|-------------------------------------------------------------------|");
            System.out.println("| O valor inserido não é um número inteiro! Favor, reiniciar código!|");
            System.out.println("|-------------------------------------------------------------------|\n");
        }

    }

    public static int inputQtdAlunos(Scanner scanner) {
        int m;

        try {

            System.out.print("Insira a quantidade de alunos, entre 1 a 1000, na turma: ");
            m = scanner.nextInt();

            while (m < 0 || m > 1001) {
                System.out.println("Error: Valor inserido menor que 0 ou maior que 1000!");
                System.out.print("Insira a quantidade de alunos, entre 1 a 1000, na turma: ");
                m = scanner.nextInt();
            }

            return m;

        } catch (Exception e) {
            System.out.println("\n|-------------------------------------------------------------------|");
            System.out.println("| O valor inserido não é um número inteiro! Favor, reiniciar código!|");
            System.out.println("|-------------------------------------------------------------------|\n");
        }

        return 0;
    }

    public static int inputQtdTestes(Scanner scanner) {
        int n = 0;

        try {
            System.out.print("Digite a quantidade de testes que deseja realizar: ");
            n = scanner.nextInt();

            while (n <= 0) {
                System.out.println("Error: Valor inserido igual ou menor que 0!");
                System.out.print("Digite a quantidade de testes que deseja realizar: ");
                n = scanner.nextInt();
            }

        } catch (Exception e) {
            System.out.println("\n|-------------------------------------------------------------------|");
            System.out.println("| O valor inserido não é um número inteiro! Favor, reiniciar código!|");
            System.out.println("|-------------------------------------------------------------------|\n");
        }

        return n;
    }

    public static void ordenacao(ArrayList<Integer> notas) {

        for (int i = 0; i < notas.size(); i++) {
            int chave = notas.get(i);
            int j = i - 1;

            while (j >= 0 && notas.get(j) < chave) {
                notas.set(j + 1, notas.get(j));
                j--;
            }

            notas.set(j + 1, chave);

        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = inputQtdTestes(scanner);
        int teste = 1;

        while (n > 0) {
            System.out.println("Teste numero " + teste);
            ArrayList<Integer> notas = new ArrayList<>(); 
            inputNotas(notas, scanner, inputQtdAlunos(scanner));

            // criacao da copia da lista
            ArrayList<Integer> notasOrganazidas = new ArrayList<>(); 
            for (Integer integer : notas) {
                notasOrganazidas.add(integer);
            }

            ordenacao(notasOrganazidas);          

            int contador = 0;

            for (int i = 0; i < notas.size(); i++) {
                if (notas.get(i) != notasOrganazidas.get(i)) {
                    contador++;
                }

            }

            System.out.println("O numero de estudantes reorganizados na fila foi de " + contador + " alunos");
            System.out.println();

            teste++;
            n--;
        }

        scanner.close();

    }
}
