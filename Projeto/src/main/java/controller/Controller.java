/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
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
        
        // Função para filtrar algum registro através de um TextField em uma derterminada JTable
        public static void filterTableData(JTable table, JTextField textField) {
            GenericTableModel Model = (GenericTableModel) table.getModel(); 
            TableRowSorter<GenericTableModel> tr = new TableRowSorter<GenericTableModel>(Model);
            table.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
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
}
