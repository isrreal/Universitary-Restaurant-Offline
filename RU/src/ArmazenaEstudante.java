import java.util.ArrayList;
import java.util.Collections;

class ArmazenaEstudante extends Validar {
    private ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
    public ArmazenaEstudante() {}
    public void adicionarEstudante(Estudante estudante) {
        if (buscaEstudante(estudantes, estudante) < 0)
            estudantes.add(estudante); 
        else
            throw new EstudanteJaExistente();
    }
    public ArrayList<Estudante> getEstudantes() { return this.estudantes; }
    public int getIndexEstudantePorMatricula(String matricula) {
        return buscaEstudante(estudantes, new Estudante(" ", matricula));
    }
    @Override
    public String toString() {
        if (estudantes.isEmpty())
            return "Não há estudantes";
        StringBuilder aux = new StringBuilder();
        Collections.sort(estudantes);
        for (Estudante e: this.estudantes)
            aux.append(e);
        return aux.toString();
    }
}