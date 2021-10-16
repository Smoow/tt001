
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Smoow
 */
public class Main {
    public static void main(String[] args) {
         ArrayList<Cliente> clientes = new ArrayList<>();
        
        //Cliente c1 = new Cliente(1, "Pedro", "Rua Unicamp TT 001", "19 99716-4571", "9201039", "pedro@unicamp.br");
        //Cliente c2 = new Cliente(2, "Henrique", "Rua Unichamps TT 001", "19 99623-5100", "15902032", "henrique@unicamp.br");
        //Cliente c3 = new Cliente(3, "Vinicius", "Rua YYYXZ TT 001", "14 99183-9102", "15902032", "vinicius@unicamp.br");
        
        ClienteDAO.getInstance().create("Pedro","Rua Unicamp TT 001","19997164571","9201039","pedro@unicamp.br");
        ClienteDAO.getInstance().create("Henrique","Rua Unicamp TT 001","17993772019","9281730","henrique@unicamp.br");
        ClienteDAO.getInstance().create("Vinicius","Rua YYYXZ TT 001","14991839102","2819313","vinicius@unicamp.br");
        
        
        Animal a1 = new Animal("Ted", 4, 0);
        Animal a2 = new Animal("Tota", 2, 1);
        Animal a3 = new Animal("Toto", 12, 0);
        Animal a4 = new Animal(" ", 6, 1);
        
        //c1.addAnimal(a1);
        //c2.addAnimal(a2);
        //c2.addAnimal(a3);
        
        //c1.setNome("Pedro_2");
        
        //clientes.add(c1);
        //clientes.add(c2);
        //clientes.add(c3);
        
        
    }
}
