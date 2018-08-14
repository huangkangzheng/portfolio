package com.citi.portfoliomanager.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.portfoliomanager.constant.ProductType;
import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.service.IService.IPullHistoryDataService;

@Service
public class PullHistoryDataService implements IPullHistoryDataService{
	Logger logger=LogManager.getLogger(PullHistoryDataService.class.getName());
	//private static String dataRealPath="G:\\Portfolio Data\\data";
	  DecimalFormat format = new DecimalFormat(",#.#");
	 @Autowired
	 private ProductHistoryMapper productHistoryMapper;
	 
	@Override
	public void pullDataToDB(String dataRealPath) {
		// TODO Auto-generated method stub
		
		File data=new File(dataRealPath);
		for(File catalog:data.listFiles()) {
			if(!catalog.isDirectory()) {
				continue;
			}
			String[]typeNames=catalog.getPath().split("\\\\");
			
	        String typeName=typeNames[typeNames.length-1];
	    ProductType type=null;	
		try {
			type=ProductType.valueOf(typeName);
		}catch(IllegalArgumentException|NullPointerException ex){
			logger.error("unknown the product type: "+typeName);
		}
			if(type!=null) {
				for(File item:catalog.listFiles()) {
					String[]itemTypeNames=item.getPath().split("\\\\");
					 String itemTypeName=itemTypeNames[itemTypeNames.length-1];
					 if(itemTypeName.charAt(0)==' '||itemTypeName.charAt(0)=='.') {
						 continue;
					 }
				   try {
					 pullDataToDB(itemTypeName.split("\\.")[0], type.ordinal(), item);
				   }catch(Exception e) {
					   System.out.println(itemTypeName);
				   }
				}
			}
		}
	 }
	
	
	
	@Override
	public boolean pullDataToDB(String name, int type,File file) {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file)); 
			String tempString;
			String []head=reader.readLine().split("\",\"|\"");
			 while ((tempString = reader.readLine()) != null) {  
				   if(tempString==null||tempString.equals("")) {
					   continue;
				   }
	               String[]infos=tempString.split("\",\"|\"");
	               ProductHistory item=new ProductHistory();
	               item.setType(type);
	               item.setName(name);
	               for(int i=0;i<infos.length;i++) {
	            	   String info=infos[i];
	            	   if(info!=null&&!"".equals(info)) {
	            		   try {
	            		   switch(head[i]) {
	            		       case "Date":   
	            		    	  item.setGenerateDate(dateParser(info));
	            		    	  break;
	            		       case "Price":
	            		    	   item.setPrice(doubleParser(info));
	            		    	   break;
	            		       case "Open":
	            		    	  item.setOpen(doubleParser(info));
	            		    	  break;
	            		       case "Close":
		            		    	  item.setOpen(doubleParser(info));
		            		    	  break;
	            		       case "Low":
	            		    	   item.setLow(doubleParser(info));
	            		    	   break;
	            		       case "High":
	            		    	   item.setHigh(doubleParser(info));
	            		    	   break;
	            		       case "Vol.":
	            		    	   item.setVol(volParser(info));
	            		    	   break;
	            		       case "Change %":
	            		    	   item.setPriceChange(BigDecimal.valueOf(Double.valueOf(info.substring(0, info.length()-1))*0.01));
	            		    	   break;
	            		    	
	            		   }
	            		   
	            		   }catch(Exception ex) {
	            			   // logger.error("can not parse this value: "+info+ "about "+head[i]);
	            			   System.out.println("can not parse this value: "+info+ "about " +head[i]);
	            		   }
	            	   }
	            	   
	               }
	               productHistoryMapper.insert(item);
	            }  
		}catch(Exception e) {
		    return false;
		}
		return true;
	}

	private BigDecimal volParser(String price) {	
		BigDecimal bd;
		switch(price.charAt(price.length()-1)) {
		
		 case 'K':
		 case 'k':
			   bd=new BigDecimal(price.substring(0, price.length()-1));
		       return bd.multiply(BigDecimal.valueOf(1000));
		 case 'M':
		 case 'm':
			   bd=new BigDecimal(price.substring(0, price.length()-1));
		       return bd.multiply(BigDecimal.valueOf(1000000));
		 case 'B':
		 case 'b':
			 bd=new BigDecimal(price.substring(0, price.length()-1));
		       return bd.multiply(BigDecimal.valueOf(1000000000));
		 case '-':
			 return null;
		 default: 
			 return new BigDecimal(price.substring(0, price.length()));
		}
		
	}
	private static enum Month{zero,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec}
	
    private Date dateParser(String info) {
    	int month=Month.valueOf(info.substring(0, 3)).ordinal();
    	int day=Integer.valueOf(info.substring(4,6));
    	int year=Integer.valueOf(info.substring(8,12));
    	return new Date(year-1900,month-1,day);
    }
    
    private BigDecimal doubleParser(String info) {
    	return new BigDecimal(String.join("", info.split(",")));
    }
}
