class Estudante extends Validar implements Comparable<Estudante> {
    private String nome;
    private String matricula;
    private Cartao cartao;
    public Estudante(String nome, String matricula) {
        if (isNumeric(matricula) && matricula.length() == 6) {
            this.nome = nome;
            this.matricula = matricula;
            cartao = new Cartao(matricula);
        } 
        else
            System.out.println("Entrada Inválida, matrícula inválida.");
    }
    public String getMatricula() { return this.matricula; }
    public Cartao getCartao() { return this.cartao; }
    public String getNome() { return this.nome; }
    @Override
    public int compareTo(Estudante estudante) {
        return this.getNome().compareTo(estudante.getNome());
    }
    @Override
    public String toString() {
        return String.format("Nome: %s\nMatrícula: %s\nCartão: %s\n\n",
                this.nome, this.matricula, this.cartao);
    }
}