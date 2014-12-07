/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author Reza Harli
 */
public class Tanggal {

    public static String getTanggalSekarang() {
        Calendar now = Calendar.getInstance();
        int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        String dayOfMonthStr = dayOfMonth + "";
        int month = now.get(Calendar.MONTH) + 1;
        String monthStr = ((month < 10) ? "0" : "") + month;
        return now.get(Calendar.YEAR) + "-" + monthStr + "-" + dayOfMonthStr;
    }

}
