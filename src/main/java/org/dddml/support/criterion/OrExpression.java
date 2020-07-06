package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion" /> that combines two <see cref="Criterion"/>s with an
 <c>"or"</c> between them.
 
*/
public class OrExpression extends LogicalExpression implements Serializable
{
	/** 
	 Initialize a new instance of the <see cref="OrExpression" /> class for 
	 two <see cref="Criterion"/>s.
	 
	 @param lhs The <see cref="Criterion"/> to use as the left hand side.
	 @param rhs The <see cref="Criterion"/> to use as the right hand side.
	*/
	public OrExpression(Criterion lhs, Criterion rhs)
	{
		super(lhs, rhs);
	}

	/** 
	 Get the Sql operator to put between the two <see cref="Expression"/>s.
	 
	 <value>Returns "<c>or</c>"</value>
	*/
	@Override
	public String getOp()
	{
		return "or";
	}
}