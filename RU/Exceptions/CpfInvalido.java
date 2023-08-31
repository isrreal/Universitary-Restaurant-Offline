public class CpfInvalido extends RuntimeException {
    public CpfInvalido() {
        super("erro, entrada de CPF inválida");
    }
}
