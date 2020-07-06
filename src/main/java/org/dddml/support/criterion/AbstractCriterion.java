package org.dddml.support.criterion;

import java.io.Serializable;

/**
 Base class for <see cref="Criterion"/> implementations.
 
*/
public abstract class AbstractCriterion implements Criterion, Serializable
{
	/** 
	 Gets a string representation of the <see cref="AbstractCriterion"/>.  
	 
	 @return 
	 A String that shows the contents of the <see cref="AbstractCriterion"/>.
	 
	 
	 This is not a well formed Sql fragment.  It is useful for logging what the <see cref="AbstractCriterion"/>
	 looks like.
	 
	*/
	@Override
	public abstract String toString();

	///#region Criterion Members

	///// <summary>
	///// Render a SqlString for the expression.
	///// </summary>
	///// <returns>A SqlString that contains a valid Sql fragment.</returns>
	//public abstract SqlString ToSqlString(ICriteria criteria, ICriteriaQuery criteriaQuery, IDictionary<string, IFilter> enabledFilters);

	///// <summary>
	///// Return typed values for all parameters in the rendered SQL fragment
	///// </summary>
	///// <returns>An array of TypedValues for the Expression.</returns>
	//public abstract TypedValue[] GetTypedValues(ICriteria criteria, ICriteriaQuery criteriaQuery);

	///// <summary>
	///// Return all projections used in this criterion
	///// </summary>
	///// <returns>An array of IProjection used by the Expression.</returns>
	//public abstract IProjection[] GetProjections();


	///#endregion
	public static AbstractCriterion opBitwiseAnd(AbstractCriterion lhs, AbstractCriterion rhs)
	{
		return new AndExpression(lhs, rhs);
	}

	public static AbstractCriterion opBitwiseOr(AbstractCriterion lhs, AbstractCriterion rhs)
	{
		return new OrExpression(lhs, rhs);
	}


	//public static AbstractCriterion operator &(AbstractCriterion lhs, AbstractEmptinessExpression rhs)
	//{
	//    return new AndExpression(lhs, rhs);
	//}

	//public static AbstractCriterion operator |(AbstractCriterion lhs, AbstractEmptinessExpression rhs)
	//{
	//    return new OrExpression(lhs, rhs);
	//}


	public static AbstractCriterion opLogicalNot(AbstractCriterion crit)
	{
		return new NotExpression(crit);
	}

}