package etapa1;
import java.time.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! Definindo data padrão: 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dataValida(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (dataValida(this.dia, mes, this.ano)) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido.");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (dataValida(this.dia, this.mes, ano)) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido.");
        }
    }

    public boolean verificaAnoBissexto() {
        return Year.of(this.ano).isLeap();
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }


    private boolean dataValida(int dia, int mes, int ano) {
        try {
            LocalDateTime.of(ano, mes, dia, 0, 0);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
