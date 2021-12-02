package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {

    private JButton miFoto, miHobby, misExpectativas;
    private Titulos titulo;
    private JPanel panelDeBotones, panelDeDatos;
    private Escucha escucha;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;

    public GUI_Presentacion() {
        initGUI();
        this.setTitle("Mi presentacion");
        this.setSize(600, 520);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI() {

        escucha = new Escucha();


        titulo = new Titulos("Hola soy Alejandro, presiona alguno de los botones", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDeDatos = new JPanel();

        panelDeDatos.setBorder(BorderFactory.createTitledBorder(null, "Acerca de mi",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                new Font("Accidental Presidency", Font.PLAIN, 35), Color.black));
        this.add(panelDeDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miHobby = new JButton("Este es mi hobby");
        misExpectativas = new JButton("Mis expectativas");

        panelDeBotones = new JPanel();

        panelDeBotones.add(miFoto);
        miFoto.addMouseListener(escucha);

        panelDeBotones.add(miHobby);
        miHobby.addMouseListener(escucha);

        panelDeBotones.add(misExpectativas);
        misExpectativas.addKeyListener(escucha);

        this.add(panelDeBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();

        textoExpectativas = new JTextArea(10, 12);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });

    }

    private class Escucha implements MouseListener, KeyListener{
        private ImageIcon image;

        // MOUSE METHODS

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource()==miFoto){
                panelDeDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/miFoto.jpg"));
                labelImagen.setIcon(image);
                panelDeDatos.add(labelImagen);

            }else{
                if(e.getSource()==miHobby && e.getClickCount()==2){
                    panelDeDatos.removeAll();
                    image = new ImageIcon(getClass().getResource("/recursos/miHobby.jpg"));
                    labelImagen.setIcon(image);
                    panelDeDatos.add(labelImagen);

                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        // KEYBOARD METHODS
        @Override
        public void keyTyped(KeyEvent e) {
            panelDeDatos.removeAll();

            // only works when the button is clicked on and you press "m" afterwards.

            if(e.getKeyChar()== 'm' || e.getKeyChar()== 'M'){
                textoExpectativas.setText("Espero poder terminar exitosamente mis estudios y"
                        +"\n"+"aprender completamente todo lo que se necesita para"
                        +"\n"+ "una vida laboral exitosa y poder conseguir todo"
                        +"\n"+ "lo que he querido tener.");
                textoExpectativas.setBackground(null);
                textoExpectativas.setForeground(Color.BLACK);
                textoExpectativas.setFont(new Font("Accidental Presidency", Font.PLAIN, 25));
                panelDeDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }


    //ACTION LISTENER

    /*private class Escucha implements ActionListener {

        private ImageIcon image;


        @Override
        public void actionPerformed(ActionEvent e) {
            panelDeDatos.removeAll();

            if(e.getSource()==miFoto){
                image = new ImageIcon(getClass().getResource("/recursos/miFoto.jpg"));
                labelImagen.setIcon(image);
                panelDeDatos.add(labelImagen);

            }else{
                if(e.getSource()==miHobby){
                    image = new ImageIcon(getClass().getResource("/recursos/miHobby.jpg"));
                    labelImagen.setIcon(image);
                    panelDeDatos.add(labelImagen);
                }else{

                    textoExpectativas.setText("Espero poder terminar exitosamente mis estudios y"
                                             +"\n"+"aprender completamente todo lo que se necesita para"
                                             +"\n"+ "una vida laboral exitosa y poder conseguir todo"
                                             +"\n"+ "lo que he querido tener.");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setForeground(Color.BLACK);
                    textoExpectativas.setFont(new Font("Accidental Presidency", Font.PLAIN, 25));
                    panelDeDatos.add(textoExpectativas);

                }
            }
            revalidate();
            repaint();
        }
    }*/

}