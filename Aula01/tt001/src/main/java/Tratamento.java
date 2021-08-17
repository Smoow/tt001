
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Smoow
 */
public class Tratamento {
    private String nome;
    private Calendar data_incio;
    private Calendar data_fim;
    private int idAnimal;
    private boolean terminou;

    public Tratamento(String nome, Calendar data_incio, Calendar data_fim, int idAnimal, boolean terminou) {
        this.nome = nome;
        this.data_incio = data_incio;
        this.data_fim = data_fim;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData_incio() {
        return data_incio;
    }

    public void setData_incio(Calendar data_incio) {
        this.data_incio = data_incio;
    }

    public Calendar getData_fim() {
        return data_fim;
    }

    public void setData_fim(Calendar data_fim) {
        this.data_fim = data_fim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }
}
