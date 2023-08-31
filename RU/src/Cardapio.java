enum Cardapio {
    SEGUNDA("- Arroz\n - Feijão de corda\n - Carne cozida\n - Vinagrete \n - Doce de banana \n - Banana\n"),
    TERCA("- Arroz\n - Feijão carioca\n - Carne cozida à milanesa\n - Alface\n - Tomate\n - Melão\n - Doce de goiaba\n"),
    QUARTA("- Arroz\n - Feijão de corda\n - Feijoada\n - Salada de Frutas\n - Couve-flor\n - Alface\n - Laranja\n - BIS\n"),
    QUINTA("- Arroz\n - Feijão preto\n - Frango à italiana\n - Tomate\n - Salada de Frutas\n - Melancia\n"),
    SEXTA("- Arroz\n - Feijão carioca\n - Isca de frango frito\n - Vinagrete\n - Doce de Melão\n - Banana\n");
    String dia;
    private Cardapio(String dia) { this.dia = dia; }
    public String getValues() { return this.dia; }
}