package org.dddml.support.criterion;

import java.io.Serializable;

/**
 Superclass for an <see cref="Criterion"/> that represents a
 constraint between two properties (with SQL binary operators).
 
*/
public abstract class PropertyExpression extends AbstractCriterion implements Serializable
{
	private String _lhsPropertyName;
	private String _rhsPropertyName;

	/** 
	 Initializes a new instance of the <see cref="PropertyExpression"/> class.
	 
	 @param lhsPropertyName Name of the LHS property.
	 @param rhsPropertyName Name of the RHS property.
	*/
	protected PropertyExpression(String lhsPropertyName, String rhsPropertyName)
	{
		this._lhsPropertyName = lhsPropertyName;
		this._rhsPropertyName = rhsPropertyName;
	}

	/** 
	*/
	@Override
	public String toString()
	{
		return _lhsPropertyName + getOp() + _rhsPropertyName;
	}

	public final String getLhsPropertyName()
	{
		return _lhsPropertyName;
	}

	public final String getRhsPropertyName()
	{
		return _rhsPropertyName;
	}

	/** 
	 Get the Sql operator to use for the property expression.
	 
	*/
	public abstract String getOp();

}