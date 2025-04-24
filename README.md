import javax.swing.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener{
    private JButton boton1,boton2;
    public Formulario() {
        setLayout(null);
        boton1=new JButton("Crear cuenta");
        boton1.setBounds(200,100,120,35);
        boton1.addActionListener(this);
        add(boton1);
        boton2=new JButton("Iniciar sesión");
        boton2.setBounds(15,100,120,35);
        boton2.addActionListener(this);
        add(boton2);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            setTitle("Crear cuenta");
        }
        if (e.getSource()==boton2) {
            setTitle("Iniciar sesión");
        }
    }
    
    public static void main(String[] ar) {
        Formulario formulario1=new Formulario();
        formulario1.setBounds(200,200,400,400);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
