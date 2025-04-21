import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CalculadoraMatematica extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<String> comboCategoria;
    private JComboBox<String> comboOperacion;
    private JTextArea textResultado;
    private JTextField input1;
    private JTextField input2;
    private JButton btnCalcular;

    public CalculadoraMatematica() {
        setTitle("Calculadora Matemática");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(7, 2, 10, 10));

        comboCategoria = new JComboBox<>(new String[] {"Seleccione una categoría", "Operaciones básicas", "Sucesiones", "Orden", "Probabilidad"});
        comboOperacion = new JComboBox<>();

        input1 = new JTextField();
        input2 = new JTextField();
        btnCalcular = new JButton("Calcular");
        textResultado = new JTextArea();
        textResultado.setLineWrap(true);
        textResultado.setWrapStyleWord(true);

        panelPrincipal.add(new JLabel("Categoría:"));
        panelPrincipal.add(comboCategoria);
        panelPrincipal.add(new JLabel("Operación:"));
        panelPrincipal.add(comboOperacion);
        panelPrincipal.add(new JLabel("Número 1:"));
        panelPrincipal.add(input1);
        panelPrincipal.add(new JLabel("Número 2:"));
        panelPrincipal.add(input2);
        panelPrincipal.add(btnCalcular);
        panelPrincipal.add(new JScrollPane(textResultado));

        add(panelPrincipal);

        comboCategoria.addActionListener(e -> actualizarOperaciones());
        btnCalcular.addActionListener(e -> calcularOperacion());
    }

    private void actualizarOperaciones() {
        String categoria = (String) comboCategoria.getSelectedItem();
        comboOperacion.removeAllItems();

        if ("Operaciones básicas".equals(categoria)) {
            comboOperacion.addItem("MCM");
            comboOperacion.addItem("MCD");
            comboOperacion.addItem("División");
            comboOperacion.addItem("Número Primo");
        } else if ("Sucesiones".equals(categoria)) {
            comboOperacion.addItem("Sucesión Aritmética");
            comboOperacion.addItem("Sucesión Geométrica");
        } else if ("Orden".equals(categoria)) {
            comboOperacion.addItem("Ordenar Números");
        } else if ("Probabilidad".equals(categoria)) {
            comboOperacion.addItem("Probabilidad Simple");
        }
    }

    private void calcularOperacion() {
        String operacion = (String) comboOperacion.getSelectedItem();

        try {
            int num1 = Integer.parseInt(input1.getText());
            int num2 = Integer.parseInt(input2.getText());

            switch (operacion) {
                case "MCM":
                    int mcm = calcularMCM(num1, num2);
                    textResultado.setText("El MCM de " + num1 + " y " + num2 + " es: " + mcm);
                    break;
                case "MCD":
                    int mcd = calcularMCD(num1, num2);
                    textResultado.setText("El MCD de " + num1 + " y " + num2 + " es: " + mcd);
                    break;
                case "División":
                    if (num2 != 0) {
                        double resultado = (double) num1 / num2;
                        textResultado.setText("El resultado de la división es: " + resultado);
                    } else {
                        textResultado.setText("No se puede dividir por cero.");
                    }
                    break;
                case "Número Primo":
                    boolean primo1 = esPrimo(num1);
                    boolean primo2 = esPrimo(num2);
                    textResultado.setText(num1 + (primo1 ? " es primo" : " no es primo") + "\n" + num2 + (primo2 ? " es primo" : " no es primo"));
                    break;
                case "Sucesión Aritmética":
                    textResultado.setText(generarSucesionAritmetica(num1, num2));
                    break;
                case "Sucesión Geométrica":
                    textResultado.setText(generarSucesionGeometrica(num1, num2));
                    break;
                case "Ordenar Números":
                    textResultado.setText(ordenarNumeros(num1, num2));
                    break;
                case "Probabilidad Simple":
                    textResultado.setText(calcularProbabilidad(num1, num2));
                    break;
                default:
                    textResultado.setText("Seleccione una operación válida.");
                    break;
            }
        } catch (NumberFormatException ex) {
            textResultado.setText("Por favor ingrese números válidos.");
        }
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private int calcularMCM(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }

    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private String generarSucesionAritmetica(int a, int d) {
        StringBuilder sb = new StringBuilder("Sucesión Aritmética:\n");
        for (int i = 0; i < 10; i++) {
            sb.append(a + i * d).append(" ");
        }
        return sb.toString();
    }

    private String generarSucesionGeometrica(int a, int r) {
        StringBuilder sb = new StringBuilder("Sucesión Geométrica:\n");
        for (int i = 0; i < 10; i++) {
            sb.append((int)(a * Math.pow(r, i))).append(" ");
        }
        return sb.toString();
    }

    private String ordenarNumeros(int a, int b) {
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);
        return "Números ordenados: " + menor + ", " + mayor;
    }

    private String calcularProbabilidad(int favorables, int posibles) {
        if (posibles == 0) return "Los casos posibles no pueden ser cero.";
        double probabilidad = (double) favorables / posibles;
        return "La probabilidad es: " + probabilidad;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraMatematica().setVisible(true);
        });
    }
}
