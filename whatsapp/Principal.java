
package whatsapp;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Principal {
static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
             Controller c = new Controller(); 
     String help = "--------------------------------------------------------------\n"  +
                    "==Lista de comandos==\n"+
                    "Os parametros dos comandos devem ser separados por espaço\n"+
                    "cadastrar (digite o nome do usuario)\n"+
                    "mostrarUsuarios(mostra todos os usuarios cadastrados)\n"+
                    "criar grupo(Diite o nome do usuario e o nome do grupo)\n"+
                    "mostrar grupos(mostra todos os grupos criados)\n"+
                    "adicionar ao grupo(digite o nome do usuario, nome de quem deseja adicionar e o grupo/)\n"+
                    "mostrar usuarios grupo(digite o nome do grupo)\n"+
                    "enviar(digite o nome do usuario,grupo e a mensagem)\n"+
                    "ler(digite o nome do usuario e o grupo)\n"+
                    "sair (digite o nome)\n"+
                    "-------------------------------------------------------------";
     
     
     while (true){
         
         System.out.print("digite help, para lista de comandos!\n"+"Digite um comando: ");
         String comando = input.nextLine();
         if (comando.equals("help")){
             System.out.println(help);
         }else{
             
             String s[] = comando.split(" ");
             switch(s[0]){
                 case "cadastrar":
                      c.addUser(s[1]);
                     break;
                 case "mostrarusuarios":
                     c.showUsers();
                     break;
                 case "criargrupo":
                     c.addGrupo(s[1], s[2]);
                     break;
                 case "mostrargrupos":
                     c.showGrupos(s[1]);
                     break;
                 case "adicionaraogrupo":
                     c.addUserGrupo(s[1], s[2], s[3]);
                     break;
                 case "usuariosdogrupo":
                     c.showGUsers(s[1]);
                     break;
                 case "sair":
                     c.sair(s[1], s[2]);
                     break;
                 case "enviar":
                     String m ="";
                     for(int i = 3;i < s.length; i++){
                         m+= s[i];
                     }
                     c.enviarMensagem(s[1], s[2], m);
                     break;
                 case "ler":
                     try{
                     c.lerMensagem(s[1], s[2]);
                     }catch(ConcurrentModificationException exception){
                         System.out.println("nao consegui fazer");
                     }
                     break;
                 default:
                     System.out.println("Comando inválido!");
                     break;
                 
             }
             
         }
     }
        
        
        /*Controller c = new Controller();
        c.addUser("bio");
        c.addUser("robson");
        c.addUser("robson");
        c.addUser("ladrão");
        c.addUser("ladrão");
        System.out.println(c.users.get(0).getNome());
        c.showUsers(); 
        c.addGrupo("bio", "os caba");
        //System.out.println(c.users.get(0).grupos.get(0).getNome());
        c.showGrupos("bio");
        c.addUserGrupo("bio","ladrão","os caba");
        c.showGrupos("ladrão");
        c.showGUsers("os caba");
        c.sair("bio", "os caba");
        c.showGrupos("bio");
        c.addUser("jonjon");
        c.addUser("dibraldinho");
        c.addUser("jonjon");
        c.showUsers();
        c .addGrupo( "jonjon",  "aqueles bicho");
        c.addGrupo( "dibraldinho",  "os profissional");
        c.addGrupo( "bio","os profissional");*/
    }
    
}
