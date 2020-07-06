package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that represents an "equal" constraint
 between two properties.
 
*/
public class EqPropertyExpression extends PropertyExpression implements Serializable
{


	/** 
	 Initializes a new instance of the <see cref="EqPropertyExpression"/> class
	 that compares two mapped properties using an "equal" constraint.
	 
	 @param lhsPropertyName The name of the Property to use as the left hand side.
	 @param rhsPropertyName The name of the Property to use as the right hand side.
	*/
	public EqPropertyExpression(String lhsPropertyName, String rhsPropertyName)
	{
		super(lhsPropertyName, rhsPropertyName);
	}

	/** 
	 Get the Sql operator to use for the <see cref="EqPropertyExpression"/>.
	 
	 <value>The string "<c> = </c>"</value>
	*/
	@Override
	public String getOp()
	{
		return " = ";
	}


}