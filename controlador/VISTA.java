/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Wine
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VISTA extends JFrame {
    private JTextField[][] camposCeldas;
    private JButton botonSumar, botonMultiplicar;
    private JTextField campoFila1, campoColumna1, campoFila2, campoColumna2;
    private JLabel etiquetaResultado;
    private JComboBox<String> selectorHojas;
    private JButton botonAgregarHoja;
    private JTextField campoNombreNuevaHoja;

    public VISTA() {
        setTitle("Hoja de Cálculo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelHoja = new JPanel(new GridLayout(11, 10));
        camposCeldas = new JTextField[10][10];

        // Etiquetas de las columnas (letras)
        panelHoja.add(new JLabel());
        for (char c = 'A'; c <= 'J'; c++) {
            panelHoja.add(new JLabel(String.valueOf(c)));
        }

        for (int i = 0; i < 10; i++) {
            // Etiquetas de las filas (números)
            panelHoja.add(new JLabel(String.valueOf(i + 1)));

            for (int j = 0; j < 10; j++) {
                camposCeldas[i][j] = new JTextField();
                panelHoja.add(camposCeldas[i][j]);
            }
        }

        JPanel panelControl = new JPanel();
        panelControl.setLayout(new GridLayout(3, 2));

        campoFila1 = new JTextField();
        campoColumna1 = new JTextField();
        campoFila2 = new JTextField();
        campoColumna2 = new JTextField();
        botonSumar = new JButton("Sumar");
        botonMultiplicar = new JButton("Multiplicar");
        etiquetaResultado = new JLabel("Resultado: ");

        panelControl.add(new JLabel("Fila 1:"));
        panelControl.add(campoFila1);
        panelControl.add(new JLabel("Columna 1:"));
        panelControl.add(campoColumna1);
        panelControl.add(new JLabel("Fila 2:"));
        panelControl.add(campoFila2);
        panelControl.add(new JLabel("Columna 2:"));
        panelControl.add(campoColumna2);
        panelControl.add(botonSumar);
        panelControl.add(botonMultiplicar);
        panelControl.add(etiquetaResultado);

        JPanel panelControlHojas = new JPanel();
        campoNombreNuevaHoja = new JTextField(10);
        botonAgregarHoja = new JButton("Agregar Hoja");
        selectorHojas = new JComboBox<>();

        panelControlHojas.add(new JLabel("Nueva Hoja:"));
        panelControlHojas.add(campoNombreNuevaHoja);
        panelControlHojas.add(botonAgregarHoja);
        panelControlHojas.add(selectorHojas);

        add(panelHoja, BorderLayout.CENTER);
        add(panelControl, BorderLayout.SOUTH);
        add(panelControlHojas, BorderLayout.NORTH);
    }

    public void setValorCelda(int fila, int columna, int valor) {
        camposCeldas[fila][columna].setText(String.valueOf(valor));
    }

    public int getValorCelda(int fila, int columna) {
        return Integer.parseInt(camposCeldas[fila][columna].getText());
    }

    public int getFila1() {
        return Integer.parseInt(campoFila1.getText());
    }

    public int getColumna1() {
        return Integer.parseInt(campoColumna1.getText());
    }

    public int getFila2() {
        return Integer.parseInt(campoFila2.getText());
    }

    public int getColumna2() {
        return Integer.parseInt(campoColumna2.getText());
    }

    public void setResultado(int resultado) {
        etiquetaResultado.setText("Resultado: " + resultado);
    }

    public void agregarSumarListener(ActionListener listener) {
        botonSumar.addActionListener(listener);
    }

    public void agregarMultiplicarListener(ActionListener listener) {
        botonMultiplicar.addActionListener(listener);
    }

    public void agregarHojaListener(ActionListener listener) {
        botonAgregarHoja.addActionListener(listener);
    }

    public void agregarSelectorHojasListener(ActionListener listener) {
        selectorHojas.addActionListener(listener);
    }

    public void agregarHojaAlSelector(String nombreHoja) {
        selectorHojas.addItem(nombreHoja);
    }

    public String getHojaSeleccionada() {
        return (String) selectorHojas.getSelectedItem();
    }

    public String getNombreNuevaHoja() {
        return campoNombreNuevaHoja.getText();
    }
}