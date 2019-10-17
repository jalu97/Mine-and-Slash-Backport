package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import com.robertx22.mine_and_slash.uncommon.effectdatas.DamageEffect;

public class NumberUtils {
    private static String formatNumber(int number, int divided, String letter) {
        int amount = number / divided;
        int remaining = (number - (amount * divided));

        if (remaining > 0) {
            remaining /= (divided / 10);
        }

        String firstRemaining = (remaining + "").substring(0, 1);

        return amount + "." + firstRemaining + letter;
    }

    static int MILLS = 1000000;
    static int THOUSANDS = 1000;

    public static String formatNumber(float number) {
        return formatNumber((int) number);
    }

    public static String formatNumber(int number) {

        if (Math.abs(number / MILLS) >= 1) {
            return formatNumber(number, MILLS, "m");
        } else if (Math.abs(number / THOUSANDS) >= 1) {
            return formatNumber(number, THOUSANDS, "k");
        } else {
            return number + "";
        }

    }

    public static String formatDamageNumber(DamageEffect data, int val) {
        String num = formatNumber(val);

        if (data.crit) {
            num += "!";
        }

        return num;
    }

}
