import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI {
    private JFrame frame;
    private JComboBox<String> operacionesComboBox;
    private JComboBox<String> subOperacionesComboBox;
    private JTextArea resultadoArea;
    private JButton calcularButton;

    public CalculadoraGUI() {
        frame = new JFrame("Calculadora Matemática");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel operacionesLabel = new JLabel("Selecciona una operación:");
        operacionesLabel.setBounds(10, 20, 200, 25);
        frame.add(operacionesLabel);

        String[] operaciones = {"Operaciones básicas", "Sucesiones", "Orden", "Probabilidad"};
        operacionesComboBox = new JComboBox<>(operaciones);
        operacionesComboBox.setBounds(180, 20, 200, 25);
        frame.add(operacionesComboBox);

        JLabel subOperacionesLabel = new JLabel("Selecciona una suboperación:");
        subOperacionesLabel.setBounds(10, 60, 200, 25);
        frame.add(subOperacionesLabel);

        subOperacionesComboBox = new JComboBox<>();
        subOperacionesComboBox.setBounds(180, 60, 200, 25);
        frame.add(subOperacionesComboBox);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(10, 100, 200, 25);
        frame.add(calcularButton);

        resultadoArea = new JTextArea();
        resultadoArea.setBounds(10, 140, 360, 200);
        resultadoArea.setEditable(false);
        frame.add(resultadoArea);

        operacionesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarSubOperaciones();
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion();
            }
        });

        frame.setVisible(true);
    }

    private void actualizarSubOperaciones() {
        String opcion = (String) operacionesComboBox.getSelectedItem();
        subOperacionesComboBox.removeAllItems();

        if (opcion.equals("Operaciones básicas")) {
            subOperacionesComboBox.addItem("División");
            subOperacionesComboBox.addItem("MCM");
            subOperacionesComboBox.addItem("MCD");
            subOperacionesComboBox.addItem("Verificar primo");
        } else if (opcion.equals("Sucesiones")) {
            subOperacionesComboBox.addItem("Secuencia Fibonacci");
            subOperacionesComboBox.addItem("Congruencia");
            subOperacionesComboBox.addItem("Teorema de Euler");
            subOperacionesComboBox.addItem("Sucesión aritmética");
            subOperacionesComboBox.addItem("Sucesión geométrica");
        } else if (opcion.equals("Orden")) {
            subOperacionesComboBox.addItem("Números ascendentes");
            subOperacionesComboBox.addItem("Números descendentes");
        } else if (opcion.equals("Probabilidad")) {
            subOperacionesComboBox.addItem("Permutación");
            subOperacionesComboBox.addItem("Combinación");
        }
    }

    private void realizarOperacion() {
        String operacion = (String) operacionesComboBox.getSelectedItem();
        String subOperacion = (String) subOperacionesComboBox.getSelectedItem();
        String resultado = "";

        if (operacion.equals("Operaciones básicas")) {
            if (subOperacion.equals("División")) {
                resultado = "Función de división seleccionada.";
                // Implementar lógica de división
            } else if (subOperacion.equals("MCM")) {
                resultado = "Función de MCM seleccionada.";
                // Implementar lógica de MCM
            } else if (subOperacion.equals("MCD")) {
                resultado = "Función de MCD seleccionada.";
                // Implementar lógica de MCD
            } else if (subOperacion.equals("Verificar primo")) {
                resultado = "Función de verificar primo seleccionada.";
                // Implementar lógica de verificar primo
            }
        } else if (operacion.equals("Sucesiones")) {
            if (subOperacion.equals("Secuencia Fibonacci")) {
                resultado = "Función de Fibonacci seleccionada.";
                // Implementar lógica de Fibonacci
            } else if (subOperacion.equals("Congruencia")) {
                resultado = "Función de congruencia seleccionada.";
                // Implementar lógica de congruencia
            } else if (subOperacion.equals("Teorema de Euler")) {
                resultado = "Función de Euler seleccionada.";
                // Implementar lógica de Euler
            } else if (subOperacion.equals("Sucesión aritmética")) {
                resultado = "Función de sucesión aritmética seleccionada.";
                // Implementar lógica de sucesión aritmética
            } else if (subOperacion.equals("Sucesión geométrica")) {
                resultado = "Función de sucesión geométrica seleccionada.";
                // Implementar lógica de sucesión geométrica
            }
        } else if (operacion.equals("Orden")) {
            if (subOperacion.equals("Números ascendentes")) {
                resultado = "Función de números ascendentes seleccionada.";
                // Implementar lógica de números ascendentes
            } else if (subOperacion.equals("Números descendentes")) {
                resultado = "Función de números descendentes seleccionada.";
                // Implementar lógica de números descendentes
            }
        } else if (operacion.equals("Probabilidad")) {
            if (subOperacion.equals("Permutación")) {
                resultado = "Función de permutación seleccionada.";
                // Implementar lógica de permutación
            } else if (subOperacion.equals("Combinación")) {
                resultado = "Función de combinación seleccionada.";
                // Implementar lógica de combinación
            }
        }

        resultadoArea.setText(resultado);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}
