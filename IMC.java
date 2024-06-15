import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMC {
    public static void main(String[] args) {
        // Crear el marco de la aplicación
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Crear y añadir etiqueta para la altura
        JLabel heightLabel = new JLabel("Altura (m):");
        heightLabel.setBounds(50, 50, 100, 30);
        frame.add(heightLabel);

        // Crear y añadir campo de texto para la altura
        JTextField heightField = new JTextField();
        heightField.setBounds(150, 50, 150, 30);
        frame.add(heightField);

        // Crear y añadir etiqueta para el peso
        JLabel weightLabel = new JLabel("Peso (kg):");
        weightLabel.setBounds(50, 100, 100, 30);
        frame.add(weightLabel);

        // Crear y añadir campo de texto para el peso
        JTextField weightField = new JTextField();
        weightField.setBounds(150, 100, 150, 30);
        frame.add(weightField);

        // Crear y añadir botón para calcular el IMC
        JButton calculateButton = new JButton("Calcular IMC");
        calculateButton.setBounds(50, 150, 150, 30);
        frame.add(calculateButton);

        // Crear y añadir etiqueta para mostrar el resultado
        JLabel resultLabel = new JLabel("IMC:");
        resultLabel.setBounds(50, 200, 250, 30);
        frame.add(resultLabel);

        // Añadir el listener para el botón de cálculo
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los valores de altura y peso ingresados por el usuario
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    // Calcular el IMC
                    double imc = weight / (height * height);

                    // Determinar la categoría del IMC
                    String category;
                    if (imc < 18.5) {
                        category = "Bajo peso";
                    } else if (imc < 24.9) {
                        category = "Normal";
                    } else if (imc < 29.9) {
                        category = "Sobrepeso";
                    } else {
                        category = "Obesidad";
                    }

                    // Mostrar el resultado en la etiqueta de resultado
                    resultLabel.setText(String.format("IMC: %.2f - %s", imc, category));
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje de error si los valores ingresados no son válidos
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores válidos.");
                }
            }
        });

        // Hacer visible el marco de la aplicación
        frame.setLocationRelativeTo(null); // Colocar la ventana en el centro de la pantalla
        frame.setVisible(true);
    }
}
