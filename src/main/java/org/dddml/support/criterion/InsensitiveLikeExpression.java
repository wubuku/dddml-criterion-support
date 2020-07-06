package org.dddml.support.criterion;

import java.io.Serializable;

public class InsensitiveLikeExpression extends AbstractCriterion implements Serializable
{
	private String _propertyName;

	private Object _value;


	/** 
	 Initialize a new instance of the <see cref="InsensitiveLikeExpression" /> 
	 class for a named Property and its value.
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public InsensitiveLikeExpression(String propertyName, Object value)
	{
		this._propertyName = propertyName;
		this._value = value;
	}

	public final String getPropertyName()
	{
		return _propertyName;
	}

	public final Object getValue()
	{
		return _value;
	}

	@Override
	public String toString()
	{
		return _propertyName + " ilike " + _value;
	}
}