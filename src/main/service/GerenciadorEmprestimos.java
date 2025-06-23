package service;

import model.Livro;
import model.Usuario;
import repository.AcervoBiblioteca;

public class GerenciadorEmprestimos {
    private AcervoBiblioteca acervo;
    
    public GerenciadorEmprestimos(AcervoBiblioteca acervo) {
        this.acervo = acervo;
    }

    public boolean emprestarLivro(Usuario usuario, int livroId) {
        Livro livro = acervo.getLivro(livroId);
        if (livro != null && livro.isDisponivel()) {
            livro.setDisponivel(false);
            usuario.emprestarLivro(livro.getTitulo());
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Usuario usuario, int livroId) {
        Livro livro = acervo.getLivro(livroId);
        if (livro != null && !livro.isDisponivel() && 
            usuario.getLivrosEmprestados().contains(livro.getTitulo())) {
            livro.setDisponivel(true);
            usuario.devolverLivro(livro.getTitulo());
            return true;
        }
        return false;
    }
}