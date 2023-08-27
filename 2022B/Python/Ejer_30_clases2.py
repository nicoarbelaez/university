from lzma import MODE_FAST
from os import system


class Lampara:
    ESTADOS = ['''        
             .
        .    |    .
         \   '   /
          ' .-. '
      ---- (   ) ----
            \ /
           _|=|_
          |_____|
    ''', '''
    


            .-.
           (   )
            \ /
           _|=|_
          |_____|
    ''']
    def __init__(self, esta_encendida):
        # self.esta_encendida es una variable global
        # esta_encendida es una variable local
        self.esta_encendida = esta_encendida

    def Mostar_Lampara(self):
        if self.esta_encendida:
            print(self.ESTADOS[0])
        else:
            print(self.ESTADOS[1])

    def Encender(self):
        self.esta_encendida = True
        self.Mostar_Lampara()

    def Apagar(self):
        self.esta_encendida = False
        self.Mostar_Lampara()

lampara = Lampara(False)
menu = '''>>> Menu <<<
[1] Encender lampara
[2] Apagar lampara
[0] Salir'''
while True:
    print(menu)
    opcion = int(input("==> "))
    system("cls")
    if opcion == 1:
        lampara.Encender()
    elif opcion == 2:
        lampara.Apagar()
    else:
        break