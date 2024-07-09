import java.util.Scanner;

public class Convertidor {

    public void convertir(Moneda moneda) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Cuantos [" + moneda.base_code() + "] desea convertir en [" + moneda.target_code() + "]:");
        double cuandoDinero = entrada.nextDouble();

        double conversionDeMonedas = cuandoDinero * moneda.conversion_rate();
        System.out.printf("Tus %.2f [%s] son %.2f [%s].%n", cuandoDinero, moneda.base_code(), conversionDeMonedas, moneda.target_code());
    }

}
