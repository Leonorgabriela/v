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
                    textResultado.setText(explicarMCM(num1, num2));
                    break;
                case "MCD":
                    textResultado.setText(explicarMCD(num1, num2));
                    break;
                case "División":
                    if (num2 != 0) {
                        double resultado = (double) num1 / num2;
                        textResultado.setText("Operación: " + num1 + " ÷ " + num2 + "\nResultado: " + resultado);
                    } else {
                        textResultado.setText("❌ No se puede dividir por cero.");
                    }
                    break;
                case "Número Primo":
                    textResultado.setText(explicarPrimo(num1) + "\n\n" + explicarPrimo(num2));
                    break;
                case "Sucesión Aritmética":
                    textResultado.setText(generarSucesionAritmetica(num1, num2));
                    break;
                case "Sucesión Geométrica":
                    textResultado.setText(generarSucesionGeometrica(num1, num2));
                    break;
                case "Ordenar Números":
                    textResultado.setText("Números ingresados: " + num1 + ", " + num2 + "\n" + ordenarNumeros(num1, num2));
                    break;
                case "Probabilidad Simple":
                    textResultado.setText(calcularProbabilidad(num1, num2));
                    break;
                default:
                    textResultado.setText("Seleccione una operación válida.");
                    break;
            }
        } catch (NumberFormatException ex) {
            textResultado.setText("⚠️ Por favor ingrese números válidos.");
        }
    }

    // Método para calcular el MCD
    private String explicarMCD(int a, int b) {
        StringBuilder sb = new StringBuilder("📘 Proceso para calcular el MCD:\n");
        int originalA = a, originalB = b;
        while (b != 0) {
            sb.append("MCD(").append(a).append(", ").append(b).append(") → ");
            int temp = b;
            b = a % b;
            a = temp;
            sb.append("nuevo b = ").append(b).append("\n");
        }
        sb.append("\n✅ Resultado: El MCD de ").append(originalA).append(" y ").append(originalB).append(" es: ").append(a);
        return sb.toString();
    }

    // Método para calcular el MCM
    private String explicarMCM(int a, int b) {
        int mcd = calcularMCD(a, b);
        int mcm = (a * b) / mcd;
        return "📘 Proceso para calcular el MCM:\n" +
               "Paso 1: Calcular el MCD de " + a + " y " + b + " → " + mcd + "\n" +
               "Paso 2: Usar fórmula: (a × b) / MCD\n" +
               "→ (" + a + " × " + b + ") / " + mcd + " = " + mcm + "\n" +
               "✅ Resultado: El MCM de " + a + " y " + b + " es: " + mcm;
    }

    // Método para verificar si un número es primo
    private String explicarPrimo(int num) {
        if (num <= 1) return num + " ❌ no es primo (los primos son mayores que 1)";
        StringBuilder sb = new StringBuilder("🔍 Verificando si " + num + " es primo:\n");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sb.append(num).append(" es divisible entre ").append(i).append(" → ❌ No es primo");
                return sb.toString();
            }
            sb.append(num).append(" no es divisible entre ").append(i).append("\n");
        }
        sb.append("✅ ").append(num).append(" es primo");
        return sb.toString();
    }

    // Método para generar una sucesión aritmética
    private String generarSucesionAritmetica(int a, int d) {
        StringBuilder sb = new StringBuilder("📘 Sucesión Aritmética (inicio = " + a + ", diferencia = " + d + "):\n");
        for (int i = 0; i < 10; i++) {
            sb.append(a + i * d).append(" ");
        }
        return sb.toString();
    }

    // Método para generar una sucesión geométrica
    private String generarSucesionGeometrica(int a, int r) {
        StringBuilder sb = new StringBuilder("📘 Sucesión Geométrica (inicio = " + a + ", razón = " + r + "):\n");
        for (int i = 0; i < 10; i++) {
            sb.append((int)(a * Math.pow(r, i))).append(" ");
        }
        return sb.toString();
    }

    // Método para ordenar los números
    private String ordenarNumeros(int a, int b) {
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);
        return "✅ Orden: " + menor + ", " + mayor;
    }

    // Método para calcular la probabilidad
    private String calcularProbabilidad(int favorables, int posibles) {
        if (posibles == 0) return "⚠️ Los casos posibles no pueden ser cero.";
        double probabilidad = (double) favorables / posibles;
        return "📘 Proceso:\n" +
               "Casos favorables: " + favorables + "\n" +
               "Casos posibles: " + posibles + "\n" +
               "Fórmula: P = favorables / posibles\n" +
               "→ P = " + favorables + "/" + posibles + " = " + probabilidad + "\n" +
               "✅ Probabilidad simple: " + probabilidad;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraMatematica().setVisible(true);
        });
    }
}
