package proyectoAzure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JFrame {

    JPanel panel =  new JPanel();
    JTextField cajaNombre = new JTextField();
    JTextField cajaApellidos = new JTextField();
    JTextField cajaNombreUsuario = new JTextField();
    JTextField cajaPassword = new JTextField();
    JTextField cajaEmail = new JTextField();
    JLabel etiquetaNombre = new JLabel();
    JLabel etiquetaApellidos = new JLabel();
    JLabel etiquetaNombreUsuario = new JLabel();
    JLabel etiquetaPassword = new JLabel();
    JLabel etiquetaEmail = new JLabel();
    JButton botonAceptar = new JButton();
    JButton botonCancelar = new JButton();


        VentanaRegistro(){
            panel();
        }


        public void panel(){
            this.getContentPane().add(panel);
            panel.setLayout(null);
            setLocation(400,170);
            setTitle("Registro usuarios");
            setSize(500, 350);
            this.setResizable(false);
            ejecutarTodo();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public void ejecutarTodo(){
                  etiquetas();
                  cajasTexto();
                  botones();
                //textoEnArea();
                  accionesBotones();
        }

        public void etiquetas(){

            etiquetaNombre.setBounds(85, 15, 50, 75);
            etiquetaNombre.setText("Nombre:");
            panel.add(etiquetaNombre);

            etiquetaApellidos.setBounds(85, 50, 80, 75);
            etiquetaApellidos.setText("Apellidos:");
            panel.add(etiquetaApellidos);

            etiquetaNombreUsuario.setBounds(85, 85, 150, 75);
            etiquetaNombreUsuario.setText("Nombre de usuario:");
            panel.add(etiquetaNombreUsuario);

            etiquetaPassword.setBounds(85, 120, 150, 75);
            etiquetaPassword.setText("Contraseña:");
            panel.add(etiquetaPassword);

            etiquetaEmail.setBounds(85, 155, 150, 75);
            etiquetaEmail.setText("Correo:");
            panel.add(etiquetaEmail);

        }

        public void cajasTexto(){

            cajaNombre.setBounds(140, 40, 200, 25);
            panel.add(cajaNombre);

            cajaApellidos.setBounds(145, 75, 200, 25);
            panel.add(cajaApellidos);

            cajaNombreUsuario.setBounds(200, 110, 220, 25);
            panel.add(cajaNombreUsuario);

            cajaPassword.setBounds(160, 145, 220, 25);
            panel.add(cajaPassword);

            cajaEmail.setBounds(130, 180, 220, 25);
            panel.add(cajaEmail);
        }

        public void botones(){

            botonAceptar.setBounds(150, 230, 95, 30);
            botonAceptar.setText("Aceptar");
            panel.add(botonAceptar);

            botonCancelar.setBounds(280, 230, 95, 30);
            botonCancelar.setText("Cancelar");
            panel.add(botonCancelar);
            ActionListener oyenteCancelar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    VentanaLogin ventanaLogin = new VentanaLogin();
                    cajaNombre.setText("");
                    cajaApellidos.setText("");
                    cajaNombreUsuario.setText("");
                    cajaPassword.setText("");
                    cajaEmail.setText("");
                    ventanaLogin.setVisible(true);
                    setVisible(false);

                }
            };
            botonCancelar.addActionListener(oyenteCancelar);

        }

        public void registrar(){

            if(cajaNombre.getText().equals("") && cajaNombreUsuario.getText().equals("") &&
                    cajaPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No acepta campos vacíos");
            }else{
                String nombre = cajaNombre.getText();
                String apellidos = cajaApellidos.getText();
                String usuario = cajaNombreUsuario.getText();
                String contrasena = cajaPassword.getText();
                String correo = cajaEmail.getText();

                cajaNombre.setText("");
                cajaApellidos.setText("");
                cajaNombreUsuario.setText("");
                cajaPassword.setText("");
                cajaEmail.setText("");

                Conexion conexion = new Conexion();
                conexion.insertarDatos(nombre, apellidos, usuario, contrasena, correo);

            }
        }

        public void accionesBotones(){
            ActionListener oyenteAceptar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    registrar();
                }
            };
            botonAceptar.addActionListener(oyenteAceptar);
        }


}
