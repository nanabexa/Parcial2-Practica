import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ValidarFecha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fecha;
        int dia, mes, anio;
        boolean esValida = false;

        while (!esValida) {
            System.out.print("Ingrese fecha de nacimiento (dd/mm/AAAA): ");
            fecha = br.readLine();
            String[] partes = fecha.split("/");

            if (partes.length != 3) {
                System.out.println("Formato incorrecto. Use dd/mm/AAAA.");
                continue;
            }

            try {
                dia = Integer.parseInt(partes[0]);
                mes = Integer.parseInt(partes[1]);
                anio = Integer.parseInt(partes[2]);

                if (anio < 1900 || anio > 2100) {
                    System.out.println("Año fuera de rango (1900-2100).");
                    continue;
                }

                if (mes < 1 || mes > 12) {
                    System.out.println("Mes inválido.");
                    continue;
                }

                if (dia < 1 || dia > diasEnMes(mes, anio)) {
                    System.out.println("Día inválido para el mes y año especificados.");
                    continue;
                }

                esValida = true;
                System.out.println("Fecha válida.");

            } catch (NumberFormatException e) {
                System.out.println("Día, mes o año no son números válidos.");
            }
        }
    }

    // Método para obtener la cantidad de días en un mes, considerando años bisiestos
    public static int diasEnMes(int mes, int anio) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;//Meses con 31 dias
            case 4: case 6: case 9: case 11:
                return 30;//meses con 30 dias
            case 2:
                if (esBisiesto(anio)) {//calcula si febrero es bisiesto o no
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    public static boolean esBisiesto(int anio) {
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            return true;
        }
        return false;
    }
}
