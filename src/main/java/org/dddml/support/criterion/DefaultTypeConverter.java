package org.dddml.support.criterion;

import com.github.drapostolos.typeparser.TypeParser;
import com.strategicgains.util.date.Iso8601TimepointAdapter;

import java.text.ParseException;

public class DefaultTypeConverter implements TypeConverter {

    TypeParser typeParser;

    public DefaultTypeConverter() {
        this(TypeParser.newBuilder().build());
    }

    public DefaultTypeConverter(TypeParser typeParser) {
        this.typeParser = typeParser;
    }


    @Override
    public String convertToString(Object value) {
        if (value == null) {
            return null;
        }
        Class objType = value.getClass();
        return convertToString(objType, value);
    }

    @Override
    public String[] convertToStringArray(Object[] values) {
        java.util.ArrayList<String> list = new java.util.ArrayList<String>();
        for (Object o : values) {
            list.add(convertToString(o));
        }
        return list.toArray(new String[]{});
    }

    @Override
    public Object convertFromString(java.lang.Class type, String text) {
        if (isSqlTimestampType(type)) {
            return convertSqlTimestampFromString(type, text);
        }
        if (isDateTimeType(type)) {
            return convertDateTimeFromString(type, text);
        }
        return typeParser.parseType(text, type);
    }

    protected String convertToString(java.lang.Class type, Object value) {
        if (isSqlTimestampType(type)) {
            return convertSqlTimestampToString(value);
        }
        if (isDateTimeType(type)) {
            return convertDateTimeToString(value);
        }
        return value.toString();
    }


    protected boolean isDateTimeType(java.lang.Class objectType) {
        return objectType == java.util.Date.class;
    }

    protected String convertDateTimeToString(Object value) {
        if (value instanceof java.util.Date) {
            return (new Iso8601TimepointAdapter()).format((java.util.Date) value);
        }
        throw new UnsupportedOperationException();
    }

    public Object convertDateTimeFromString(java.lang.Class objectType, String text) {
        if (objectType.equals(java.util.Date.class)) {
            try {
                return (new Iso8601TimepointAdapter()).parse(text);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        throw new UnsupportedOperationException();
    }

    protected boolean isSqlTimestampType(java.lang.Class objectType) {
        return objectType == java.sql.Timestamp.class;
    }

    protected String convertSqlTimestampToString(Object value) {
        if (value instanceof java.sql.Timestamp) {
            return String.valueOf(((java.sql.Timestamp) value).getTime());
        }
        throw new UnsupportedOperationException();
    }

    public Object convertSqlTimestampFromString (java.lang.Class objectType, String text) {
        if (objectType.equals(java.sql.Timestamp.class)) {
            return (new java.sql.Timestamp(Long.parseLong(text)));
        }
        throw new UnsupportedOperationException();
    }

}