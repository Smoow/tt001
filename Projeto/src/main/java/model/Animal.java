package model;

/**
 *
 * @author Pedro Henrique Carreto Morais
 */
public class Animal {
    private int id;
    private String nome;
    private int idade;
    private int sexo;  // 0 - macho | 1 - femea
    private int id_especie;
    private int id_cliente;

    public Animal(int id, String nome, int idade, int sexo, int id_especie, int id_cliente) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.id_especie = id_especie;
        this.id_cliente = id_cliente;
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
    
    public int getIdEspecie() {
        return id_especie;
    }
    
    public void setIdEspecie(int especie) {
        this.id_especie = especie;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", id_especie=" + id_especie + ", id_cliente=" + id_cliente + "}" + "\n";
    }
}
