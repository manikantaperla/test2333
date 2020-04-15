package com.capgemini.recpclient.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class RecipeUtils {
	
	
	public static String getAcceptedDate(){
       
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = new Date();
		
        return dateFormat.format(date);
    }

}
