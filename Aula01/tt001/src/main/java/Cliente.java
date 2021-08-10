
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Smoow
 **/
public class Cliente {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private final int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String email;
    
    private List<Animal> animais;

    public Cliente(String nome, String endereco, String telefone, String cep, String email) {
        id = count.incrementAndGet(); 
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        this.animais = new ArrayList<>();
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.equals("")) {
            this.email = email;
        }
    }
    
    public void addAnimal(Animal animal) {
        animais.add(animal);
    }

    public List<Animal> getAnimais() {
        return animais;
    }
    

    @Override
    public String toString() {
        String desc =  "Cliente{id="+ id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cep=" + cep + ", email=" + email + '}';
        String strAnimal = animais.toString();
        return desc + '\n' + strAnimal;
        
        
    }
}
