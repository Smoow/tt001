/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.Animal;
import model.Cliente;
import model.Veterinario;
import view.GenericTableModel;

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
}
