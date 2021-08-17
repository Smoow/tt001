
import java.util.concurrent.atomic.AtomicInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Smoow
 */
public class Animal {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private final int id;
    private String nome;
    private int idade;
    private int sexo;  // 0 - macho | 1 - femea

    public Animal(String nome, int idade, int sexo) {
        id = count.incrementAndGet();
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

   public int getId() {
       return id;
   }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + '}';
    }
    
    
}
