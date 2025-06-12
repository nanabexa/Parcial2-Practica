import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ContarDigitos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numeroStr;
        int pares = 0, impares = 0;

        while (true) {
            System.out.print("Ingrese un número entero positivo: ");
            numeroStr = br.readLine();

            if (!numeroStr.matches("\\d+")) {
                System.out.println("Debe ingresar un número entero positivo válido.");
            } else {
                break;
            }
        }

        for (int i = 0; i < numeroStr.length(); i++) {
            int digito = Character.getNumericValue(numeroStr.charAt(i));
            if (digito % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        System.out.println("Cantidad de dígitos pares: " + pares);
        System.out.println("Cantidad de dígitos impares: " + impares);
    }
}
