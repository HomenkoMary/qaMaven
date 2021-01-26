package HomenkoMary;

import java.text.DecimalFormat;

public class Triangle {

    public static double calculateArea()
    {
        double S = 0;
        double p = 0;
        double o = 0;

        double a = 3;
        double b = 3;
        double c = 3;

        p = (a + b + c) / 2; // 7

        o = (p * (p - a) * (p - b) * (p - c));

        S = Math.sqrt(o);

        return S;
    }

}
