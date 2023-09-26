package proyectoAzure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {


    JPanel panel =  new JPanel();
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JTextField caja1 = new JTextField();
    JTextField caja2 = new JTextField();
    JButton botonIngresar = new JButton();
    JButton botonCancelar = new JButton();
    JButton botonRegistrarme = new JButton();
    String usuario;
    String contrasena;



        VentanaLogin(){
            panel();
        }


        public void panel(){
            this.getContentPane().add(panel);
            panel.setLayout(null);
            setLocation(400,170);
            setTitle("Login Usuarios");
            setSize(500, 300);
            this.setResizable(false);
            ejecutarTodo();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public void ejecutarTodo(){
              etiquetas();
              cajasTexto();
              botones();
         //   textoEnArea();
        }

        private void etiquetas() {

            etiqueta1.setBounds(220,1, 80, 50);
            etiqueta1.setText("Usuario");
            panel.add(etiqueta1);

            etiqueta2.setBounds(210,60, 80, 50);
            etiqueta2.setText("Contraseña");
            panel.add(etiqueta2);

        }

        public void cajasTexto() {

            caja1.setBounds(145, 37, 200, 25);
            panel.add(caja1);

            caja2.setBounds(123, 97, 250, 25);
            panel.add(caja2);

        }

        public void botones() {

            botonIngresar.setText("Ingresar");
            botonIngresar.setBounds(100, 140, 95, 30);
            panel.add(botonIngresar);
            ActionListener oyenteIngresar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarDatos();
                }
            };
            botonIngresar.addActionListener(oyenteIngresar);

            botonCancelar.setText("Cancelar");
            botonCancelar.setBounds(300, 140, 95, 30);
            panel.add(botonCancelar);
            ActionListener oyenteCancelar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    caja1.setText("");
                    caja2.setText("");
                }
            };
            botonCancelar.addActionListener(oyenteCancelar);

            botonRegistrarme.setText("Registrarme");
            botonRegistrarme.setBounds(10, 10, 120, 25);
            panel.add(botonRegistrarme);
            ActionListener oyeBotonRegistro = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VentanaRegistro ventanaRegistro = new VentanaRegistro();
                    ventanaRegistro.setVisible(true);
                    setVisible(false);
                }
            };
            botonRegistrarme.addActionListener(oyeBotonRegistro);

        }

        public void mostrarDatos(){

            if(caja1.getText().equals("") || caja2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa datos");
                caja1.setText("");
                caja2.setText("");
            }else {
                String usuario = caja1.getText();
                String contrasena = caja2.getText();
                Conexion conexion = new Conexion(usuario, contrasena);
                conexion.consultarDatos();
                caja1.setText("");
                caja2.setText("");
            }



        }

}
