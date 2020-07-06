package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that constrains the property
 to a specified list of values.
 
 
 InExpression - should only be used with a Single Value column - no multicolumn properties...
 
*/
public class InExpression extends AbstractCriterion implements Serializable
{

	private String _propertyName;
	private Object[] _values;


	public InExpression(String propertyName, Object[] values)
	{
		_propertyName = propertyName;
		_values = values;
	}

	public final Object[] getValues()
	{
		return _values;
	}

	protected final void setValues(Object[] value)
	{
		_values = value;
	}

	public final String getPropertyName()
	{
		return _propertyName;
	}

	@Override
	public String toString()
	{
		return _propertyName + " in (" + StringHelper.toString(_values) + ')';
	}
}