
package whatsapp;
import java.util.ArrayList;

public class Grupo {
    private String nome;
    ArrayList<User>users = new ArrayList<>();
    ArrayList<String>mensagensGrupo = new ArrayList<>();

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public Grupo( String nome,  User usuario){
        this.nome = nome;
        users.add(usuario);
    }
}
