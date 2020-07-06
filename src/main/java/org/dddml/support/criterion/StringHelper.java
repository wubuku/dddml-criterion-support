package org.dddml.support.criterion;

public final class StringHelper
{

	/** 
	*/
	public static final String CommaSpace = ", ";

	public static String nullEmptyString(String s)
	{
		if (!isNullOrEmpty(s))
		{
			return s;
		}
		return null;
	}

	//------------------------------------------------------------------------------------
	//	This method replaces the .NET static string method 'IsNullOrEmpty'.
	//------------------------------------------------------------------------------------
	public static boolean isNullOrEmpty(String string)
	{
		return string == null || string.equals("");
	}

	//C# TO JAVA : Extension methods are not available in Java:
	//ORIGINAL LINE: public static string FormatWith(this string format, IFormatProvider provider, object arg0)
	//	public static String FormatWith(String format, IFormatProvider provider, Object arg0)
	//	{
	//		return format.FormatWith(provider, new Object[] { arg0 });
	//	}

	public static String join(String separator, Iterable objects)
	{
		StringBuilder buf = new StringBuilder();
		boolean first = true;

		for (Object obj : objects)
		{
			if (!first)
			{
				buf.append(separator);
			}

			first = false;
			buf.append(obj);
		}

		return buf.toString();
	}

	/** @return 
	*/
	public static String toString(Object[] array)
	{
		int len = array.length;

		// if there is no value in the array then return no string...
		if (len == 0)
		{
			return "";
		}

		StringBuilder buf = new StringBuilder(len * 12);
		for (int i = 0; i < len - 1; i++)
		{
			buf.append(nullSafeToString(array[i])).append(CommaSpace);
		}
		return buf.append(nullSafeToString(array[len - 1])).toString();
	}


	private static String nullSafeToString(Object obj)
	{
		return obj == null ? "(null)" : obj.toString();
	}


	/** 
	 
	 
	 @param qualifiedName
	 @return 
	*/
	public static String unqualify(String qualifiedName)
	{
		if (qualifiedName.indexOf('`') > 0)
		{
			// less performance but correctly manage generics classes
			// where the entity-name was not specified
			// Note: the enitty-name is mandatory when the user want work with different type-args
			// for the same generic-entity implementation
			return getClassname(qualifiedName);
		}
		return unqualify(qualifiedName, ".");
	}

	/** 
	 
	 
	 @param qualifiedName
	 @param seperator
	 @return 
	*/
	public static String unqualify(String qualifiedName, String seperator)
	{
		return qualifiedName.substring(qualifiedName.lastIndexOf(seperator) + 1);
	}

	/** 
	 Takes a fully qualified type name (can include the assembly) and just returns
	 the name of the Class.
	 
	 @param typeName
	 @return 
	*/
	public static String getClassname(String typeName)
	{
		//string[] splitClassname = GetFullClassname(typeName).Split('.');
		String fullClassName = typeName; //GetFullClassname(typeName);

		int genericTick = fullClassName.indexOf('`');
		if (genericTick != -1)
		{
			String nameBeforeGenericTick = fullClassName.substring(0, genericTick);
			int lastPeriod = nameBeforeGenericTick.lastIndexOf('.');
			return lastPeriod != -1 ? fullClassName.substring(lastPeriod + 1) : fullClassName;
		}
		String[] splitClassname = fullClassName.split("[.]", -1);
		return splitClassname[splitClassname.length - 1];
	}


	///// <summary>
	///// Takes a fully qualified type name and returns the full name of the 
	///// Class - includes namespaces.
	///// </summary>
	///// <param name="typeName"></param>
	///// <returns></returns>
	//public static string GetFullClassname(string typeName)
	//{
	//    return new TypeNameParser(null, null).ParseTypeName(typeName).Type;
	//}

}