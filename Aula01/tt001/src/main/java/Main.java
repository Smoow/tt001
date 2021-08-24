
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
        
        Cliente c1 = new Cliente("Pedro", "Rua Unicamp TT 001", "19 99716-4571", "9201039", "pedro@unicamp.br");
        Cliente c2 = new Cliente("Henrique", "Rua Unichamps TT 001", "19 99623-5100", "15902032", "henrique@unicamp.br");
        Cliente c3 = new Cliente("Marcos", "Rua XXXYZ TT 001", "13 9281-5460", "15902032", "marcos@unicamp.br");
        Cliente c4 = new Cliente("Vinicius", "Rua YYYXZ TT 001", "14 99183-9102", "15902032", "vinicius@unicamp.br");
        Cliente c5 = new Cliente("Bruno", "Rua ZZZXY TT 001", "15 9978-7728", "15902032", "bruno@unicamp.br");
        
        Animal a1 = new Animal("Ted", 4, 0);
        Animal a2 = new Animal("Tota", 2, 1);
        Animal a3 = new Animal("Toto", 12, 0);
        Animal a4 = new Animal(" ", 6, 1);
        
        c1.addAnimal(a1);
        c2.addAnimal(a2);
        c2.addAnimal(a3);
        
        c1.setNome("Pedro_2");
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);
        
         for (var i=0; i < clientes.size(); i++) {
             System.out.println(clientes.get(i));
             System.out.println("");
         }
    }
}
