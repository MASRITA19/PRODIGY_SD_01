package com.tempconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TempConverter extends JFrame {
	private JTextField inputField;
    private JComboBox<String> inputUnit;
    private JLabel outputCelsius;
    private JLabel outputFahrenheit;
    private JLabel outputKelvin;
    public TempConverter() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(10, 10, 150, 25);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(150, 10, 100, 25);
        add(inputField);

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        inputUnit = new JComboBox<>(units);
        inputUnit.setBounds(260, 10, 100, 25);
        add(inputUnit);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 50, 100, 25);
        add(convertButton);

        outputCelsius = new JLabel("Celsius: ");
        outputCelsius.setBounds(10, 90, 200, 25);
        add(outputCelsius);

        outputFahrenheit = new JLabel("Fahrenheit: ");
        outputFahrenheit.setBounds(10, 120, 200, 25);
        add(outputFahrenheit);

        outputKelvin = new JLabel("Kelvin: ");
        outputKelvin.setBounds(10, 150, 200, 25);
        add(outputKelvin);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputTemp = Double.parseDouble(inputField.getText());
            String unit = (String) inputUnit.getSelectedItem();

            double celsius = 0;
            if (unit.equals("Celsius")) {
                celsius = inputTemp;
            } else if (unit.equals("Fahrenheit")) {
                celsius = (inputTemp - 32) * 5 / 9;
            } else if (unit.equals("Kelvin")) {
                celsius = inputTemp - 273.15;
            }

            double fahrenheit = celsius * 9 / 5 + 32;
            double kelvin = celsius + 273.15;

            outputCelsius.setText("Celsius: " + String.format("%.2f", celsius));
            outputFahrenheit.setText("Fahrenheit: " + String.format("%.2f", fahrenheit));
            outputKelvin.setText("Kelvin: " + String.format("%.2f", kelvin));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempConverter().setVisible(true);
            }
        });
	}

}
