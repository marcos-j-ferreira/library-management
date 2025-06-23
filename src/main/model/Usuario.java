package model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Usuario {
    private String nome;
    private int matricula;
    private List<String> livrosEmprestados = new ArrayList<>();
    private Map<String, String> data = new HashMap<>();

    public Usuario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void emprestarLivro(String titulo) {
        data.put(titulo, "22/06/2025");
        livrosEmprestados.add(titulo);
    }

    public boolean devolverLivro(String titulo) {
        data.remove(titulo);
        return livrosEmprestados.remove(titulo);
    }

    public List<String> getLivrosEmprestados() {
        return new ArrayList<>(livrosEmprestados); 
    }

    public Map<String, String> getDatasEmprestimo(){
        return new HashMap<>(data);
    }
}
