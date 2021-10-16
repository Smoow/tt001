/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.Especie;
import model.EspecieDAO;

/**
 *
 * @author Smoow
 */
public class EspeciesTableModel extends GenericTableModel {
    public EspeciesTableModel(List vDados) {
        super(vDados, new String[]{"ID", "Nome"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Especie especie  = (Especie) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return especie.getId();
            case 1:
                return especie.getNome();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
                    
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Especie especie = (Especie) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                especie.setId((Integer) aValue);
                break;
            case 1:
                especie.setNome((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        EspecieDAO.getInstance().update(especie);
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
