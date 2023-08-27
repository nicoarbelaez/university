class Fraccion:
    num = 0
    den = 1
    # Constructor
    def __init__(self, num, den):
        self.num = num
        self.den = den
    # numero es la objeto que se envio
    def multiplicar(self, numero):
        num = self.num * numero.num
        den = self.den * numero.den
        resp = Fraccion(num, den)
        return resp

    def dividir(self, numero):
        num = self.num * numero.den
        den = self.den * numero.num
        resp = Fraccion(num, den)
        return resp

    def sumar(self, numero):
        num = (self.num * numero.den) + (self.den * numero.num)
        den = self.den * numero.den
        resp = Fraccion(num, den)
        return resp

    def restar(self, numero):
        num = (self.num * numero.den) - (self.den * numero.num)
        den = self.den * numero.den
        resp = Fraccion(num, den)
        return resp

    def imprime(self):
        print(f"({self.num} / {self.den})")

a = Fraccion(3, 2)
b = Fraccion(7, 4)
c = Fraccion(2, 4)

r = a.restar(b)
r2 = r.sumar(c)
r2.imprime()