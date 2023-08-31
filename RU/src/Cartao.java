class Cartao extends RestauranteUniversitario {
    private String identificador;
    private byte quantidadeDeCreditos = 0;
    private final byte quantidadeMaximaDeCreditos = 50;
    public Cartao(String identificador) {
        super();
        this.identificador = identificador;
    }

    public void addCreditos(byte quantidadeDeCreditos) {
        if (quantidadeDeCreditos < 0) 
            throw new QuantidadeDeCreditosNegativa("Erro, quantidade de créditos negativa adicionada.");
        if (this.quantidadeDeCreditos + quantidadeDeCreditos <= this.quantidadeMaximaDeCreditos
            && this.quantidadeDeCreditos >= 0) {
            this.quantidadeDeCreditos += quantidadeDeCreditos;
            System.out.println("Créditos adicionados com sucesso!");
        }
        else
            throw new QuantidadeDeCreditosMaiorQue50("Erro, quantidade de créditos maior que 50.");
    }
    public String getIdentificador() { return this.identificador; }
    public byte getQuantidadeDeCreditos() { return this.quantidadeDeCreditos; }
    public byte getQuantidadeMaximaDeCreditos() { return this.quantidadeMaximaDeCreditos; }
    public boolean usarCredito() {
        if (quantidadeDeCreditos == 0) {
            System.out.println("Não há saldo o suficiente.");
            return false;
        } 
        else {
            --this.quantidadeDeCreditos;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("Quantidade de créditos: %d", this.getQuantidadeDeCreditos());
    }
}