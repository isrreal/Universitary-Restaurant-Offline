import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Empresa extends Validar {
    private String nome;
    private String CNPJ;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public Empresa(String nome, String CNPJ) {
        if (isNumeric(CNPJ) && CNPJ.length() == 11) {
            this.nome = nome;
            this.CNPJ = CNPJ;
            System.out.println("Empresa adicionada com sucesso!");
        } 
        else
            throw new CnpjInvalido();
    }
    private void gerarRelatorioDeFuncionarios() {
        try {
            FileWriter escrever = new FileWriter("relatorioDeFuncinarios.txt");
            Collections.sort(funcionarios);
            if (funcionarios.isEmpty()) {
                escrever.write("Não há funcionários na empresa.");
                escrever.close();
                return;
            }
            for (Funcionario f: funcionarios) 
                escrever.write(f.toString() + "\n\n");
            escrever.close();
        } 
        catch (IOException io) {
            System.out.println("Ocorreu algum erro.");
        }
    }
    public String getNome() { return nome; }
    public String getCNPJ() { return CNPJ; }
    public void addFuncionario(Funcionario funcionario) {
        if (funcionarios.isEmpty()) {
            funcionarios.add(funcionario);
            gerarRelatorioDeFuncionarios();
            System.out.println("Funcionário adicionado com sucesso!");
        }
        else if (buscaFuncionario(this.funcionarios, funcionario) > -1)
            throw new FuncionarioJaExistente();
        else {
            funcionarios.add(funcionario);
            Collections.sort(this.funcionarios);
            gerarRelatorioDeFuncionarios();
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    public void atualizarSalarioFuncionario(String CPF, float aumento) {
        int index = buscaFuncionario(funcionarios, new Funcionario(CPF));
        if (index > -1) {
            if (aumento < 0)
                throw new SalarioMenorQueZero();
            else {
                this.funcionarios.get(index).setSalario(aumento);
                gerarRelatorioDeFuncionarios();
                System.out.println("salário atualizado com sucesso!");
            }
        }
        else
            throw new FuncionarioInexistente();
    }

    public void demitirFuncionario(String CPF) {
        int index = buscaFuncionario(funcionarios, new Funcionario(CPF));
        if (index < 0) 
            throw new FuncionarioInexistente();
        else {
            System.out.println(this.funcionarios.get(index).getNome() + " foi demitida.");
            this.funcionarios.remove(index);
            gerarRelatorioDeFuncionarios();
            System.out.println("funcionario demitido com sucesso!");
        }
    }

    public void getRelatorioFuncionarios() {
        gerarRelatorioDeFuncionarios();
        try {
            File arquivo = new File("relatorioDeFuncinarios.txt");
            Scanner leitura = new Scanner(arquivo);
            StringBuilder aux = new StringBuilder();
            while (leitura.hasNextLine())
                aux.append(leitura.nextLine());
            System.out.println(aux);
            leitura.close();
        } 
        catch (IOException e) {
            System.out.println("erro capturado");
            e.printStackTrace();
        }
    }
}