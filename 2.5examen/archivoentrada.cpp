#include <iostream>
using namespace std;

// Comentario de una línea

/* Comentario
   de varias líneas */

class Prueba {
private:
    int x = 10;
    float y = 3.14f;
    double z = 2.5e3;

public:
    Prueba() {
        x++;
    }

    void funcion() {
        if (x > 0 && y != 0.0) {
            cout << "Hola mundo" << endl;
        } else {
            cout << "Error" << endl;
        }
    }
};

int main() {

    int a = 100;
    long b = 123456L;
    int bin = 0b1010;
    int hex = 0x1A3F;
    int oct = 077;

    float f = 10.5f;
    double d = 20.3e-2;

    char c = 'A';
    string s = "Texto con \\n salto";

    for (int i = 0; i < 10; i++) {
        a += i;
    }

    while (a > 0) {
        a--;
    }

    return 0;
}
