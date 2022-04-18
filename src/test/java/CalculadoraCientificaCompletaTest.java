import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraCientificaCompletaTest {
    private double a,b,c;
    private double discriminantExpected;
    private double x1, y1, x2, y2;
    private double gradientExpected;

    @BeforeEach
    public void init() {
        a = 1;
        b = -5;
        c = 6;
        x1 = 2;
        y1 = 5;
        x2 = 2;
        y2 =7;

        discriminantExpected = 1;
        gradientExpected = 0;
    }

    @Test
    public void calculateDiscriminantTest() {
        double discriminantObtained = CalculadoraCientificaCompleta.calculateDiscriminant(a, b, c);
        assertEquals(discriminantExpected, discriminantObtained);
    }

    @Test
    public void calculateGradientTest() {
        double gradientObtained = CalculadoraCientificaCompleta.calculateGradient(x1, x2, y1, y2);
        assertEquals(gradientExpected, gradientObtained);
    }
}
