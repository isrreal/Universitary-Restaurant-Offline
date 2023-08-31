public class FuncionarioJaExistente extends RuntimeException {
    public FuncionarioJaExistente() {
        super("Entrada inválida, funcionário já existente.");
    }
}
