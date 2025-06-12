import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class PrestamosBancarios {
        public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int totalClientes = 0;
            int totalAprobados = 0;
            int hombresAprobados = 0;
            int mujeresAprobadas = 0;
            double totalPrestamos = 0.0;
            final double META = 1_000_000.00;

            System.out.println("=== SISTEMA DE PRÉSTAMOS BANCARIOS ===");

            while (totalPrestamos < META) {
                try {
                    System.out.println("\nIngrese los datos del cliente:");

                    System.out.print("Nombre: ");
                    String nombre = reader.readLine().trim();// Aún se pide pero no se guarda
                    if (!nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]{2,}$")) {
                        throw new IllegalArgumentException("Nombre inválido. Debe contener solo letras y al menos dos caracteres.");
                    }

                    System.out.print("Sexo (M/F): ");
                    String sexo = reader.readLine().trim().toUpperCase();
                    if (!sexo.equals("M") && !sexo.equals("F")) {
                        throw new IllegalArgumentException("Sexo inválido. Debe ingresar 'M' o 'F'.");
                    }

                    System.out.print("Salario (B/.): ");
                    double salario = Double.parseDouble(reader.readLine().trim());
                    if (salario <= 0) {
                        throw new IllegalArgumentException("El salario debe ser positivo.");
                    }

                    System.out.print("Monto del préstamo solicitado (entre 25000 y 400000): ");
                    double monto = Double.parseDouble(reader.readLine().trim());
                    if (monto < 25000 || monto > 400000) {
                        throw new IllegalArgumentException("Monto fuera del rango permitido.");
                    }

                    totalClientes++;

                    if (salario > 800) {
                        if (monto >= 25000 && monto <= 400000) {
                            if (totalPrestamos + monto <= META) {
                                System.out.println("✅ Préstamo aprobado.");
                                totalAprobados++;
                                totalPrestamos += monto;

                                if (sexo.equals("M")) {
                                    hombresAprobados++;
                                } else {
                                    mujeresAprobadas++;
                                }
                            } else {
                                System.out.println("❌ Préstamo no aprobado: excede el límite de B/. 1,000,000.00.");
                            }
                        } else {
                            System.out.println("❌ Monto fuera del rango permitido (25,000 - 400,000).");
                        }
                    } else {
                        System.out.println("❌ Préstamo no aprobado: salario insuficiente.");
                    }


                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: ingrese un número válido.");
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("❌ Error de entrada: " + e.getMessage());
                }
            }

            // Mostrar resumen final
            System.out.println("\n=== RESUMEN DEL DÍA ===");
            System.out.println("Clientes tramitados: " + totalClientes);
            System.out.println("Préstamos aprobados: " + totalAprobados);
            System.out.println("Monto total aprobado: B/. " + String.format("%.2f", totalPrestamos));
            System.out.println("Hombres aprobados: " + hombresAprobados);
            System.out.println("Mujeres aprobadas: " + mujeresAprobadas);
        }
    }


