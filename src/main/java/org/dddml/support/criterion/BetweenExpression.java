package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that represents a "between" constraint.
 
*/
public class BetweenExpression extends AbstractCriterion implements Serializable
{
	private Object _hi;
	private Object _lo;

	private String _propertyName;

	/** 
	 Initialize a new instance of the <see cref="BetweenExpression" /> class for
	 the named Property.
	 
	 @param propertyName The name of the Property of the Class.
	 @param lo The low value for the BetweenExpression.
	 @param hi The high value for the BetweenExpression.
	*/
	public BetweenExpression(String propertyName, Object lo, Object hi)
	{
		_propertyName = propertyName;
		_lo = lo;
		_hi = hi;
	}

	public final String getPropertyName()
	{
		return _propertyName;
	}

	public final Object getHi()
	{
		return _hi;
	}

	public final Object getLo()
	{
		return _lo;
	}

	@Override
	public String toString()
	{
		return _propertyName + " between " + _lo + " and " + _hi;
	}
}