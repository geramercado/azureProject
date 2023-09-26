package proyectoAzure;

import javax.swing.*;
import java.sql.*;

public class Conexion {

    private String usuario;
    private String contrasena;

    public Conexion(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Conexion(){}



        public void consultarDatos(){
            try {
            //    String todos = "";
                // hacemos la conexion
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallerdb","root", "root");

                // Realizamos el query que recibe mySQL
                String query = "select * from usuarios where usuario = '"+usuario+"' and contrasena = sha1('"+contrasena+"');";

                // creamos el canal de enlace con statement
                Statement estado = conexion.createStatement();

                // Mandamos con resultSet a traves del canal el Query
                ResultSet resultado = estado.executeQuery(query);
                System.out.println("Realizado");
                VentanaMenu ventanamenu = new VentanaMenu();

                    // mientras sucede el resultado
                    while (resultado.next()) {
                        String nombre = resultado.getString("nombre");
                        String apellidos = resultado.getString("apellidos");
                        String usuario = resultado.getString("usuario");
                        String contrasena = resultado.getString("contrasena");
                        String correo = resultado.getString("correo");
                        System.out.format("%s, %s, %s, %s, %s \n", nombre, apellidos, usuario, contrasena, correo);
                        //    todos += nombre+"  "+apellidos+"  "+usuario+"  "+contrasena+"  "+correo;
                        // System.out.println(todos);
                        ventanamenu.mostrarEnArea(nombre, apellidos, usuario, contrasena, correo);
                        ventanamenu.setVisible(true);
                    }

                    //nombre,apellidos,usuario,contrasena,correo

                    resultado.close();
                    //    return todos;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Usuario no existente");
            }

         //   return "esto está vacio";
        }



    public void insertarDatos(String nombre, String apellidos, String usuario, String contrasena, String correo){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallerdb","root", "root");
            Statement estado = conexion.createStatement();
            ResultSet resultado = estado.executeQuery("show databases;");
            System.out.println("conectado a usuarios");

            //campo calendario
            //Calendar calendario = Calendar.getInstance();
            //java.sql.Date iniciarFecha = new java.sql.Date(calendario.getTime().getTime());

            //crearConsulta insertar
            String consultaInsertar = "insert into usuarios(nombre, apellidos, usuario, contrasena, correo)"+
                    "values (?,?,?,sha1(?),?)";
            PreparedStatement preparaEstado = conexion.prepareStatement(consultaInsertar);

            preparaEstado.setString(1, nombre);
            preparaEstado.setString(2, apellidos);
            preparaEstado.setString(3, usuario);
            preparaEstado.setString(4, contrasena);
            preparaEstado.setString(5, correo);

            //Ejecutar el preparaEstado
            preparaEstado.execute();
            conexion.close();

        }catch(Exception e){
            System.out.println("Error - "+e);
        }
    }

}
