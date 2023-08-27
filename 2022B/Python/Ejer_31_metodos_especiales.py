class Fraccion:
    # Constructor
    def __init__(self, num = 0, den = 1):
        if isinstance(num, int):
            self.num = num
        else:
            self.num = 0
        if isinstance(den, int) and den != 0:
            self.den = den
        else:
            self.den = 1

    # numero es la objeto que se envio
    def __add__(self, numero):
        num = (self.num * numero.den) + (self.den * numero.num)
        den = self.den * numero.den
        return Fraccion(num, den)

    def __sub__(self, numero):
        num = (self.num * numero.den) - (self.den * numero.num)
        den = self.den * numero.den
        return Fraccion(num, den)

    def __mul__(self, numero):
        num = self.num * numero.num
        den = self.den * numero.den
        return Fraccion(num, den)

    def __truediv__(self, numero):
        num = self.num * numero.den
        den = self.den * numero.num
        return Fraccion(num, den)

    def simplifica(self):
        mcd = self.mcd(self.num, self.den)
        self.num = int(self.num/mcd)
        self.den = int(self.den/mcd)

    def mcd(self, a, b):
        if b == 0:
            return a;
        else:
            return self.mcd(b, a%b)

    def __str__(self):
        self.simplifica()
        return '(' + str(int(self.num)) + "/" + str(int(self.den)) + ')'

a = Fraccion(6, 11)
b = Fraccion(2, 3)
print("Metodos especiales: ",  a + b)