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
        Cliente c1 = new Cliente(1, "Pedro", "Rua Unicamp TT 001", "19 99716-4571", "9201039", "pedro@unicamp.br");
        Cliente c2 = new Cliente(2, "Henrique");
        
        Animal a1 = new Animal(1, "Totó", 4, 0);
        Animal a2 = new Animal(2, "Tota", 2, 1);
        
        c1.addAnimal(a1);
        
        c1.setNome("Pedro_2");
        
        System.out.println("Nome: " + c1.getNome());
        System.out.println("Nome: " + c2.getNome());
        System.out.println(c1);
    }
}
