package JDBC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseManager {
    
    private static String BDuser = null;
    private static String BDpassword = null;
    private static String BDurl = null;
    private static String PathToConfigFile = "/user/5/khennicb/Base_de_donnees/Projet_SGBD/BdD/bd.conf";
    
    public static void main(String[] args) {
        
        System.out.println(getBDurl() + " / " + getBDuser() + " / " + getBDpassword());
    }

    public static String getBDuser() {
        if (BDuser == null) {
            try {
                readConfig();
            } catch (IOException ex) {
                System.err.println("Failed to read db.conf");
                ex.printStackTrace();
            }
        }
        return BDuser;
    }

    public static String getBDpassword() {
        if (BDpassword == null) {
            try {
                readConfig();
            } catch (IOException ex) {
                System.err.println("Failed to read db.conf");
                ex.printStackTrace();
            }
        }
        return BDpassword;
    }

    public static String getBDurl() {
        if (BDurl == null) {
            try {
                readConfig();
            } catch (IOException ex) {
                System.err.println("Failed to read db.conf");
                ex.printStackTrace();
            }
        }
        return BDurl;
    }
    
    
    /*
    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        try {
            Properties connectionProps = readConfig();

        conn = DriverManager.getConnection(
                   "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1" ,
                   connectionProps);
        System.out.println("Connected to database");
        } catch (FileNotFoundException e) {
            System.err.println("No \"db.conf\" file found.");
        } catch (IOException e) {
            System.err.println("Weird IO exception.");
            e.printStackTrace();
        }
        return conn;
    }
    */
    
    /*
     * We expect a file with :   propertie "value"
     * url, login, password are expected (in that order !)
     *
     */
    public static void readConfig() throws FileNotFoundException, IOException{
        char config[] = new char[500];
        FileReader r = new FileReader(PathToConfigFile);

        r.read(config);
        String str[] = new String(config).split("\"");

        BDurl = str[1];
        BDuser = str[3];
        BDpassword = str[5];
        
        r.close();
    }

    
    
    
}
