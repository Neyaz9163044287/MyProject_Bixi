package com.bixi.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtlis 
{
		/**
		 * This method is used to get the random number
		 * @author Neyaz
		 * @return
		 */
		public int getRandomNo()
		{
			Random ran = new Random();
			int random = ran.nextInt(500);
			return random;
		}
		
		/**
		 * This method is used to get the system date
		 * @author Neyaz
		 * @return
		 */
		public String systemDate() 
		{
			Date date = new Date();
			String systemdate = date.toString();
			return systemdate;
		}
		
		/**
		 * This method is used to get the date in the given format
		 * @author Neyaz
		 * @return
		 */
		public String systemDateInFormat() 
		{	
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
			Date date = new Date();
			String systemDateInFormat = dateformat.format(date);
			return systemDateInFormat;			
		}

}
