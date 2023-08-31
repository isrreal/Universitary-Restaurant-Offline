class Funcionario extends Validar implements Comparable<Funcionario> {
    private String nome;
    private String CPF;
    private String funcao;
    private float salario;
    public Funcionario(String nome, String CPF, String funcao, float salario) {
        if (isNumeric(CPF) && CPF.length() == 11) {
            this.nome = nome;
            this.CPF = CPF;
            this.funcao = funcao;
            this.salario = salario;
        }
        else
            throw new CpfInvalido();
    }
    public Funcionario(String CPF) {
        if ((isNumeric(CPF) && CPF.length() == 11))
            this.CPF = CPF;
        else
            throw new CpfInvalido();
    }
    public String getNome() { return this.nome; }
    public String getCPF() { return this.CPF; }
    public String getFuncao() { return this.funcao; }
    public float getSalario() { return this.salario; }
    public float setSalario(float salario) {
        if (salario < 0)
            throw new SalarioMenorQueZero();
        return this.salario += salario;
    }

    @Override
    public String toString() {
        return String.format(" nome: %s\n - CPF: %s \n - função: %s\n - salario: %.2f\n\n",
                this.nome, this.CPF, this.funcao, this.salario);
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        return this.getNome().compareTo(funcionario.getNome());
    }
}