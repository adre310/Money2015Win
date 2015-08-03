/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

/**
 *
 * @author aisaev
 */
public class CurrencyUtil {
    public static final String[] MonthNameLong;

    static {
        MonthNameLong=new String[12];
        SimpleDateFormat sdf=new SimpleDateFormat("MMMM");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);

        for(int m=0;m<12;m++) {
            calendar.set(Calendar.MONTH,m);
            MonthNameLong[m]=sdf.format(calendar.getTime());
        }
    }
    /*
     * @param value - convert value
     * $param code - Curremcy code (USA, EUR ...)
     * 
     * $return string result convert value to currency in current locale 
     */
    public static String currencyToString(Double Value, String Code) {
        if (Code == "") {
            return "";
        } else {
            NumberFormat curFormat = NumberFormat.getCurrencyInstance();
            curFormat.setCurrency(Currency.getInstance(Code));
            return curFormat.format(Value);
        }
    }
    
}
