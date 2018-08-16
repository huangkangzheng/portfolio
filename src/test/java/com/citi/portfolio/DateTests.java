package com.citi.portfolio;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.citi.portfoliomanager.constant.SystemDate;

public class DateTests {
	    @Test
	    public void dateTest() {
	    	System.out.println(SystemDate.getSysDate());
	    	SystemDate.dayPass();
	    	System.out.println(SystemDate.getSysDate());
		    //assertEquals(SystemDate.getSysDate(),new Date(2017-1900,0,2));
	    }
	    
	    @Ignore
	    @Test
	    public void reSetDate() {
	    	SystemDate.reSetSysDate(2017, 1, 1);
	    }
}
