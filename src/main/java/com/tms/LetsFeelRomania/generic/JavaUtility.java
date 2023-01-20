package com.tms.LetsFeelRomania.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class is to get random no and date
 * @author suman
 *
 */
public class JavaUtility {
	/**
	 * this method is to get random no
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	/**
	 * this method will give system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt=new Date();
		String date = dt.toString();
		return date;
	}
	
	public String getSysDateAndTime() {
		SimpleDateFormat dateformate = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
		Date sysdate=new Date();
		String getDateAndTime=dateformate.format(sysdate);
		return getDateAndTime.replaceAll(":", "-");
		
	}

}
