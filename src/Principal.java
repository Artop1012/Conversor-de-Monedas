import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Moneda moneda;
        var consulta = new ConsultaConversorDeMoneda();
        Convertidor convertidor = new Convertidor();
        String menu = """
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso mexicano
                6) Peso mexicano ==> Dólar
                7) Dólar ==> Euro
                8) Euro ==> Dólar
                9) Salir
                """;

        while(true) {
            System.out.println("\n**********************************");
            System.out.println("Bienvenido al conversor de monedas\n");
            System.out.println(menu);

            try {
                System.out.println("Elija un opción: ");
                int opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        moneda = consulta.buscaConversion("USD", "ARS");
                        convertidor.convertir(moneda);
                        break;
                    case 2:
                        moneda = consulta.buscaConversion("ARS", "USD");
                        convertidor.convertir(moneda);
                        break;
                    case 3:
                        moneda = consulta.buscaConversion("USD", "BRL");
                        convertidor.convertir(moneda);
                        break;
                    case 4:
                        moneda = consulta.buscaConversion("BRL", "USD");
                        convertidor.convertir(moneda);
                        break;
                    case 5:
                        moneda = consulta.buscaConversion("USD", "MXN");
                        convertidor.convertir(moneda);
                        break;
                    case 6:
                        moneda = consulta.buscaConversion("MXN", "USD");
                        convertidor.convertir(moneda);
                        break;
                    case 7:
                        moneda = consulta.buscaConversion("USD", "EUR");
                        convertidor.convertir(moneda);
                        break;
                    case 8:
                        moneda = consulta.buscaConversion("EUR", "USD");
                        convertidor.convertir(moneda);
                        break;
                    case 9:
                        System.out.println("Saliendo del programa....");
                        break;
                    default:
                        System.out.println("Opción no valida. Intente nuevamente.");
                }

                if(opcion == 9) {
                    break;
                }

            }catch(InputMismatchException e) {
                System.out.println("Ingrese un número valido por favor.");
                System.out.println("Saliendo del programa....");
                break;
            }catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
                System.out.println("Saliendo del programa....");
                break;
            }
        }
    }
}
