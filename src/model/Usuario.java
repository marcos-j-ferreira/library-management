package model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
        data.put(titulo, "23/06/2025");
        System.out.println(titulo);
        livrosEmprestados.add(titulo);
    }

    public boolean devolverLivro(String titulo) {
        return livrosEmprestados.remove(titulo);
    }

    public List<String> getLivrosEmprestados() {
        return new ArrayList<>(livrosEmprestados); 
    }

    public Map<String, String> getLivrosEmprestadosss(){
        return new HashMap<>(data);
    }
}
