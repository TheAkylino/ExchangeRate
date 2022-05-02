package com.example.uti;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpfulFunctions {

    public static String getTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
