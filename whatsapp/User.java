
package whatsapp;
import java.util.ArrayList;

public class User {
    private String nome;
    ArrayList <Grupo> grupos = new ArrayList<>();
    ArrayList<String>mensagensUser = new ArrayList<>();
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
  public User(String nome){
      this.nome = nome;
  }
  
}
