package riwi.filtro.persistence.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {


    public static java.sql.Connection connection = null;

    //ABRIR CONECCION CON LA DATABASE

    public static java.sql.Connection conectar(){
            //CREAMOS LAS VARIABLES NECESARIAS PARA LA CONECCION  "jdbc:mysql://host:port/nombre";

            String URL = "jdbc:mysql://bkj9qptlv7hf4g51njcj-mysql.services.clever-cloud.com:3306/bkj9qptlv7hf4g51njcj";
            String user = "u1blqmrd8gj1kh9l";
            String password = "dKicGeXBU7JMVMClxVx6";


            //NOS CONECTAMOS USANDO EL DIRVER MANAGER Y LA GUARDAMOS EN LA VARIABLE NULA
            try {
                connection = DriverManager.getConnection(URL,user,password);
                System.out.println("Coneccion exitosa");

            }catch (Exception e){
                System.out.println("No se pudo establecer la conexion con la db "+e.getMessage());
            }

            return connection;
        }

        //CERRAR CONECCION

        public static void cerrar(){

        if (connection != null){

            //INTENTAMOS CERRAR LA CONECCION
            try {
                System.out.println("cerrada");
                connection.close();
            }catch (Exception e){
                System.out.println("La coneccion con la base de datos no se pudo cerrar "+e.getMessage());
            }
        }
    }
}

