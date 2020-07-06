package org.dddml.support.criterion;

import java.util.Map;

/**
 The <see cref="NHibernate.Criterion"/> namespace may be used by applications as a framework for building
 new kinds of <see cref="Criterion"/>.
 However, it is intended that most applications will
 simply use the built-in criterion types via the static factory methods of this class.

*/
public class Restrictions
{
	public static final String OP_EQ = "=";

	public static final String OP_GT = ">";

	public static final String OP_LT = "<";

	public static final String OP_GE = ">=";

	public static final String OP_LE = "<=";

	public static final String OP_LIKE = "like";

	public Restrictions()
	{
		//cannot be instantiated
	}

	///// <summary>
	///// Apply an "equal" constraint to the identifier property
	///// </summary>
	///// <param name="value"></param>
	///// <returns>Criterion</returns>
	//public static AbstractCriterion IdEq(object value)
	//{
	//    return new IdentifierEqExpression(value);
	//}

	///// <summary>
	///// Apply an "equal" constraint from the projection to the identifier property
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <returns>Criterion</returns>
	//public static AbstractCriterion IdEq(IProjection projection)
	//{
	//    return new IdentifierEqExpression(projection);
	//}

	/** 
	 Apply an "equal" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public static SimpleExpression eq(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " = ");
	}

	///// <summary>
	///// Apply an "equal" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	//public static SimpleExpression Eq(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " = ");
	//}

	/** 
	 Apply a "like" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	 @return A <see cref="LikeExpression" />.
	*/
	public static SimpleExpression like(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " like ");
	}

	//public static AbstractCriterion Like(string propertyName, string value, MatchMode matchMode, char? escapeChar)
	//{
	//    return new LikeExpression(propertyName, value, matchMode, escapeChar, false);
	//}

	///// <summary>
	///// Apply a "like" constraint to the project
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	///// <returns>A <see cref="LikeExpression"/>.</returns>
	//public static SimpleExpression Like(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " like ");
	//}

	///// <summary>
	///// Apply a "like" constraint to the project
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	///// <param name="matchMode">The match mode.</param>
	///// <returns>A <see cref="LikeExpression"/>.</returns>
	//public static SimpleExpression Like(IProjection projection, string value, MatchMode matchMode)
	//{
	//    return new SimpleExpression(projection, matchMode.ToMatchString(value), " like ");
	//}

	//public static SimpleExpression Like(string propertyName, string value, MatchMode matchMode)
	//{
	//    return new SimpleExpression(propertyName, matchMode.ToMatchString(value), " like ");
	//}

	//public static AbstractCriterion insensitiveLike(string propertyName, string value, MatchMode matchMode)
	//{
	//    return new InsensitiveLikeExpression(propertyName, value, matchMode);
	//}

	//public static AbstractCriterion insensitiveLike(IProjection projection, string value, MatchMode matchMode)
	//{
	//    return new InsensitiveLikeExpression(projection, value, matchMode);
	//}

	/** 
	 A case-insensitive "like", similar to Postgres "ilike" operator
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	 @return An <see cref="InsensitiveLikeExpression" />.
	*/
	public static AbstractCriterion insensitiveLike(String propertyName, Object value)
	{
		return new InsensitiveLikeExpression(propertyName, value);
	}

	///// <summary>
	///// A case-insensitive "like", similar to Postgres "ilike" operator
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	///// <returns>
	///// An <see cref="InsensitiveLikeExpression"/>.
	///// </returns>
	//public static AbstractCriterion insensitiveLike(IProjection projection, object value)
	//{
	//    return new InsensitiveLikeExpression(projection, value);
	//}

	/** 
	 Apply a "greater than" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public static SimpleExpression gt(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " > ");
	}

	///// <summary>
	///// Apply a "greater than" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	//public static SimpleExpression gt(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " > ");
	//}

	/** 
	 Apply a "less than" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public static SimpleExpression lt(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " < ");
	}


	///// <summary>
	///// Apply a "less than" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	//public static SimpleExpression lt(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " < ");
	//}

	/** 
	 Apply a "less than or equal" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public static SimpleExpression le(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " <= ");
	}

	///// <summary>
	///// Apply a "less than or equal" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	//public static SimpleExpression le(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " <= ");
	//}

	/** 
	 Apply a "greater than or equal" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	*/
	public static SimpleExpression ge(String propertyName, Object value)
	{
		return new SimpleExpression(propertyName, value, " >= ");
	}

	///// <summary>
	///// Apply a "greater than or equal" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="value">The value for the Property.</param>
	//public static SimpleExpression ge(IProjection projection, object value)
	//{
	//    return new SimpleExpression(projection, value, " >= ");
	//}


	/** 
	 Apply a "between" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param lo The low value for the Property.
	 @param hi The high value for the Property.
	 @return A <see cref="BetweenExpression" />.
	*/
	public static AbstractCriterion between(String propertyName, Object lo, Object hi)
	{
		return new BetweenExpression(propertyName, lo, hi);
	}

	///// <summary>
	///// Apply a "between" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="lo">The low value for the Property.</param>
	///// <param name="hi">The high value for the Property.</param>
	///// <returns>A <see cref="BetweenExpression"/>.</returns>
	//public static AbstractCriterion between(IProjection projection, object lo, object hi)
	//{
	//    return new BetweenExpression(projection, lo, hi);
	//}

	/** 
	 Apply an "in" constraint to the named property 
	 
	 @param propertyName The name of the Property in the class.
	 @param values An array of values.
	 @return An <see cref="InExpression" />.
	*/
	public static AbstractCriterion in(String propertyName, Object[] values)
	{
		return new InExpression(propertyName, values);
	}

	///// <summary>
	///// Apply an "in" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="values">An array of values.</param>
	///// <returns>An <see cref="InExpression"/>.</returns>
	//public static AbstractCriterion in(IProjection projection, object[] values)
	//{
	//    return new InExpression(projection, values);
	//}

	///// <summary>
	///// Apply an "in" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="values">An ICollection of values.</param>
	///// <returns>An <see cref="InExpression"/>.</returns>
	//public static AbstractCriterion in(IProjection projection, ICollection values)
	//{
	//    object[] ary = new object[values.Count];
	//    values.CopyTo(ary, 0);
	//    return new InExpression(projection, ary);
	//}

	/** 
	 Apply an "in" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @param values An ICollection of values.
	 @return An <see cref="InExpression" />.
	*/
	public static AbstractCriterion in(String propertyName, java.util.Collection values)
	{
		//Object[] ary = new Object[values.size()];values.CopyTo(ary, 0);
		return new InExpression(propertyName, values.toArray());
	}

	/** 
	 Apply an "in" constraint to the named property. This is the generic equivalent
	 of <see cref="in(string, ICollection)" />, renamed to avoid ambiguity.
	 
	 @param propertyName The name of the Property in the class.
	 @param values An <see cref="System.Collections.Generic.IEnumerable{T}" />
	 of values.
	 @return An <see cref="InExpression" />.
	*/
	public static <T> AbstractCriterion inG(String propertyName, Iterable<T> values)
	{
		java.util.ArrayList<T> array = new java.util.ArrayList<T>();//Object[] array =  new Object[values.Count()];
		//int i = 0;
		for (T item : values)
		{
			array.add(item);//array[i] = item;
			//i++;
		}

		return new InExpression(propertyName, array.toArray());
	}

	///// <summary>
	///// Apply an "in" constraint to the projection. This is the generic equivalent
	///// of <see cref="in(string, ICollection)"/>, renamed to avoid ambiguity.
	///// </summary>
	///// <typeparam name="T"></typeparam>
	///// <param name="projection">The projection.</param>
	///// <param name="values">An <see cref="System.Collections.Generic.IEnumerable{T}"/>
	///// of values.</param>
	///// <returns>An <see cref="InExpression"/>.</returns>
	//public static AbstractCriterion inG<T>(IProjection projection, IEnumerable<T> values)
	//{
	//    var array = new object[values.Count()];
	//    var i = 0;
	//    foreach (var item in values)
	//    {
	//        array[i] = item;
	//        i++;
	//    }
	//    return new InExpression(projection, array);
	//}

	/** 
	 Apply an "is null" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @return A <see cref="NullExpression" />.
	*/
	public static AbstractCriterion isNull(String propertyName)
	{
		return new NullExpression(propertyName);
	}

	///// <summary>
	///// Apply an "is null" constraint to the projection
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="NullExpression"/>.</returns>
	//public static AbstractCriterion isNull(IProjection projection)
	//{
	//    return new NullExpression(projection);
	//}

	/** 
	 Apply an "equal" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="EqPropertyExpression"/> .
	*/
	public static AbstractCriterion eqProperty(String propertyName, String otherPropertyName)
	{
		return new EqPropertyExpression(propertyName, otherPropertyName);
	}

	///// <summary>
	///// Apply an "equal" constraint to projection and property
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion eqProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new EqPropertyExpression(projection, otherPropertyName);
	//}


	///// <summary>
	///// Apply an "equal" constraint to lshProjection and rshProjection
	///// </summary>
	///// <param name="lshProjection">The LHS projection.</param>
	///// <param name="rshProjection">The RSH projection.</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion eqProperty(IProjection lshProjection, IProjection rshProjection)
	//{
	//    return new EqPropertyExpression(lshProjection, rshProjection);
	//}


	///// <summary>
	///// Apply an "equal" constraint to the property and rshProjection
	///// </summary>
	///// <param name="propertyName">Name of the property.</param>
	///// <param name="rshProjection">The RSH projection.</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion eqProperty(string propertyName, IProjection rshProjection)
	//{
	//    return new EqPropertyExpression(propertyName, rshProjection);
	//}

	/** 
	 Apply an "not equal" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="EqPropertyExpression"/> .
	*/
	public static AbstractCriterion notEqProperty(String propertyName, String otherPropertyName)
	{
		return new NotExpression(new EqPropertyExpression(propertyName, otherPropertyName));
	}

	///// <summary>
	///// Apply an "not equal" constraint to projection and property
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion notEqProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new NotExpression(new EqPropertyExpression(projection, otherPropertyName));
	//}

	///// <summary>
	///// Apply an "not equal" constraint to the projections
	///// </summary>
	///// <param name="lhsProjection">The LHS projection.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion notEqProperty(IProjection lhsProjection, IProjection rhsProjection)
	//{
	//    return new NotExpression(new EqPropertyExpression(lhsProjection, rhsProjection));
	//}

	///// <summary>
	///// Apply an "not equal" constraint to the projections
	///// </summary>
	///// <param name="propertyName">Name of the property.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="EqPropertyExpression"/> .</returns>
	//public static AbstractCriterion notEqProperty(string propertyName, IProjection rhsProjection)
	//{
	//    return new NotExpression(new EqPropertyExpression(propertyName, rhsProjection));
	//}

	/** 
	 Apply a "greater than" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="LtPropertyExpression"/> .
	*/
	public static AbstractCriterion gtProperty(String propertyName, String otherPropertyName)
	{
		return new GtPropertyExpression(propertyName, otherPropertyName);
	}

	///// <summary>
	///// Apply a "greater than" constraint to two properties
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion gtProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new GtPropertyExpression(projection, otherPropertyName);
	//}

	///// <summary>
	///// Apply a "greater than" constraint to two properties
	///// </summary>
	///// <param name="propertyName">Name of the property.</param>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion gtProperty(string propertyName, IProjection projection)
	//{
	//    return new GtPropertyExpression(propertyName, projection);
	//}

	///// <summary>
	///// Apply a "greater than" constraint to two properties
	///// </summary>
	///// <param name="lhsProjection">The LHS projection.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion gtProperty(IProjection lhsProjection, IProjection rhsProjection)
	//{
	//    return new GtPropertyExpression(lhsProjection, rhsProjection);
	//}

	/** 
	 Apply a "greater than or equal" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="LePropertyExpression"/> .
	*/
	public static AbstractCriterion geProperty(String propertyName, String otherPropertyName)
	{
		return new GePropertyExpression(propertyName, otherPropertyName);
	}

	///// <summary>
	///// Apply a "greater than or equal" constraint to two properties
	///// </summary>
	///// <param name="lhsProjection">The LHS projection.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion geProperty(IProjection lhsProjection, IProjection rhsProjection)
	//{
	//    return new GePropertyExpression(lhsProjection, rhsProjection);
	//}

	///// <summary>
	///// Apply a "greater than or equal" constraint to two properties
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion geProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new GePropertyExpression(projection, otherPropertyName);
	//}


	///// <summary>
	///// Apply a "greater than or equal" constraint to two properties
	///// </summary>
	///// <param name="propertyName">The lhs Property Name</param>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion geProperty(string propertyName, IProjection projection)
	//{
	//    return new GePropertyExpression(propertyName, projection);
	//}

	/** 
	 Apply a "less than" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="LtPropertyExpression"/> .
	*/
	public static AbstractCriterion ltProperty(String propertyName, String otherPropertyName)
	{
		return new LtPropertyExpression(propertyName, otherPropertyName);
	}

	///// <summary>
	///// Apply a "less than" constraint to two properties
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion ltProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new LtPropertyExpression(projection, otherPropertyName);
	//}

	///// <summary>
	///// Apply a "less than" constraint to two properties
	///// </summary>
	///// <param name="propertyName">The lhs Property Name</param>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion ltProperty(string propertyName, IProjection projection)
	//{
	//    return new LtPropertyExpression(propertyName, projection);
	//}

	///// <summary>
	///// Apply a "less than" constraint to two properties
	///// </summary>
	///// <param name="lhsProjection">The LHS projection.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="LtPropertyExpression"/> .</returns>
	//public static AbstractCriterion ltProperty(IProjection lhsProjection, IProjection rhsProjection)
	//{
	//    return new LtPropertyExpression(lhsProjection, rhsProjection);
	//}

	/** 
	 Apply a "less than or equal" constraint to two properties
	 
	 @param propertyName The lhs Property Name
	 @param otherPropertyName The rhs Property Name
	 @return A <see cref="LePropertyExpression"/> .
	*/
	public static AbstractCriterion leProperty(String propertyName, String otherPropertyName)
	{
		return new LePropertyExpression(propertyName, otherPropertyName);
	}


	///// <summary>
	///// Apply a "less than or equal" constraint to two properties
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <param name="otherPropertyName">The rhs Property Name</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion leProperty(IProjection projection, string otherPropertyName)
	//{
	//    return new LePropertyExpression(projection, otherPropertyName);
	//}


	///// <summary>
	///// Apply a "less than or equal" constraint to two properties
	///// </summary>
	///// <param name="propertyName">The lhs Property Name</param>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion leProperty(string propertyName, IProjection projection)
	//{
	//    return new LePropertyExpression(propertyName, projection);
	//}


	///// <summary>
	///// Apply a "less than or equal" constraint to two properties
	///// </summary>
	///// <param name="lhsProjection">The LHS projection.</param>
	///// <param name="rhsProjection">The RHS projection.</param>
	///// <returns>A <see cref="LePropertyExpression"/> .</returns>
	//public static AbstractCriterion leProperty(IProjection lhsProjection, IProjection rhsProjection)
	//{
	//    return new LePropertyExpression(lhsProjection, rhsProjection);
	//}


	/** 
	 Apply an "is not null" constraint to the named property
	 
	 @param propertyName The name of the Property in the class.
	 @return A <see cref="NotNullExpression" />.
	*/
	public static AbstractCriterion isNotNull(String propertyName)
	{
		return new NotNullExpression(propertyName);
	}

	///// <summary>
	///// Apply an "is not null" constraint to the named property
	///// </summary>
	///// <param name="projection">The projection.</param>
	///// <returns>A <see cref="NotNullExpression"/>.</returns>
	//public static AbstractCriterion isNotNull(IProjection projection)
	//{
	//    return new NotNullExpression(projection);
	//}

	///// <summary>
	///// Apply an "is not empty" constraint to the named property 
	///// </summary>
	///// <param name="propertyName">The name of the Property in the class.</param>
	///// <returns>A <see cref="IsNotEmptyExpression" />.</returns>
	//public static AbstractEmptinessExpression IsNotEmpty(string propertyName)
	//{
	//    return new IsNotEmptyExpression(propertyName);
	//}

	///// <summary>
	///// Apply an "is not empty" constraint to the named property 
	///// </summary>
	///// <param name="propertyName">The name of the Property in the class.</param>
	///// <returns>A <see cref="IsEmptyExpression" />.</returns>
	//public static AbstractEmptinessExpression IsEmpty(string propertyName)
	//{
	//    return new IsEmptyExpression(propertyName);
	//}

	/** 
	 Return the conjunction of two expressions
	 
	 @param lhs The Expression to use as the Left Hand Side.
	 @param rhs The Expression to use as the Right Hand Side.
	 @return An <see cref="AndExpression" />.
	*/
	public static AbstractCriterion and(Criterion lhs, Criterion rhs)
	{
		return new AndExpression(lhs, rhs);
	}

	/** 
	 Return the disjunction of two expressions
	 
	 @param lhs The Expression to use as the Left Hand Side.
	 @param rhs The Expression to use as the Right Hand Side.
	 @return An <see cref="OrExpression" />.
	*/
	public static AbstractCriterion or(Criterion lhs, Criterion rhs)
	{
		return new OrExpression(lhs, rhs);
	}

	/** 
	 Return the negation of an expression
	 
	 @param expression The Expression to negate.
	 @return A <see cref="NotExpression" />.
	*/
	public static AbstractCriterion not(Criterion expression)
	{
		return new NotExpression(expression);
	}

	/** 
	 Group expressions together in a single conjunction (A and B and C...)
	 
	*/
	public static Conjunction conjunction()
	{
		return new Conjunction();
	}

	/** 
	 Group expressions together in a single disjunction (A or B or C...)
	 
	*/
	public static Disjunction disjunction()
	{
		return new Disjunction();
	}

	/** 
	 Apply an "equals" constraint to each property in the key set of a IDictionary
	 
	 @param propertyNameValues a dictionary from property names to values
	 @return 
	*/
	public static AbstractCriterion allEq(java.util.Map<String, Object> propertyNameValues)
	{
		Conjunction conj = conjunction();

		for (Map.Entry<String, Object> item : propertyNameValues.entrySet())
		{
			conj.add(eq(item.getKey(), item.getValue()));
		}

		return conj;
	}

	//public static NaturalIdentifier NaturalId()
	//{
	//    return new NaturalIdentifier();
	//}

	///// <summary>
	///// Create an Criterion for the supplied LambdaExpression
	///// </summary>
	///// <typeparam name="T">generic type</typeparam>
	///// <param name="expression">lambda expression</param>
	///// <returns>return NHibernate.Criterion.Criterion</returns>
	//public static Criterion Where<T>(Expression<Func<T, bool>> expression)
	//{
	//    Criterion criterion = ExpressionProcessor.ProcessExpression<T>(expression);
	//    return criterion;
	//}

	///// <summary>
	///// Create an Criterion for the supplied LambdaExpression
	///// </summary>
	///// <param name="expression">lambda expression</param>
	///// <returns>return NHibernate.Criterion.Criterion</returns>
	//public static Criterion Where(Expression<Func<bool>> expression)
	//{
	//    Criterion criterion = ExpressionProcessor.ProcessExpression(expression);
	//    return criterion;
	//}

	///// <summary>
	///// Create an Criterion for the negation of the supplied LambdaExpression
	///// </summary>
	///// <typeparam name="T">generic type</typeparam>
	///// <param name="expression">lambda expression</param>
	///// <returns>return NHibernate.Criterion.Criterion</returns>
	//public static Criterion WhereNot<T>(Expression<Func<T, bool>> expression)
	//{
	//    Criterion criterion = ExpressionProcessor.ProcessExpression<T>(expression);
	//    return Restrictions.not(criterion);
	//}

	///// <summary>
	///// Create an Criterion for the negation of the supplied LambdaExpression
	///// </summary>
	///// <param name="expression">lambda expression</param>
	///// <returns>return NHibernate.Criterion.Criterion</returns>
	//public static Criterion WhereNot(Expression<Func<bool>> expression)
	//{
	//    Criterion criterion = ExpressionProcessor.ProcessExpression(expression);
	//    return Restrictions.not(criterion);
	//}

	///// <summary>
	///// Build an Criterion for the given property
	///// </summary>
	///// <param name="expression">lambda expression identifying property</param>
	///// <returns>returns LambdaRestrictionBuilder</returns>
	//public static LambdaRestrictionBuilder On<T>(Expression<Func<T, object>> expression)
	//{
	//    ExpressionProcessor.ProjectionInfo projection = ExpressionProcessor.FindMemberProjection(expression.Body);
	//    return new LambdaRestrictionBuilder(projection);
	//}

	///// <summary>
	///// Build an Criterion for the given property
	///// </summary>
	///// <param name="expression">lambda expression identifying property</param>
	///// <returns>returns LambdaRestrictionBuilder</returns>
	//public static LambdaRestrictionBuilder On(Expression<Func<object>> expression)
	//{
	//    ExpressionProcessor.ProjectionInfo projection = ExpressionProcessor.FindMemberProjection(expression.Body);
	//    return new LambdaRestrictionBuilder(projection);
	//}

}