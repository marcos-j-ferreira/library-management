import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Livro { 
    private String titulo;
    private boolean disponivel;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.disponivel = true; 
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

class AcervoBiblioteca {
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

class Usuario {
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

class GerenciadorEmprestimos {
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


public class BibliotecaApp {
    private AcervoBiblioteca acervo;
    private GerenciadorEmprestimos gerenciador;
    private Scanner scanner;
    
    public BibliotecaApp() {
        this.acervo = new AcervoBiblioteca();
        this.gerenciador = new GerenciadorEmprestimos(acervo);
        this.scanner = new Scanner(System.in);
        
        acervo.adicionarLivro("Dom Casmurro");
        acervo.adicionarLivro("1984");
        acervo.adicionarLivro("O Senhor dos Anéis");
    }

    public void executar() {
        System.out.println("=== SISTEMA DE BIBLIOTECA ===");
        
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite sua matrícula: ");
        int matricula = Integer.parseInt(scanner.nextLine());
        Usuario usuario = new Usuario(nomeUsuario, matricula);
        
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());
            
            switch(opcao) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    emprestarLivro(usuario);
                    break;
                case 3:
                    devolverLivro(usuario);
                    break;
                case 4:
                    verLivrosEmprestados(usuario);
                    break;
                case 5:
                    adicionarLivro();
                    break;
                case 6:
                    removerLivro();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
            
        } while(opcao != 0);
        
        scanner.close();
    }
    
    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Listar todos os livros");
        System.out.println("2 - Emprestar livro");
        System.out.println("3 - Devolver livro");
        System.out.println("4 - Ver meus livros emprestados");
        System.out.println("5 - Adicionar livro ao acervo");
        System.out.println("6 - Remover livro do acervo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void listarLivros() {
        System.out.println("\n=== LIVROS DISPONÍVEIS ===");
        acervo.listarLivros();
    }
    
    private void emprestarLivro(Usuario usuario) {
        listarLivros();
        System.out.print("\nDigite o ID do livro que deseja emprestar: ");
        int idLivro = Integer.parseInt(scanner.nextLine());
        
        if(gerenciador.emprestarLivro(usuario, idLivro)) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Não foi possível emprestar o livro. Verifique se está disponível.");
        }
    }
    
    private void devolverLivro(Usuario usuario) {
        List<String> livrosEmprestados = usuario.getLivrosEmprestados();
        if(livrosEmprestados.isEmpty()) {
            System.out.println("Você não tem livros emprestados.");
            return;
        }
        
        System.out.println("\n=== SEUS LIVROS EMPRESTADOS ===");
        for(int i = 0; i < livrosEmprestados.size(); i++) {
            System.out.println((i+1) + " - " + livrosEmprestados.get(i));
        }
        
        System.out.print("\nDigite o número do livro que deseja devolver: ");
        int escolha = Integer.parseInt(scanner.nextLine()) - 1;
        
        if(escolha >= 0 && escolha < livrosEmprestados.size()) {
            String titulo = livrosEmprestados.get(escolha);
            
            for(Map.Entry<Integer, Livro> entry : acervo.getTodosLivros().entrySet()) {
                if(entry.getValue().getTitulo().equals(titulo)) {
                    if(gerenciador.devolverLivro(usuario, entry.getKey())) {
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Erro ao devolver livro.");
                    }
                    return;
                }
            }
            System.out.println("Livro não encontrado no acervo!");
        } else {
            System.out.println("Opção inválida!");
        }
    }
    
    private void verLivrosEmprestados(Usuario usuario) {
        List<String> livros = usuario.getLivrosEmprestados();
        if(livros.isEmpty()) {
            System.out.println("Você não tem livros emprestados no momento.");
        } else {
            System.out.println("\n=== SEUS LIVROS EMPRESTADOS ===");
            for(String livro : livros) {
                System.out.println("- " + livro);
            }
        }
    }
    
    private void adicionarLivro() {
        System.out.print("\nDigite o título do novo livro: ");
        String titulo = scanner.nextLine();
        int id = acervo.adicionarLivro(titulo);
        System.out.println("Livro adicionado com sucesso! ID: " + id);
    }
    
    private void removerLivro() {
        listarLivros();
        System.out.print("\nDigite o ID do livro a ser removido: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        if(acervo.removerLivro(id)) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou não pôde ser removido.");
        }
    }

    public static void main(String[] args) {
        new BibliotecaApp().executar();
    }
}

