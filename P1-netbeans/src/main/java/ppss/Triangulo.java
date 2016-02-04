package ppss;


public class Triangulo {

    public String tipo_triangulo(int a, int b, int c) {
       String result=null;

        if ((a <1) && (a > 200)) {
            return result = "El valor a sobrepasa el rango permitido";
        }
        if ((b <1) && (b > 200)) {
            return result = "El valor b sobrepasa el rango permitido";
        }
        if ((c <1) && (c > 200)) {
            return result = "El valor c sobrepasa el rango permitido";
        }

        if (a >= (b+c)) {
            return result = "No es un triangulo";
        }

        if (b >= (a+c)) {
            return result = "No es un triangulo";
        }

        if (c >= (a+b)) {
            return result = "No es un triangulo";
        }

        if ((a != b) && (a!= c) && (b!= c)) {
            result = "Escaleno";
        } else {
            if (a==b) {
                if (a==c) {
                    result = "Equilatero";
                }
            } else {
                result = "Isosceles";
            }
        }
        return result;
    }

}
