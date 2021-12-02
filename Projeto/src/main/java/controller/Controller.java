/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Especie;
import model.EspecieDAO;
import model.Veterinario;
import model.VeterinarioDAO;
import view.AnimalTableModel;
import view.ClienteTableModel;
import view.EspeciesTableModel;
import view.GenericTableModel;
import view.VeterinarioTableModel;

/**
 *
 * @author Pedro Henrique Carreto Morais  - RA: 186379 - UNICAMP (TT001)
 */
public class Controller {
        private static Cliente clienteSelecionado = null;
        private static Animal animalSelecionado = null;
        private static Veterinario veterinarioSelecionado = null;
        private static JTextField clienteSelecionadoTextField = null;
        private static JTextField animalSelecionadoTextField = null;
        private static JTextField veterinarioSelecionadoTextField = null;
        
        public static void setTextFields(JTextField cliente, JTextField animal) {
            clienteSelecionadoTextField = cliente;
            animalSelecionadoTextField = animal;
        }
        
        public static void setTextFieldVeterinario(JTextField veterinario) {
            veterinarioSelecionadoTextField = veterinario;
        }
    
        public static void setTableModel(JTable table, GenericTableModel tableModel) {
                table.setModel(tableModel);
        }
        
        public static Cliente getClienteSelecionado() {
            return clienteSelecionado;
        }
        
        public static Animal getAnimalSelecionado() {
            return animalSelecionado;
        }
        
        public static Veterinario getVeterinarioSelecionado() {
            return veterinarioSelecionado;
        }
        
        public static void setSelected(Object selected) {
            if (selected instanceof Cliente) {
                clienteSelecionado = (Cliente) selected;
                clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
                animalSelecionadoTextField.setText("");
            } else if (selected instanceof Animal) {
                animalSelecionado = (Animal) selected;
                animalSelecionadoTextField.setText(animalSelecionado.getNome());
            } else if (selected instanceof Veterinario) {
                veterinarioSelecionado = (Veterinario) selected;
                veterinarioSelecionadoTextField.setText(veterinarioSelecionado.getNome());
            }
        }
        
        // Retrieve all clientes
        public static List getAllClients() {
            return ClienteDAO.getInstance().retrieveAll();
        }
        
        // Retrieve all especies
        public static List getAllSpecies() {
            return EspecieDAO.getInstance().retrieveAll();
        }
        
        // Retrieve all veterinarios
        public static List getAllVets() {
            return VeterinarioDAO.getInstance().retrieveAll();
        }
        
        // Função para dar retrieve all nos clientes quando o Radio Button dele estiver selecionado
        public static void jRadioButtonClientesSelecionado(JTable table) {
            setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        }
        
        // Função para dar retrieve all nos animais de um cliente quando o Radio Button dele estiver selecionado
        public static boolean jRadioButtonAnimaisSelecionado(JTable table) {
            if (getClienteSelecionado() != null) {
                setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByClientId(Controller.getClienteSelecionado().getId())));
                return true;
            } else {
                setTableModel(table, new AnimalTableModel(new ArrayList()));
                return false;
            }
        }
        
        // Função para dar retrieve all nas espécies quando o Radio Button dele estiver selecionado
        public static void jRadioButtonEspeciesSelecionado(JTable table) {
            setTableModel(table, new EspeciesTableModel(EspecieDAO.getInstance().retrieveAll()));
        }
        
        // Função para dar retrieve all nos veterinários quando o Radio Button dele estiver selecionado
        public static void jRadioButtonVeterinariosSelecionado(JTable table) {
            setTableModel(table, new VeterinarioTableModel(VeterinarioDAO.getInstance().retrieveAll()));
        }

        // Função para o filtro de busca
        public static void atualizaTableNomeSimilar(JTable table, String nomeSimilar) {
            if (table.getModel() instanceof ClienteTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nomeSimilar));
            }
            else if (table.getModel() instanceof VeterinarioTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(nomeSimilar));
            }
            else if (table.getModel() instanceof AnimalTableModel) {
                if (getClienteSelecionado() != null) {
                    ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(getClienteSelecionado().getId(), nomeSimilar));
                }
            } 
            else if (table.getModel() instanceof EspeciesTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveBySimilarName(nomeSimilar));
            }
        }
        
        // Função que executa o comportamento do botão TODOS - remover o filtro de busca
        public static void limpaFiltroBusca(JTable table, JTextField textField) {
            if (table.getModel() instanceof ClienteTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(Controller.getAllClients());
                textField.setText("");
            }
            else if (table.getModel() instanceof AnimalTableModel) {
                if (getClienteSelecionado() != null) {
                    ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveByClientId(Controller.getClienteSelecionado().getId()));
                    textField.setText("");
                }
            }
            else if (table.getModel() instanceof EspeciesTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(Controller.getAllSpecies());
                textField.setText("");
            }
            else if (table.getModel() instanceof VeterinarioTableModel) {
                ((GenericTableModel)table.getModel()).addListOfItems(Controller.getAllVets());
                textField.setText("");
            }
        }
        
        // Função para adicionar clientes ao banco
        public static Cliente adicionaCliente(String nome, String endereco, String telefone, String cep, String email) {
            return ClienteDAO.getInstance().create(nome, endereco, telefone, cep, email);
        }
        
        // Função para cadastrar animais ao banco
        public static Animal adicionaAnimal(String nome, int idade, int sexo, int idEspecie, int idCliente) {
            return AnimalDAO.getInstance().create(nome, idade, sexo, idEspecie, idCliente);
        }
        
        // Função para adicionar veterinarios ao banco
        public static Veterinario adicionaVeterinario(String nome, String endereco, String email, String telefone) {
            return VeterinarioDAO.getInstance().create(nome, endereco, email, telefone);
        }
        
        // Função para adicionar especieis ao banco
        public static Especie adicionaEspecie(String nome) {
            return EspecieDAO.getInstance().create(nome);
        }
        
        // Função genérica para o funcionamento do botão NOVO (das entidades)
        public static void adicionarEntidade(JTable table) {
            if (table.getModel() instanceof ClienteTableModel) {
                ((GenericTableModel)table.getModel()).addItem(Controller.adicionaCliente("", "", "", "", ""));
            }
            /* Algum bug por aqui... 
            else if (table.getModel() instanceof AnimalTableModel) {
                if (getClienteSelecionado() != null) {
                    ((GenericTableModel)table.getModel()).addItem(Controller.adicionaAnimal("", 0, 1, 0, getClienteSelecionado().getId()));
                }
            }
            */
            else if (table.getModel() instanceof EspeciesTableModel) {
                ((GenericTableModel)table.getModel()).addItem(Controller.adicionaEspecie(""));
            }
            else if (table.getModel() instanceof VeterinarioTableModel) {
                ((GenericTableModel)table.getModel()).addItem(Controller.adicionaVeterinario("", "", "", ""));
            }
        }
}
