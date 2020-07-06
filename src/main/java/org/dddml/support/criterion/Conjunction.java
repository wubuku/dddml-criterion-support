package org.dddml.support.criterion;

import java.io.Serializable;

/**
 An <see cref="Criterion"/> that Junctions together multiple
 <see cref="Criterion"/>s with an <c>and</c>
 
*/
public class Conjunction extends Junction implements Serializable
{
	/** 
	 Get the Sql operator to put between multiple <see cref="Criterion"/>s.
	 
	 <value>The string "<c> and </c>"</value>
	*/
	@Override
	public String getOp()
	{
		return " and ";
	}

	//protected override SqlString EmptyExpression
	//{
	//    get { return new SqlString("1=1"); }
	//}
}