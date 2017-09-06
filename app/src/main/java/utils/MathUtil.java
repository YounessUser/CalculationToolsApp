package utils;

import java.math.BigDecimal;

/**
 * Created by ammach on 8/1/2016.
 */
public class MathUtil {

    public static BigDecimal calculerMax(BigDecimal[][] resultas) {
        BigDecimal max = new BigDecimal(0);
        max = resultas[0][0];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (max.compareTo(resultas[i][j]) == -1) {
                    max = resultas[i][j];
                    System.out.println("max = " + max);
                }
            }
        }
        return max;
    }
}
