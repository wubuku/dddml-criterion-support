package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that represents an "less than" constraint
 between two properties.
 
*/
public class LtPropertyExpression extends PropertyExpression implements Serializable
{

	/** 
	 Initializes a new instance of the <see cref="LtPropertyExpression"/> class
	 that compares two mapped properties using an "less than" constraint.
	 
	 @param lhsPropertyName The name of the Property to use as the left hand side.
	 @param rhsPropertyName The name of the Property to use as the right hand side.
	*/
	public LtPropertyExpression(String lhsPropertyName, String rhsPropertyName)
	{
		super(lhsPropertyName, rhsPropertyName);
	}

	/** 
	 Get the Sql operator to use for the <see cref="LtPropertyExpression"/>.
	 
	 <value>The string "<c> &lt; </c>"</value>
	*/
	@Override
	public String getOp()
	{
		return " < ";
	}
}