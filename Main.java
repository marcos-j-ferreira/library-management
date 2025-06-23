

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




public class Main{

    public static void main(String[] args){

        Livros l1 = new Livros("Senhor dos aneis", true);
        String nome = l1.getTitulo();

        System.out.println(nome);
    }

}
