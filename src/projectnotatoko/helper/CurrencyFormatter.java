package projectnotatoko.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CurrencyFormatter {
    static {
        DecimalFormat kursIndonesiaInit = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setGroupingSeparator('.');

        kursIndonesiaInit.setDecimalFormatSymbols(formatRp);
        kursIndonesia = kursIndonesiaInit;
    }

    private static final DecimalFormat kursIndonesia;

    public static String format(int input) {
        return kursIndonesia.format(input);
    }
}
