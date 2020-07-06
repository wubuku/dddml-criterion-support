package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that combines two <see cref="Criterion"/>s
 with a operator (either "<c>and</c>" or "<c>or</c>") between them.
 
*/
public abstract class LogicalExpression extends AbstractCriterion implements Serializable
{
	private Criterion _lhs;
	private Criterion _rhs;

	/** 
	 Initialize a new instance of the <see cref="LogicalExpression" /> class that
	 combines two other <see cref="Criterion"/>s.
	 
	 @param lhs The <see cref="Criterion"/> to use in the Left Hand Side.
	 @param rhs The <see cref="Criterion"/> to use in the Right Hand Side.
	*/
	protected LogicalExpression(Criterion lhs, Criterion rhs)
	{
		_lhs = lhs;
		_rhs = rhs;
	}

	/** 
	 Gets the <see cref="Criterion"/> that will be on the Left Hand Side of the Op.
	 
	*/
	public final Criterion getLeftHandSide()
	{
		return _lhs;
	}

	/** 
	 Gets the <see cref="Criterion" /> that will be on the Right Hand Side of the Op.
	 
	*/
	public final Criterion getRightHandSide()
	{
		return _rhs;
	}

	/** 
	 Get the Sql operator to put between the two <see cref="Expression"/>s.
	 
	*/
	public abstract String getOp();

	/** 
	 Gets a string representation of the LogicalExpression.  
	 
	 @return 
	 The String contains the LeftHandSide.toString() and the RightHandSide.toString()
	 joined by the Op.
	 
	 
	 This is not a well formed Sql fragment.  It is useful for logging what Expressions
	 are being combined.
	 
	*/
	@Override
	public String toString()
	{
		return '(' + _lhs.toString() + ' ' + getOp() + ' ' + _rhs.toString() + ')';
	}

}