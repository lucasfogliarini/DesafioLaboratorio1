public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int capacidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[capacidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        int quantidade = 0;

        for (Loja loja : lojas) {
            if (loja != null) {
                switch (tipo) {
                    case "Cosmético":
                        if (loja instanceof Cosmetico) quantidade++;
                        break;
                    case "Vestuário":
                        if (loja instanceof Vestuario) quantidade++;
                        break;
                    case "Bijuteria":
                        if (loja instanceof Bijuteria) quantidade++;
                        break;
                    case "Alimentação":
                        if (loja instanceof Alimentacao) quantidade++;
                        break;
                    case "Informática":
                        if (loja instanceof Informatica) quantidade++;
                        break;
                    default:
                        return -1;
                }
            }
        }
        return quantidade;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                if (maisCara == null || informatica.getSeguroEletronicos() > maisCara.getSeguroEletronicos()) {
                    maisCara = informatica;
                }
            }
        }
        return maisCara;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping { nome: ").append(nome);
        sb.append(", endereco: ").append(endereco != null ? endereco.toString() : "Não informado");
        sb.append(", lojas: ");
        for (Loja loja : lojas) {
            if (loja != null) {
                sb.append(loja.toString()).append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}