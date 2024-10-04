import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Loja loja = null;
        Produto produto = null;

        while (true) {
            int opcao = GerarMenu();

            if (opcao == 1) {
                loja = CriarLoja();
            } else if (opcao == 2) {
                produto = CriarProduto();
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        if (produto != null) {
            System.out.println(produto);
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

    private static int GerarMenu(){
        System.out.println("Menu:");
        System.out.println("(1) Criar uma loja");
        System.out.println("(2) Criar um produto");
        System.out.println("(3) Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static Loja CriarLoja(){
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

        System.out.print("Informe Endereço ... \n");
        System.out.print("Rua:");
        String nomeRua = scanner.nextLine();

        System.out.print("Cidade:");
        String cidade = scanner.nextLine();

        System.out.print("Estado:");
        String estado = scanner.nextLine();

        System.out.print("Pais:");
        String pais = scanner.nextLine();

        System.out.print("CEP:");
        String cep = scanner.nextLine();

        System.out.print("Número:");
        String numero = scanner.nextLine();

        System.out.print("Complemento:");
        String complemento = scanner.nextLine();
        Endereco endereco = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        var loja = new Loja(nomeLoja, qtdFuncionarios, salarioBase, endereco, dataFundacao);
        System.out.println("Loja criada com sucesso!");
        return loja;
    }

    private  static Produto CriarProduto(){
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

        var produto = new Produto(nomeProduto, precoProduto, dataValidade);
        System.out.println("Produto criado com sucesso!");
        return produto;
    }
}
