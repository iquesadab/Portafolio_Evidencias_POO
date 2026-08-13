package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.utils.Utils;

public class Connector {

    // Atributos
    private static DBAccess dbConnection = null;

    // Métodos
    public static DBAccess getConnection() throws Exception {
        String[] infoAccesoBD = Utils.getProperties();

        String direccion = infoAccesoBD[0] + "//"
                + infoAccesoBD[1] + "/"
                + infoAccesoBD[2];

        String usuario = infoAccesoBD[3];
        String contrasenia = infoAccesoBD[4];

        if(dbConnection == null) {
            dbConnection = new DBAccess(direccion, usuario, contrasenia);
        }

        return dbConnection;
    }
}
