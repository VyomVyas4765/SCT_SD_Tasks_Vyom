import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select input temperature scale:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = sc.nextInt();

        System.out.print("Enter the temperature value: ");
        double temp = sc.nextDouble();

        switch (choice) {
            case 1:
                // Celsius to others
                System.out.println("Fahrenheit: " + celsiusToFahrenheit(temp) + " °F");
                System.out.println("Kelvin: " + celsiusToKelvin(temp) + " K");
                break;
            case 2:
                // Fahrenheit to others
                System.out.println("Celsius: " + fahrenheitToCelsius(temp) + " °C");
                System.out.println("Kelvin: " + fahrenheitToKelvin(temp) + " K");
                break;
            case 3:
                // Kelvin to others
                System.out.println("Celsius: " + kelvinToCelsius(temp) + " °C");
                System.out.println("Fahrenheit: " + kelvinToFahrenheit(temp) + " °F");
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }

    // Conversion formulas
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }
}
