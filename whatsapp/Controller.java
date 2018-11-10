package whatsapp;

import java.util.ArrayList;

public class Controller {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<String> grupos = new ArrayList<>();

    public void addUser(String nome) {
        User usuario;
        boolean variavel = false;

        for (int i = 0; i <= this.users.size()-1; i++) {
            System.out.println("entrou");
            System.out.println(i);
            System.out.println(this.users.size());

            if (this.users.size()>0 && this.users.get(i).getNome().equals(nome)) {
                variavel = true;
            }
        }
        if (variavel) {
            System.out.println("Usuario ja existe!");
        } else {
            usuario = new User(nome);
            this.users.add(usuario);
            System.out.println("done");
        }
    }

    public void showUsers() {
        String saida = "";
        for (User u : this.users) {
            saida += u.getNome() + " ";
        }
        System.out.println(saida);
    }

    public void addGrupo(String nome, String gNome) {
        Grupo g;
        int indice = 0;
        boolean variavel = false;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getNome().equals(nome)) {
                variavel = true;
                indice = i;
            }
        }
        if (!variavel) {
            System.out.println("usuario nao existe!");
        } else if (this.grupos.contains(gNome)) {
            System.out.println("o grupo ja existe!");
        } else {
            g = new Grupo(gNome, this.users.get(indice));
            this.users.get(indice).grupos.add(g);
            this.grupos.add(gNome);
            System.out.println("done");
        }
    }

    public void showGrupos(String nome) {
        String saida = "";
        for (User u : this.users) {
            if (u.getNome().equals(nome)) {
                if (u.grupos.isEmpty()) {
                    saida += "[]";
                } else {
                    for (Grupo g : u.grupos) {
                        saida += g.getNome() + " ";
                    }
                }
                break;
            }
        }
        System.out.println(saida);
    }

    public void addUserGrupo(String nome1, String nome2, String grupo) {
        boolean variavel1 = false;
        boolean variavel2 = false;
        int indice1 = 0;
        int indice2 = 0;
        int indice3 = 0;
        for (int i = 0; i < this.users.size(); i++) {
            System.out.println("entrou1");
            if (this.users.get(i).getNome().equals(nome1)) {
                indice1 = i;
                for (int x = 0; x < this.users.get(i).grupos.size(); x++) {
                    System.out.println("entrou2");
                    System.out.println(this.users.get(i).grupos.get(x).getNome());
                    System.out.println(grupo);
                    if (this.users.get(i).grupos.get(x).getNome().equals(grupo)) {
                        System.out.println("entrou3");
                        variavel1 = true;
                        indice2 = x;
                        break;
                    }
                }
            } else if (this.users.get(i).getNome().equals(nome2)) {
                variavel2 = true;
                indice3 = i;
                break;
            }
        }
        if (variavel1 && variavel2) {
            this.users.get(indice1).grupos.get(indice2).users.add(this.users.get(indice3));
            this.users.get(indice3).grupos.add(this.users.get(indice1).grupos.get(indice2));
            System.out.println("done");
        }

    }

    public void showGUsers(String gNome) {
        String saida = "";
        boolean parar = false;
        if (this.grupos.contains(gNome)) {

            for (User u : this.users) {

                for (Grupo g : u.grupos) {
                    if (g.getNome().equals(gNome)) {
                        parar = true;
                        for (User x : g.users) {
                            saida += x.getNome() + " ";
                        }

                    }

                }
                if (parar) {
                    System.out.println("entrou");
                    break;
                }
            }
        }
        System.out.println(saida);
    }

    public void sair(String nome, String gNome) {

        boolean parar = false;
        for (User u : this.users) {
            if (u.getNome().equals(nome)) {
                for (Grupo g : u.grupos) {
                    if (g.getNome().equals(gNome)) {
                        parar = true;
                        u.grupos.remove(g);
                        g.users.remove(u);
                        System.out.println("done");
                        break;
                    }
                }
            }
            if (parar) {
                break;
            }
        }
    }
    
    public void enviarMensagem(String uNome, String gNome, String mensagem){
        boolean variavel = false;
        for(User u : this.users){
            if(u.getNome().equals(uNome)){
                for(Grupo g :u.grupos){
                    System.out.println("entrou1");
                    if(g.getNome().equals(gNome)){
                        System.out.println("entrou2");
                        variavel = true;
                        g.mensagensGrupo.add(uNome+": "+mensagem);
                        for(User x :g.users){
                            System.out.println("entrou");
                            if(!x.getNome().equals(uNome)){
                                System.out.println("entrou");
                                System.out.println(x.getNome());
                                x.mensagensUser.add(uNome+": "+mensagem);
                                System.out.println(x.mensagensUser.get(0));
                                
                            }
                            /*if(x.getNome().equals(uNome)){
                                continue;
                            }else{
                                System.out.println("entrou");
                                System.out.println(x.getNome());
                                x.mensagensUser.add(uNome+": "+mensagem);
                                
                            }*/
                        }
                        
                        System.out.println("done");    
                    break;    
                    }
                }
            if(!variavel){
                System.out.println("usuario nao esta no grupo");
            }    
            }
        if(variavel){
            break;
        }    
        }
    }
    
    public void lerMensagem (String nome, String gNome){
        String ler = "";
        boolean variavel = false;
        for(User u : this.users){
            if(u.getNome().equals(nome)){
                for(Grupo g :u.grupos){
                    if(g.getNome().equals(gNome)){
                        //variavel = true;
                        for(String s :u.mensagensUser){
                            for(String p :g.mensagensGrupo){
                                if(s.equals(p)){
                                    ler += s;
                                    u.mensagensUser.remove(s);
                                }
                            }   
                        }
                    break;    
                    }   
                }
            if(!variavel){
                System.out.println("usuario nao esta no grupo!");
            }    
            }
            if(variavel){
                break;
            }
        }
        if(ler.isEmpty()){
            ler = "[]";
            System.out.println(ler);
        }else{
            System.out.println(ler);
        }
    }

}
