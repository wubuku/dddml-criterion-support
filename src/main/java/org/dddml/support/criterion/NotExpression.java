package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that negates another <see cref="Criterion"/>.
 
*/
public class NotExpression extends AbstractCriterion implements Serializable
{
	private Criterion _criterion;

	/** 
	 Initialize a new instance of the <see cref="NotExpression" /> class for an
	 <see cref="Criterion"/>
	 
	 @param criterion The <see cref="Criterion"/> to negate.
	*/
	public NotExpression(Criterion criterion)
	{
		_criterion = criterion;
	}

	public final Criterion getCriterion()
	{
		return _criterion;
	}

	@Override
	public String toString()
	{
		return String.format("not (%1$s)", _criterion.toString());
	}

}