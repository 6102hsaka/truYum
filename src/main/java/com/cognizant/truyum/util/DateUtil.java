package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	public static Date convertToDate(String date)
	{
		Date dat=null;
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			dat=f.parse(date);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return dat;
	}
	
}
