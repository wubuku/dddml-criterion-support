package org.dddml.support.criterion;

import java.io.Serializable;

/**
 The base class for an <see cref="Criterion"/> that compares a single Property
 to a value.
 
*/
public class SimpleExpression extends AbstractCriterion implements Serializable
{

	private String _propertyName;

	private Object _value;

	private boolean _ignoreCase;

	private String _op;


	/** 
	 Initialize a new instance of the <see cref="SimpleExpression" /> class for a named
	 Property and its value.
	 
	 @param propertyName The name of the Property in the class.
	 @param value The value for the Property.
	 @param op The SQL operation.
	*/
	public SimpleExpression(String propertyName, Object value, String op)
	{
		this._propertyName = propertyName;
		this._value = value;
		this._op = op;
	}

	public SimpleExpression(String propertyName, Object value, String op, boolean ignoreCase)
	{
		this(propertyName, value, op);
		this._ignoreCase = ignoreCase;
	}

	public final SimpleExpression ignoreCase()
	{
		_ignoreCase = true;
		return this;
	}

	/** 
	 Gets the named Property for the Expression.
	 
	 <value>A string that is the name of the Property.</value>
	*/
	public final String getPropertyName()
	{
		return _propertyName;
	}

	/** 
	 Gets the Value for the Expression.
	 
	 <value>An object that is the value for the Expression.</value>
	*/
	public final Object getValue()
	{
		return _value;
	}


	@Override
	public String toString()
	{
		return _propertyName + getOp() + valueToStrings();
	}

	/** 
	 Get the Sql operator to use for the specific 
	 subclass of <see cref="SimpleExpression"/>.
	 
	*/
	public String getOp()
	{
		return _op;
	}

	//private static final java.lang.Class[] CallToStringTypes = new Object[] { java.util.Date.class, String.class };

	private String valueToStrings() {
		if (_value == null) {
			return "null";
		}
		//C# TO JAVA : There is no equivalent to implicit typing in Java:
		//var type = _value.getClass();
		//C# TO JAVA : Lambda expressions and anonymous methods are not converted:
		//if (type.IsPrimitive || CallToStringTypes.Any(t => t.IsAssignableFrom(type)))
		//{
		return _value.toString();
		//}
		//return ObjectHelpers.IdentityToString(_value);

	}
}