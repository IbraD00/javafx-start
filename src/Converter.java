/**
 * Created by IbraD00 on 24/02/2016.
 */
public class Converter {

    public static double convertToCelsius(double fahrenheit)
    {
        double result = (fahrenheit - 32) / 1.8;

        return result;
    }

    public static double convertToFahrenheit(double celsius)
    {
        double result = celsius * 1.8 + 32;

        return result;
    }
}
