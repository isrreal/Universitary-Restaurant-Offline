import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class Validar {
    protected int buscaEstudante(ArrayList<Estudante> estudantes, Estudante estudante) {
        return Collections.binarySearch(estudantes, estudante, new Comparator<Estudante>() {
            public int compare(Estudante e1, Estudante e2) {
                return e1.getMatricula().compareTo(e2.getMatricula());
            }
        });
    }
    protected int buscaFuncionario(ArrayList<Funcionario> funcionarios, Funcionario funcionario) {
        return Collections.binarySearch(funcionarios, funcionario, new Comparator<Funcionario>() {
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getCPF().compareTo(f2.getCPF());
            }
        });
    }
    protected boolean isNumeric(String number) {
        return (number.matches("[0-9]+"))? true : false;
    }
}