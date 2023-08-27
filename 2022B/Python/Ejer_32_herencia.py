from Ejer_31_Metodos_especiales import Fraccion

class FraccionMix(Fraccion):
    def __init__(self, ent, num=0, den=1):
        self.ent = ent
        super().__init__(num, den)
        self.simplifica()
        super().simplifica()

    def __str__(self):
        return str(self.ent) + super().__str__()

    def simplifica(self):
        if self.num > self.den:
            aux = self.num // self.den
            self.ent = self.ent + aux
            self.num -= (aux * self.den)

    def __add__(self, numero):
        ent = self.ent + numero.ent
        f = super().__add__(numero)
        return FraccionMix(ent, f.num, f.den)

a = FraccionMix(4,8,6)
b = FraccionMix(3,7,4)
print("Herencia: ", a + b)