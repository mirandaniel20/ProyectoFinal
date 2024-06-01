/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Modelo modelo;
    private VISTA VISTA;

    public Controlador(Modelo modelo, VISTA vista) {
        this.modelo = modelo;
        this.VISTA = vista;

        vista.agregarSumarListener(new SumarListener());
        vista.agregarMultiplicarListener(new MultiplicarListener());
        vista.agregarHojaListener(new AgregarHojaListener());
        vista.agregarSelectorHojasListener(new SelectorHojasListener());

        modelo.agregarHoja("Hoja1");
        vista.agregarHojaAlSelector("Hoja1");
    }
    

    class SumarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int fila1 = VISTA.getFila1();
            int columna1 = VISTA.getColumna1();
            int fila2 = VISTA.getFila2();
            int columna2 = VISTA.getColumna2();
            int resultado = modelo.getHojaActual().sumarCeldas(fila1, columna1, fila2, columna2);
            VISTA.setResultado(resultado);
        }
    }

    class MultiplicarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int fila1 = VISTA.getFila1();
            int columna1 = VISTA.getColumna1();
            int fila2 = VISTA.getFila2();
            int columna2 = VISTA.getColumna2();
            int resultado = modelo.getHojaActual().multiplicarCeldas(fila1, columna1, fila2, columna2);
            VISTA.setResultado(resultado);
        }
    }

    class AgregarHojaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreNuevaHoja = VISTA.getNombreNuevaHoja();
            modelo.agregarHoja(nombreNuevaHoja);
            VISTA.agregarHojaAlSelector(nombreNuevaHoja);
        }
    }
    

    class SelectorHojasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hojaSeleccionada = VISTA.getHojaSeleccionada();
            modelo.cambiarHoja(hojaSeleccionada);
        }
    }

 public static void main(String[] args) {
        Modelo modelo = new Modelo();
        VISTA vista = new VISTA();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setVisible(true);
    }
        
}
