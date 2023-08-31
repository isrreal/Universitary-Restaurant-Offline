public class FuncionarioInexistente extends RuntimeException {
    public FuncionarioInexistente() {
        super("Erro, o funcionario pesquisado não existe");
    }
}
