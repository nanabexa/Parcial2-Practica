import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RegistroTemperaturas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dias = 0;
        double temperatura;
        double maxTemp = -51; // menor que el mínimo permitido para asegurar actualización
        double minTemp = 61;  // mayor que el máximo permitido
        double sumaTemp = 0;

        // Solicitar cantidad de días
        while (true) {
            System.out.print("Ingrese la cantidad de días para registrar temperaturas: ");
            try {
                dias = Integer.parseInt(br.readLine());
                if (dias <= 0) {
                    System.out.println("Debe ingresar un número positivo mayor que cero.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }

        // Registrar temperaturas
        for (int i = 1; i <= dias; i++) {
            while (true) {
                System.out.print("Temperatura día " + i + " (-50 a 60 °C): ");
                try {
                    temperatura = Double.parseDouble(br.readLine());
                    if (temperatura < -50 || temperatura > 60) {
                        System.out.println("Temperatura fuera del rango válido.");
                    } else {
                        // actualizar max, min, suma
                        if (temperatura > maxTemp) maxTemp = temperatura;
                        if (temperatura < minTemp) minTemp = temperatura;
                        sumaTemp += temperatura;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número válido para la temperatura.");
                }
            }
        }

        double promedio = sumaTemp / dias;
        System.out.println("\nResumen de temperaturas:");
        System.out.println("Máxima: " + maxTemp + " °C");
        System.out.println("Mínima: " + minTemp + " °C");
        System.out.println("Promedio: " + String.format("%.2f", promedio) + " °C");
    }
}
