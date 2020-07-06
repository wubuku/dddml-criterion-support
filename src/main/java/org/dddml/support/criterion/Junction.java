package org.dddml.support.criterion;

import java.io.Serializable;

/**
 A sequence of logical <see cref="Criterion"/>s combined by some associative
 logical operator.
 
*/
public abstract class Junction extends AbstractCriterion implements Serializable
{
	private final java.util.List<Criterion> _criteria = new java.util.ArrayList<Criterion>();

	/** 
	 Adds an <see cref="Criterion"/> to the list of <see cref="Criterion"/>s
	 to junction together.
	 
	 @param criterion The <see cref="Criterion"/> to add.
	 @return 
	 This <see cref="Junction"/> instance.
	 
	*/
	public final Junction add(Criterion criterion)
	{
		_criteria.add(criterion);
		return this;
	}

	public final java.util.List<Criterion> getCriteria()
	{
		return _criteria;
	}

	/** 
	 Get the Sql operator to put between multiple <see cref="Criterion"/>s.
	 
	*/
	public abstract String getOp();

	@Override
	public String toString()
	{
		return '(' + StringHelper.join(getOp(), _criteria) + ')';
	}

}