import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ProyectoFinal1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearInterfaz());
    }

    public static void crearInterfaz() {
        JFrame frame = new JFrame("Bienvenido a la Papelería Doña Leti");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel etiqueta_anuncio = new JLabel("Menú de pedido");
        JLabel etiqueta_2 = new JLabel("1. Agregar pedido");
        JLabel etiqueta_3 = new JLabel("2. Mostrar pedido");
        JLabel etiqueta_4 = new JLabel("3. Buscar producto");
        JLabel etiqueta_5 = new JLabel("4. Salir");
        JButton button = new JButton("Enviar");
        JLabel nombre_usuario = new JLabel("Opción");
        JTextField textField = new JTextField(20);

        // Tamaño y posición de los componentes
        etiqueta_anuncio.setBounds(30, 10, 250, 20);
        etiqueta_anuncio.setFont(new Font("", Font.BOLD, 20));
        etiqueta_2.setBounds(40, 50, 200, 30);
        etiqueta_3.setBounds(40, 70, 200, 30);
        etiqueta_4.setBounds(40, 90, 200, 30);
        etiqueta_5.setBounds(40, 110, 200, 30);
        button.setBounds(300, 150, 150, 30);
        nombre_usuario.setBounds(40, 150, 200, 30);
        textField.setBounds(100, 150, 200, 30);

        frame.add(etiqueta_anuncio);
        frame.add(etiqueta_2);
        frame.add(etiqueta_3);
        frame.add(etiqueta_4);
        frame.add(etiqueta_5);
        frame.add(button);
        frame.add(nombre_usuario);
        frame.add(textField);

        frame.setVisible(true);

        // Límite de productos con un array
        final int productoS = 10;
        String[] producto = new String[productoS];
        int[] contador = {0};

        // Acción del botón "Enviar"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText().trim();
                switch (input) {
                    case "1":
                        if (contador[0] < productoS) {
                            String otroP = JOptionPane.showInputDialog(frame, "Ingresa el nombre del producto:");
                            if (otroP != null && !otroP.isEmpty()) {
                                producto[contador[0]] = otroP;
                                contador[0]++;
                                JOptionPane.showMessageDialog(frame, "Se agregó el producto: " + otroP);
                            } else {
                                JOptionPane.showMessageDialog(frame, "No se agregó ningún producto");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Alcanzaste el límite de productos por pedido");
                        }
                        break;
                    case "2":
                        if (contador[0] == 0) {
                            JOptionPane.showMessageDialog(frame, "No hay nada registrado aún");
                        } else {
                            StringBuilder registro = new StringBuilder("Pedido registrado: \n");
                            for (int i = 0; i < contador[0]; i++) {
                                registro.append("- ").append(producto[i]).append("\n");
                            }
                            JOptionPane.showMessageDialog(frame, registro.toString());
                        }
                        break;
                    case "3":
                        String Pd = JOptionPane.showInputDialog(frame, "Ingresa el producto que deseas buscar");
                        if (Pd != null && !Pd.isEmpty()) {
                            boolean encontrado = false;
                            for (int i = 0; i < contador[0]; i++) {
                                if (producto[i].equalsIgnoreCase(Pd)) {
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (encontrado) {
                                JOptionPane.showMessageDialog(frame, "Producto encontrado: " + Pd);
                            } else {
                                JOptionPane.showMessageDialog(frame, "Producto no encontrado: " + Pd);
                            }
                        }
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(frame, "Gracias por comprar con nosotros.");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Opción no válida");
                        break;
                }
                textField.setText(""); // Limpiar el campo de texto
            }
        });
    }
}
