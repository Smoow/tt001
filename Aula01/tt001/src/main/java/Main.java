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
        Cliente c1 = new Cliente("Pedro", "Rua Unicamp TT 001", "19 99716-4571", "9201039", "pedro@unicamp.br");
        Cliente c2 = new Cliente("Henrique", "Rua Unichamps TT 001", "19 99623-5100", "15902032", "henrique@unicamp.br");
        
        Animal a1 = new Animal("Ted", 4, 0);
        Animal a2 = new Animal("Tota", 2, 1);
        
        c1.addAnimal(a1);
        c2.addAnimal(a2);
        
        c1.setNome("Pedro_2");
        
        System.out.println(c1);
        System.out.println(c2);
    }
}
