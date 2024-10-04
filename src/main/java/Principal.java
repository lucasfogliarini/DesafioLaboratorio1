import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome da loja: ");
                String nomeLoja = scanner.nextLine();

                System.out.print("Quantidade de funcionários: ");
                int qtdFuncionarios = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Salário base dos funcionários (digite -1 se não souber): ");
                double salarioBase = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Data de fundação (dia/mes/ano): ");
                String[] dataFundacaoStr = scanner.nextLine().split("/");
                Data dataFundacao = new Data(Integer.parseInt(dataFundacaoStr[0]),
                        Integer.parseInt(dataFundacaoStr[1]),
                        Integer.parseInt(dataFundacaoStr[2]));

                System.out.print("Endereço (rua, cidade, estado, país, cep, número, complemento): ");
                String nomeRua = scanner.nextLine();
                String cidade = scanner.nextLine();
                String estado = scanner.nextLine();
                String pais = scanner.nextLine();
                String cep = scanner.nextLine();
                String numero = scanner.nextLine();
                String complemento = scanner.nextLine();
                Endereco endereco = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

                loja = new Loja(nomeLoja, qtdFuncionarios, salarioBase, endereco, dataFundacao);
                System.out.println("Loja criada com sucesso!");

            } else if (opcao == 2) {
                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.nextLine();

                System.out.print("Preço do produto: ");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Data de validade (dia/mes/ano): ");
                String[] dataValidadeStr = scanner.nextLine().split("/");
                Data dataValidade = new Data(Integer.parseInt(dataValidadeStr[0]),
                        Integer.parseInt(dataValidadeStr[1]),
                        Integer.parseInt(dataValidadeStr[2]));

                produto = new Produto(nomeProduto, precoProduto, dataValidade);
                System.out.println("Produto criado com sucesso!");

            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        if (produto != null) {
            Data dataReferencia = new Data(20, 10, 2023);
            if (produto.estaVencido(dataReferencia)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }
        }

        if (loja != null) {
            System.out.println(loja);
        }

        scanner.close();
    }
}
