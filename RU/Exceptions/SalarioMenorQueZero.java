public final class SalarioMenorQueZero extends RuntimeException {
    public SalarioMenorQueZero() {
        super("Não é possível diminuir o salãrio do funcionário");
    }
}
