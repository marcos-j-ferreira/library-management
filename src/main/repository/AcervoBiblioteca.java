package repository;

import java.util.HashMap;
import java.util.Map;
import model.Livro;

public class AcervoBiblioteca {
    private Map<Integer, Livro> livros = new HashMap<>();
    private int proximoId = 1;

    public int adicionarLivro(String titulo) {
        int id = proximoId++;
        livros.put(id, new Livro(titulo));
        return id;
    }

    public Map<Integer, Livro> getTodosLivros() {
    return new HashMap<>(livros); // Retorna uma cópia
    }

    public boolean removerLivro(int id) {
        if (livros.containsKey(id)) {
            livros.remove(id);
            return true;
        }
        return false;
    }

    public Livro getLivro(int id) {
        return livros.get(id);
    }

    public void listarLivros() {
        System.out.println("==== Acervo da Biblioteca ====");
        for (Map.Entry<Integer, Livro> entry : livros.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            System.out.println("Título: " + entry.getValue().getTitulo());
            System.out.println("Disponível: " + (entry.getValue().isDisponivel() ? "Sim" : "Não"));
            System.out.println("-----------------------------");
        }
    }
}