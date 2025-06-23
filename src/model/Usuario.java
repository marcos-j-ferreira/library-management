package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int matricula;
    private List<String> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void emprestarLivro(String titulo) {
        livrosEmprestados.add(titulo);
    }

    public boolean devolverLivro(String titulo) {
        return livrosEmprestados.remove(titulo);
    }

    public List<String> getLivrosEmprestados() {
        return new ArrayList<>(livrosEmprestados); 
    }
}
