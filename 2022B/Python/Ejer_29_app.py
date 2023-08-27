from cgitb import text
from mimetypes import suffix_map
from tkinter import *
from tkinter.ttk import setup_master

# =============== OPCIONES ===============
app = Tk()
# Titulo de ventana
app.title("Sistema de riego y recolección de agua lluvia")
# Tamaño
app.geometry("600x300")
# Permite modificacion del tamaño
app.resizable(1, 1)
# Color
app.configure(background="black")
# =============== OPCIONES ===============
# =============== FUNCIONES ===============
def textoCaja():
    number1 = text1.get()
    number2 = text2.get()
    suma = float(number1) + float(number2)
    text3.insert(0,suma)
# =============== FUNCIONES ===============

label1 = Label(app, text="Numero 1").grid(row=0, column=0, pady=5, sticky="w")
text1 = Entry(app)
text1.grid(row=0, column=1, pady=10, padx=10)

label2 = Label(app, text="Numero 2").grid(row=1, column=0, sticky="w")
text2 = Entry(app)
text2.grid(row=1, column=1)

label3 = Label(app, text="Resultado").grid(row=2, column=0, pady=20, sticky="w")
text3 = Entry(app)
text3.grid(row=2, column=1)

boton1 = Button(app, text = "Sumar", command = textoCaja, relief = "flat")
boton1.grid(row=1, column=2, ipadx=10, ipady=10)

app.mainloop()