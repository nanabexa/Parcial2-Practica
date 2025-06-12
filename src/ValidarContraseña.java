import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ValidarContraseña {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String contrasena;
        boolean esValida;

        do {
            System.out.print("Ingrese una contraseña (mínimo 8 caracteres, al menos un número y una mayúscula): ");
            contrasena = br.readLine();
            esValida = true;

            if (contrasena.length() < 8) {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
                esValida = false;
            }
            if (!contrasena.matches(".*\\d.*")) {
                System.out.println("La contraseña debe contener al menos un número.");
                esValida = false;
            }
            if (!contrasena.matches(".*[A-Z].*")) {
                System.out.println("La contraseña debe contener al menos una letra mayúscula.");
                esValida = false;
            }

        } while (!esValida);

        System.out.println("Contraseña válida.");
    }
}

