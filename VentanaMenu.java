package proyectoAzure;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {



    JTextArea areaDetexto = new JTextArea();
    JPanel panel =  new JPanel();

    VentanaMenu(){
        panel();
    }

        public void panel(){
            this.getContentPane().add(panel);
            panel.setLayout(null);
            setLocation(400,170);
            setTitle("Menu usuarios");
            this.setResizable(false);
            setSize(800, 300);
            ejecutarTodo();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }


        public void ejecutarTodo(){
            etiquetas();
            textoEnArea();
           // mostrarEnArea();
        }


        public void textoEnArea(){
            areaDetexto.setBounds(10,80,761,100);
            areaDetexto.setBorder(BorderFactory.createLineBorder(Color.gray));
            areaDetexto.setEditable(false);
            panel.add(areaDetexto);
        }

        public void etiquetas(){

            JLabel etiquetaDatos = new JLabel();
            etiquetaDatos.setBounds(10,45, 100,50);
            etiquetaDatos.setText("Datos de usuario:");
            panel.add(etiquetaDatos);
        }

        public void mostrarEnArea(String nombre, String apellidos, String usuario, String contrasena, String correo){
            areaDetexto.setText(nombre+", "+apellidos+", "+usuario+", "+contrasena+", "+correo);
        }
}
