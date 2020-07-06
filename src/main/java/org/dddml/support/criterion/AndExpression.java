package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="LogicalExpression"/> that combines two <see cref="Criterion"/>s
 with an <c>and</c> between them.
 
*/
public class AndExpression extends LogicalExpression implements Serializable
{
	/** 
	 Get the Sql operator to put between the two <see cref="Criterion"/>s.
	 
	 <value>The string "<c>and</c>"</value>
	*/
	@Override
	public String getOp()
	{
		return "and";
	}

	/** 
	 Initializes a new instance of the <see cref="AndExpression"/> class
	 that combines two <see cref="Criterion"/>.
	 
	 @param lhs The <see cref="Criterion"/> to use as the left hand side.
	 @param rhs The <see cref="Criterion"/> to use as the right hand side.
	*/
	public AndExpression(Criterion lhs, Criterion rhs)
	{
		super(lhs, rhs);
	}
}