package com.sanisidro.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DateConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str)
	{
		try
		{
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date)formatter.parse(str);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		}
		catch (Exception e)
		{
			throw new ConverterException();
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object)
	{
		Calendar calendar = (Calendar)object;
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		String strDay = "" + day;
		String strMonth = "" + month;
		if (day < 10) {
			strDay = "0" + strDay;
		}
		if (month < 10) {
			strMonth = "0" + strMonth;
		}
		return "" + strDay + "/" + strMonth + "/" + calendar.get(Calendar.YEAR);
	}
}