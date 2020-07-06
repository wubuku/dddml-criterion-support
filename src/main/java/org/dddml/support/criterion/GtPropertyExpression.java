package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that represents an "greater than" constraint
 between two properties.
 
*/
public class GtPropertyExpression extends PropertyExpression implements Serializable
{

	/** 
	 Initializes a new instance of the <see cref="GtPropertyExpression"/> class
	 that compares two mapped properties using an "greater than" constraint.
	 
	 @param lhsPropertyName The name of the Property to use as the left hand side.
	 @param rhsPropertyName The name of the Property to use as the right hand side.
	*/
	public GtPropertyExpression(String lhsPropertyName, String rhsPropertyName)
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
		return " > ";
	}
}