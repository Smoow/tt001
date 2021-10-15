package model;


import static model.DAO.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Pedro Henrique Carreto Morais
*/
public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        return (instance == null ? (instance = new ConsultaDAO()) : instance);
    }

// CRUD    
    public Consulta create(Date data, int hora, String comentarios, int idAnimal, int idVet, int idTratamento, boolean terminou) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        String maskData = dateFormat.format(data);
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data, horario, comentario, id_animal, id_vet, id_tratamento, terminado) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, maskData);
            stmt.setInt(2, hora);
            stmt.setString(3, comentarios);
            stmt.setInt(4, idAnimal);
            stmt.setInt(5, idVet);
            stmt.setInt(6, idTratamento);
            stmt.setBoolean(7, terminou);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","id"));
    }
    
    private Consulta buildObject(ResultSet rs) throws ParseException {
        Consulta consulta = null;
        try {
            String maskData = rs.getString("data");
            Date data = new SimpleDateFormat("yyyy-mm-dd").parse(maskData);
            consulta = new Consulta(rs.getInt("id"), data, rs.getInt("horario"), rs.getString("comentario"), rs.getInt("id_animal"), rs.getInt("id_vet"), rs.getInt("id_tratamento"), rs.getBoolean("terminado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    // Generic Retriever
    public List retrieve(String query) throws ParseException {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    // RetrieveAll
    public List retrieveAll() throws ParseException {
        return this.retrieve("SELECT * FROM consulta");
    }
    
    // RetrieveLast
    public List retrieveLast() throws ParseException{
        return this.retrieve("SELECT * FROM consulta WHERE id = " + lastId("consulta","id"));
    }

    // RetrieveById
    public Consulta retrieveById(int id) throws ParseException {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarComment(String comentario) throws ParseException {
        return this.retrieve("SELECT * FROM consulta WHERE comentario LIKE '%" + comentario + "%'");
    }    
        
    // Update
    public void update(Consulta consulta) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        
            String maskData = dateFormat.format(consulta.getData());
            
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data=?, horario=?, comentario=?, id_animal=?, id_vet=?, id_tratamento=?, terminado=?  WHERE id=?");
            stmt.setString(1, maskData);
            stmt.setInt(2, consulta.getHora());
            stmt.setString(3, consulta.getComentarios());
            stmt.setInt(4, consulta.getIdAnimal());
            stmt.setInt(5, consulta.getIdVet());
            stmt.setInt(6, consulta.getIdTratamento());
            stmt.setBoolean(7, consulta.isTerminou());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
        // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

