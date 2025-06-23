import java.util.HashMap;
import java.util.Map;

class Livros {

    private String titulo;
    private boolean disponivel;

    Livros(String titulo, boolean disponivel){
        this.titulo =  titulo;
        this.disponivel = disponivel;
    }

    public final String getTitulo(){
        return titulo;
    }

    public final boolean getDisponivel(){
        return disponivel;
    }

    public final void setTitulo(String value){
        titulo = value;
    }

    public final void setDisponivel( boolean value){
        disponivel = value;
    }
}

class BancoLivros {

    Map<Integer, Livros> library = new HashMap<>();

    public final boolean addLivro(String nome, boolean disponivel, int value){
        library.put(value, new Livros(nome, disponivel));
        return true;
    } 


    public final void exibir(){
        
        for (Map.Entry<Integer, Livros> entry : library.entrySet()) {
            System.out.println("---- Livro ----- ");
            System.out.println("Id: " + entry.getKey());
            System.out.println("Título: " + entry.getValue().getTitulo());
            if (entry.getValue().getDisponivel() != true){
                System.out.println("Disponivel: Não");
            }else{
                System.out.println("Disponivel: Sim");
            }
        }

    }

    public final void removerLivro(int id){
        try{
            library.remove(id);
            System.out.println("Livro removido!");

        }catch (Exception e){
            System.out.println("Erro ao remover livro: "+ e.getMessage());
        }
        
    }

    public final void estado(int id){
        boolean disponivel = library.get(id).getDisponivel();

        if( disponivel != true){
            library.get(id).setDisponivel(true);
        }else{
            library.get(id).setDisponivel(false);
        }
    }

    public final boolean disponivel(int id){
        return library.get(id).getDisponivel();
    }

}


class User {

    
}


public class Main{

    public static void main(String[] args){

        //Livros l1 = new Livros("Senhor dos aneis", true);
       // String nome = l1.getTitulo();

        //System.out.println(nome);

        BancoLivros b1 = new BancoLivros();

        boolean a = b1.addLivro("Senhor dos aneis", true, 1);
        b1.addLivro("b", true, 2);
        b1.addLivro("cs", false, 3);
        b1.addLivro("e", false, 4);


        //System.out.println(a);
        b1.exibir();
        // b1.removerLivro(4);
        b1.estado(1);
        b1.exibir();
        boolean h = b1.disponivel(4);

        System.out.println(h);
    }

}
