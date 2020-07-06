package org.dddml.support.criterion;

public interface TypeConverter
{
	Object convertFromString(java.lang.Class type, String text);

	String convertToString(Object value);

	String[] convertToStringArray(Object[] values);

}