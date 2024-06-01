/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Wine
 */
import java.util.HashMap;

public class Modelo {
    private HashMap<String, Hoja> hojas;
    private Hoja hojaActual;
    
    public Modelo() {
        hojas = new HashMap<>();
        agregarHoja("Hoja1"); // Agregar una hoja por defecto al crear el modelo
    }
    
    // Método para agregar una nueva hoja
    public void agregarHoja(String nombre) {
        hojas.put(nombre, new Hoja(nombre));
        hojaActual = hojas.get(nombre);
    }
    
    // Método para cambiar a una hoja existente
    public void cambiarHoja(String nombre) {
        if (hojas.containsKey(nombre)) {
            hojaActual = hojas.get(nombre);
        }
    }
    
    // Método para eliminar una hoja existente
    public void eliminarHoja(String nombre) {
        if (hojas.containsKey(nombre)) {
            hojas.remove(nombre);
        }
    }
    
    // Método para obtener todas las hojas
    public HashMap<String, Hoja> getHojas() {
        return hojas;
    }
    
    // Método para obtener la hoja actual
    public Hoja getHojaActual() {
        return hojaActual;
    }
}

class Hoja {
    private String nombre;
    private Celda[][] celdas;
    private static final int TAMANO = 10; // Tamaño de la hoja 10x10
    
    public Hoja(String nombre) {
        this.nombre = nombre;
        celdas = new Celda[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setValorCelda(int fila, int columna, int valor) {
        celdas[fila][columna].setValor(valor);
    }
    
    public int getValorCelda(int fila, int columna) {
        return celdas[fila][columna].getValor();
    }
    
    public int sumarCeldas(int fila1, int columna1, int fila2, int columna2) {
        return celdas[fila1][columna1].getValor() + celdas[fila2][columna2].getValor();
    }
    
    public int multiplicarCeldas(int fila1, int columna1, int fila2, int columna2) {
        return celdas[fila1][columna1].getValor() * celdas[fila2][columna2].getValor();
    }
}

class Celda {
    private int valor;
    
    public Celda() {
        valor = 0;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
}