package utils;

import java.text.NumberFormat;
import java.util.Locale;

public final class Format {
    public static String formatMoney(Long money) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(money * 1000);
        return price;
    }
}
