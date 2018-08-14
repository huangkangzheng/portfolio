package com.citi.portfoliomanager.constant;

import java.util.Calendar;
import java.util.Date;
import java.util.prefs.Preferences;

public class SystemDate {
    private static Date sysDate;
    
    
	public static Date getSysDate() {
		if(sysDate==null) {
			Preferences pres= Preferences.userRoot().node("SystemDate");  
			int year=pres.getInt("year",2017);
			int month=pres.getInt("month",2);
			int day=pres.getInt("day",1);
			sysDate=new Date(year-1900,month-1,day);
		}
		return sysDate;
	}

	public static void dayPass() {
		Calendar cal=Calendar.getInstance();
		cal.setTime(getSysDate());
		cal.add(Calendar.DATE, 1);
		Preferences pres= Preferences.userRoot().node("SystemDate");
		sysDate=cal.getTime();
		pres.putInt("year", cal.get(Calendar.YEAR));
		pres.putInt("month", cal.get(Calendar.MONTH)+1);
		pres.putInt("day",cal.get(Calendar.DATE));
	}
	
	public static void reSetSysDate(int year,int month,int day) {
		Preferences pres= Preferences.userRoot().node("SystemDate");
		pres.putInt("year", year);
		pres.putInt("month", month);
		pres.putInt("day",day);
		sysDate=new Date(year-1900,month-1,day);
	}
       
}
