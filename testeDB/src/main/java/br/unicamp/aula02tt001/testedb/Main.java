
import java.util.List;

/**
 *
 * @author vilela
 */
public class Main {
    public static void main(String[] args) {        
        Cliente c1 = new Cliente(1,"Plinio","Rua dos Bobos","70707070","00234-900","prvilela@unicamp.br");

//        ClienteDAO.getInstance().create("Pedro","Rua dos Menos Bobos","20201920","13441-210","pedro@unicamp.br");
        
        Animal a1 = new Animal(1,"Toto",2,0);
        Animal a2 = new Animal(2,"Mimi",3,1);
        
        
        c1.addAnimal(a1);
        c1.addAnimal(a2);
        
        System.out.println(ClienteDAO.getInstance().retrieveAll());
        
        /*
        List<Animal> listaExterna = c1.getAnimais();
        Animal a3 = new Animal(3,"    ",5,0);
        listaExterna.add(a3);
        
        System.out.println(c1);
        
        System.out.println(listaExterna);
        */
    }
}
