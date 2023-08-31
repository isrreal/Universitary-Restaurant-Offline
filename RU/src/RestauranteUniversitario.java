class RestauranteUniversitario {
    private Empresa empresa;
    protected final Cardapio[] cardapio = Cardapio.values();
    protected final float precoDoCredito = 1.10f;
    public RestauranteUniversitario() {}
    public RestauranteUniversitario(Empresa empresa) { this.empresa = empresa; }
    public Empresa getEmpresa() { return this.empresa; }
    public String getCardapio() {
        StringBuilder aux = new StringBuilder();
        for (Cardapio c : cardapio)
            aux.append(c.name() + ":\n\n " + c.getValues() + "\n\n");
        return aux.toString();
    }
    public float getPrecoDoCredito() { return this.precoDoCredito; }
}