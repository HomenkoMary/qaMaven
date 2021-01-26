package HomenkoMary;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TriangleTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    @DisplayName("Test Area Triangle")
    @ParameterizedTest
    @ValueSource(doubles = {3.897114317029974})
    public void areaTriangleTest(Double actual)
    {
        double expected = Triangle.calculateArea();

        assertEquals(expected, actual, 0);

    }
}
