package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOMedailleBD {

    ConnexionMySQL laConnexion;
    Statement st;

    public JOMedailleBD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    /*
     * idPays INT,
     * nbrMedaillesOr INT,
     * nbrMedaillesArgent INT,
     * nbrMedaillesBronze INT,
     * PRIMARY KEY (idPays),
     * FOREIGN KEY (idPays) REFERENCES JOPays(idPays)
     */

    public void createJOMedailleBD(int p, int nbrOr, int nbrAr, int nbrBr) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into JOMedaille(idPays, nbrMedaillesOr, nbrMedaillesArgent, nbrMedaillesBronze) values(?,?,?,?)");
        ps.setInt(1, p);
        ps.setInt(2, nbrOr);
        ps.setInt(3, nbrAr);
        ps.setInt(4, nbrBr);
        ps.executeUpdate();
    }

    public JOMedaille readJOMedailleBD(int idPays) throws SQLException {
        Statement st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("select * from JOMedaille where idPays = " + idPays);
        if (rs.next()) {
            return new JOMedaille(rs.getInt("idPays"), rs.getInt("nbrMedaillesOr"), rs.getInt("nbrMedaillesArgent"),
                    rs.getInt("nbrMedaillesBronze"));
        } else {
            throw new SQLException("Médaille non trouvée.");
        }
    }


}
    
