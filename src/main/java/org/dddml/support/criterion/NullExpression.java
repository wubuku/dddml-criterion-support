package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that represents "null" constraint.
 
*/
public class NullExpression extends AbstractCriterion implements Serializable
{
	private String _propertyName;

	/** 
	 Initialize a new instance of the <see cref="NotNullExpression" /> class for a named
	 Property that should be null.
	 
	 @param propertyName The name of the Property in the class.
	*/
	public NullExpression(String propertyName)
	{
		_propertyName = propertyName;
	}

	public final String getPropertyName()
	{
		return _propertyName;
	}

	/** 
	*/
	@Override
	public String toString()
	{
		return _propertyName + " is null";
	}
}