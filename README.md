import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Papeleria_Doña_Lety {
   

public class PapeleriaDonaLety extends JFrame implements ActionListener {
    private JButton boton1, boton2;
    private JPanel pedidosPanel;
    private JTextField nombreClienteField;
    private JTextArea descripcionPedidoArea;

    public PapeleriaDonaLety() {
        setLayout(new FlowLayout());

        // Botones principales
        boton1 = new JButton("Iniciar");
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Crear cuenta");
        add(boton2);
        boton2.addActionListener(this);

        // Panel de pedidos
        pedidosPanel = new JPanel();
        pedidosPanel.setLayout(new BoxLayout(pedidosPanel, BoxLayout.Y_AXIS));
        pedidosPanel.add(new JLabel("Realiza tu pedido personalizado:"));

        nombreClienteField = new JTextField(20);
        descripcionPedidoArea = new JTextArea(5, 20);
        descripcionPedidoArea.setLineWrap(true);
        descripcionPedidoArea.setWrapStyleWord(true);
        JButton guardarPedidoBtn = new JButton("Guardar Pedido");

        pedidosPanel.add(new JLabel("Nombre del cliente:"));
        pedidosPanel.add(nombreClienteField);
        pedidosPanel.add(new JLabel("Descripción del pedido:"));
        pedidosPanel.add(new JScrollPane(descripcionPedidoArea));
        pedidosPanel.add(guardarPedidoBtn);

        guardarPedidoBtn.addActionListener(e -> {
            String nombre = nombreClienteField.getText();
            String descripcion = descripcionPedidoArea.getText();

            if (guardarPedido(nombre, descripcion)) {
                JOptionPane.showMessageDialog(this, "¡Pedido guardado exitosamente!");
                nombreClienteField.setText("");
                descripcionPedidoArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el pedido.");
            }
        });

        add(pedidosPanel);
    }

    private boolean guardarPedido(String nombre, String descripcion) {
        // Lógica para guardar el pedido (implementa según tus necesidades)
        return !nombre.isEmpty() && !descripcion.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            setTitle("Botón Iniciar");
        } else if (e.getSource() == boton2) {
            setTitle("Botón Crear cuenta");
        }
    }

    }
}
