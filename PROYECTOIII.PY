class TablaHash:
    def __init__(self, tamano=10):
        self.tamano = tamano
        self.tabla = [[] for _ in range(tamano)]

    def funcion_hash(self, clave):
        return sum(ord(caracter) for caracter in clave) % self.tamano

    def insertar(self, clave):
        indice_hash = self.funcion_hash(clave)
        self.tabla[indice_hash].append(clave)

    def obtener_tabla(self):
        return self.tabla


import tkinter as tk
from modelo import TablaHash

class AplicacionTablaHash:
    def __init__(self, root):
        self.root = root
        self.root.title("Tabla Hash")

        self.tabla_hash = TablaHash()

        self.entradas = [tk.Entry(root) for _ in range(10)]
        for i, entrada in enumerate(self.entradas):
            entrada.grid(row=i, column=0)

        self.boton_insertar = tk.Button(root, text="Insertar", command=self.insertar_datos)
        self.boton_insertar.grid(row=10, column=0)

        self.etiquetas_resultado = [[tk.Label(root, text="") for _ in range(10)] for _ in range(10)]
        for i in range(10):
            for j in range(10):
                self.etiquetas_resultado[i][j].grid(row=i, column=j+1)

    def insertar_datos(self):
        for entrada in self.entradas:
            datos = entrada.get()
            if datos:
                self.tabla_hash.insertar(datos)
        
        self.actualizar_tabla()

    def actualizar_tabla(self):
        tabla = self.tabla_hash.obtener_tabla()
        for i in range(10):
            for j in range(10):
                if j < len(tabla[i]):
                    self.etiquetas_resultado[i][j].config(text=tabla[i][j])
                else:
                    self.etiquetas_resultado[i][j].config(text="")

if __name__ == "__main__":
    root = tk.Tk()
    app = AplicacionTablaHash(root)
    root.mainloop()