public class EstudanteJaExistente extends RuntimeException {
    public EstudanteJaExistente() {
        super("Entrada inválida, estudante já existente.");
    }    
}
