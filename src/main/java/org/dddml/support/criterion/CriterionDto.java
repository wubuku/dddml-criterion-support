package org.dddml.support.criterion;

import java.util.Map;
import java.util.function.Function;

public class CriterionDto
{
	private static java.util.Map<String, Class> _typeDictionary = new java.util.HashMap<String, Class>();

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_EQ = "eq";

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_GT = "gt";

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_LT = "lt";

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_GE = "ge";

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_LE = "le";

	public static final String SIMPLE_EXPRESSION_TYPE_NAME_LIKE = "like";

	private static String getSimpleExpressionTypeNameByOp(String op)
	{
		if (op.trim().equalsIgnoreCase(Restrictions.OP_EQ))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_EQ;
		}
		if (op.trim().equalsIgnoreCase(Restrictions.OP_GT))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_GT;
		}
		if (op.trim().equalsIgnoreCase(Restrictions.OP_LT))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_LT;
		}
		if (op.trim().equalsIgnoreCase(Restrictions.OP_GE))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_GE;
		}
		if (op.trim().equalsIgnoreCase(Restrictions.OP_LE))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_LE;
		}
		if (op.trim().equalsIgnoreCase(Restrictions.OP_LIKE))
		{
			return SIMPLE_EXPRESSION_TYPE_NAME_LIKE;
		}
		throw new IllegalArgumentException(String.format("not supported op: %1$s ", op));
	}

	static
	{
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_EQ, SimpleExpression.class);
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_GT, SimpleExpression.class);
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_LT, SimpleExpression.class);
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_GE, SimpleExpression.class);
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_LE, SimpleExpression.class);
		_typeDictionary.put(SIMPLE_EXPRESSION_TYPE_NAME_LIKE, SimpleExpression.class);
		// ------------ 
		_typeDictionary.put("ilike", InsensitiveLikeExpression.class);
		// ------------ 
		_typeDictionary.put("in", InExpression.class);
		// ------------ 
		_typeDictionary.put("isNull", NullExpression.class);
		_typeDictionary.put("isNotNull", NotNullExpression.class);
		// ------------ 
		_typeDictionary.put("between", BetweenExpression.class);
		// ------------ 
		_typeDictionary.put("and", AndExpression.class);
		_typeDictionary.put("or", OrExpression.class);
		// ------------ 
		_typeDictionary.put("not", NotExpression.class);
		// ------------ 
		_typeDictionary.put("disjunction", Disjunction.class);
		_typeDictionary.put("conjunction", Conjunction.class);
		// ------------ 
		_typeDictionary.put("eqProperty", EqPropertyExpression.class);
		_typeDictionary.put("gtProperty", GtPropertyExpression.class);
		_typeDictionary.put("ltProperty", LtPropertyExpression.class);
		_typeDictionary.put("geProperty", GePropertyExpression.class);
		_typeDictionary.put("leProperty", LePropertyExpression.class);
	}

	private Criterion _innerCriterion;

	private TypeConverter _typeConverter;

	public TypeConverter getTypeConverter()
	{
		return this._typeConverter;
	}

	private String _type;

	public String getType()
	{
		return this._type;
	}
	public void setType(String value)
	{
		if (!getIsTypeDecided())
		{
			this._type = value;
		}
	}

	private String _property;

	public String getProperty()
	{
		if (getIsTypeDecided())
		{
			if (getIsSimpleExpression())
			{
				SimpleExpression e = (SimpleExpression)((_innerCriterion instanceof SimpleExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			if (getIsPropertyExpression())
			{
				PropertyExpression e = (PropertyExpression)((_innerCriterion instanceof PropertyExpression) ? _innerCriterion : null);
				return e.getLhsPropertyName();
			}
			if (getIsBetweenExpression())
			{
				BetweenExpression e = (BetweenExpression)((_innerCriterion instanceof BetweenExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			if (getIsNullExpression())
			{
				NullExpression e = (NullExpression)((_innerCriterion instanceof NullExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			if (getIsNotNullExpression())
			{
				NotNullExpression e = (NotNullExpression)((_innerCriterion instanceof NotNullExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			if (getIsInsensitiveLikeExpression())
			{
				InsensitiveLikeExpression e = (InsensitiveLikeExpression)((_innerCriterion instanceof InsensitiveLikeExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			if (getIsInExpression())
			{
				InExpression e = (InExpression)((_innerCriterion instanceof InExpression) ? _innerCriterion : null);
				return e.getPropertyName();
			}
			return null;
		}
		return _property;
	}
	public void setProperty(String value)
	{
		if (!getIsTypeDecided())
		{
			this._property = value;
		}
	}

	private String _op;

	public String getOp()
	{
		if (getIsTypeDecided())
		{
			if (getIsSimpleExpression())
			{
				SimpleExpression e = (SimpleExpression)((_innerCriterion instanceof SimpleExpression) ? _innerCriterion : null);
				return e.getOp();
			}
			if (getIsPropertyExpression())
			{
				PropertyExpression e = (PropertyExpression)((_innerCriterion instanceof PropertyExpression) ? _innerCriterion : null);
				return e.getOp();
			}
			if (getIsLogicalExpression())
			{
				LogicalExpression e = (LogicalExpression)((_innerCriterion instanceof LogicalExpression) ? _innerCriterion : null);
				return e.getOp();
			}
			if (getIsJunction())
			{
				Junction e = (Junction)((_innerCriterion instanceof Junction) ? _innerCriterion : null);
				return e.getOp();
			}
			return null;
		}
		return _op;
	}
	public void setOp(String value)
	{
		if (!getIsTypeDecided())
		{
			this._op = value;
		}
	}

	private String _value;

	public String getValue()
	{
		if (getIsTypeDecided())
		{
			if (getIsSimpleExpression())
			{
				SimpleExpression e = (SimpleExpression)((_innerCriterion instanceof SimpleExpression) ? _innerCriterion : null);
				return (_value != null) ? _value : (_value = _typeConverter.convertToString(e.getValue()));
			}
			if (getIsInsensitiveLikeExpression())
			{
				InsensitiveLikeExpression e = (InsensitiveLikeExpression)((_innerCriterion instanceof InsensitiveLikeExpression) ? _innerCriterion : null);
				return (_value != null) ? _value : (_value = _typeConverter.convertToString(e.getValue()));
			}
			return null;
		}
		return _value;
	}
	public void setValue(String value)
	{
		if (!getIsTypeDecided())
		{
			this._value = value;
		}
	}

	private String _hi;

	public String getHi()
	{
		if (getIsTypeDecided())
		{
			if (getIsBetweenExpression())
			{
				BetweenExpression e = (BetweenExpression)((_innerCriterion instanceof BetweenExpression) ? _innerCriterion : null);
				return (_hi != null) ? _hi : (_hi = _typeConverter.convertToString(e.getHi()));
			}
			return null;
		}
		return _hi;
	}
	public void setHi(String value)
	{
		if (!getIsTypeDecided())
		{
			this._hi = value;
		}
	}

	private String _lo;

	public String getLo()
	{
		if (getIsTypeDecided())
		{
			if (getIsBetweenExpression())
			{
				BetweenExpression e = (BetweenExpression)((_innerCriterion instanceof BetweenExpression) ? _innerCriterion : null);
				return (_lo != null) ? _lo : (_lo = _typeConverter.convertToString(e.getLo()));
			}
			return null;
		}
		return _lo;
	}
	public void setLo(String value)
	{
		if (!getIsTypeDecided())
		{
			this._lo = value;
		}
	}

	private String[] _values;

	public String[] getValues()
	{
		if (getIsTypeDecided())
		{
			if (getIsInExpression())
			{
				InExpression e = (InExpression)((_innerCriterion instanceof InExpression) ? _innerCriterion : null);
				return (_values != null) ? _values : (_values = _typeConverter.convertToStringArray(e.getValues()));
			}
			return null;
		}
		return _values;
	}
	public void setValues(String[] value)
	{
		if (!getIsTypeDecided())
		{
			this._values = value;
		}
	}


	private String _otherProperty;

	public String getOtherProperty()
	{
		if (getIsTypeDecided())
		{
			if (getIsPropertyExpression())
			{
				PropertyExpression e = (PropertyExpression)((_innerCriterion instanceof PropertyExpression) ? _innerCriterion : null);
				return e.getRhsPropertyName();
			}
			return null;
		}
		return _otherProperty;
	}
	public void setOtherProperty(String value)
	{
		if (!getIsTypeDecided())
		{
			this._otherProperty = value;
		}
	}

	private CriterionDto[] _criteria;

	public CriterionDto[] getCriteria()
	{
		if (getIsTypeDecided())
		{
			if (getIsJunction())
			{
				Junction e = (Junction)((_innerCriterion instanceof Junction) ? _innerCriterion : null);
				return (_criteria != null) ? _criteria : (_criteria = toCriterionDtoArray(e.getCriteria(), this.getTypeConverter()));
			}
			return null;
		}
		return _criteria;
	}
	public void setCriteria(CriterionDto[] value)
	{
		if (!getIsTypeDecided())
		{
			this._criteria = value;
		}
	}


	private CriterionDto _lhs;

	public CriterionDto getLhs()
	{
		if (getIsTypeDecided())
		{
			if (getIsLogicalExpression())
			{
				LogicalExpression e = (LogicalExpression)((_innerCriterion instanceof LogicalExpression) ? _innerCriterion : null);
				return (_lhs != null) ? _lhs : (_lhs = new CriterionDto(e.getLeftHandSide(), this.getTypeConverter()));
			}
			return null;
		}
		return _lhs;
	}
	public void setLhs(CriterionDto value)
	{
		if (!getIsTypeDecided())
		{
			this._lhs = value;
		}
	}


	private CriterionDto _rhs;

	public CriterionDto getRhs()
	{
		if (getIsTypeDecided())
		{
			if (getIsLogicalExpression())
			{
				LogicalExpression e = (LogicalExpression)((_innerCriterion instanceof LogicalExpression) ? _innerCriterion : null);
				return (_rhs != null) ? _rhs : (_rhs = new CriterionDto(e.getRightHandSide(), this.getTypeConverter()));
			}
			return null;
		}
		return _rhs;
	}
	public void setRhs(CriterionDto value)
	{
		if (!getIsTypeDecided())
		{
			this._rhs = value;
		}
	}

	private CriterionDto _criterion;

	public CriterionDto getCriterion()
	{
		if (getIsTypeDecided())
		{
			if (getIsNotExpression())
			{
				NotExpression e = (NotExpression)((_innerCriterion instanceof NotExpression) ? _innerCriterion : null);
				return (_criterion != null) ? _criterion : (_criterion = new CriterionDto(e.getCriterion(), this.getTypeConverter()));
			}
			return null;
		}
		return _criterion;
	}
	public void setCriterion(CriterionDto value)
	{
		if (!getIsTypeDecided())
		{
			this._criterion = value;
		}
	}


	public CriterionDto(Criterion criterion, TypeConverter typeConverter)
	{
		this._innerCriterion = criterion;
		this._typeConverter = typeConverter;
		if (getIsSimpleExpression())
		{
			SimpleExpression e = (SimpleExpression)((_innerCriterion instanceof SimpleExpression) ? _innerCriterion : null);
			_type = getSimpleExpressionTypeNameByOp(e.getOp());
		}
		else
		{
			for (Map.Entry<String, Class> p : _typeDictionary.entrySet())
			{
				if (_innerCriterion.getClass().equals(p.getValue()))
				{
					_type = p.getKey();
					break;
				}
			}
			if (_type==null || _type.isEmpty())
			{
				throw new UnsupportedOperationException(String.format("not supported criterion type: %1$s", _innerCriterion.getClass().getName()));
			}
		}
	}

	public CriterionDto()
	{
	}

	public static Criterion toSubclass(CriterionDto criterion, TypeConverter typeConverter, PropertyTypeResolver propertyTypeResolver)
	{
		return toSubclass(criterion, typeConverter, propertyTypeResolver, n -> n);
	}

	public static Criterion toSubclass(CriterionDto criterion, TypeConverter typeConverter, PropertyTypeResolver propertyTypeResolver, Function<String, String> mapPropertyName)
	{
		if (!_typeDictionary.containsKey(criterion._type))
		{
			throw new UnsupportedOperationException(String.format("not supported criterion type name: %1$s", criterion._type));
		}

		Criterion cr = null;
		Class type = _typeDictionary.get(criterion._type);
		if (type.equals(SimpleExpression.class))
		{
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_EQ))
			{
				cr = Restrictions.eq(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_GT))
			{
				cr = Restrictions.gt(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_LT))
			{
				cr = Restrictions.lt(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_GE))
			{
				cr = Restrictions.ge(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_LE))
			{
				cr = Restrictions.le(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (criterion._type.equalsIgnoreCase(SIMPLE_EXPRESSION_TYPE_NAME_LIKE))
			{
				cr = Restrictions.like(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
		}
		else
		{
			if (type.equals(InsensitiveLikeExpression.class))
			{
				cr = Restrictions.insensitiveLike(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValue()));
			}
			if (type.equals(InExpression.class))
			{
				cr = Restrictions.in(mapPropertyName.apply(criterion.getProperty()), convertPropertyValuesFromStringArray(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getValues()));
			}
			if (type.equals(NullExpression.class))
			{
				cr = Restrictions.isNull(mapPropertyName.apply(criterion.getProperty()));
			}
			if (type.equals(NotNullExpression.class))
			{
				cr = Restrictions.isNotNull(mapPropertyName.apply(criterion.getProperty()));
			}
			if (type.equals(BetweenExpression.class))
			{
				cr = Restrictions.between(mapPropertyName.apply(criterion.getProperty()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getLo()), convertPropertyValueFromString(typeConverter, propertyTypeResolver, mapPropertyName.apply(criterion.getProperty()), criterion.getHi()));
			}
			if (type.equals(AndExpression.class))
			{
				cr = Restrictions.and(toSubclass(criterion.getLhs(), typeConverter, propertyTypeResolver, mapPropertyName), toSubclass(criterion.getRhs(), typeConverter, propertyTypeResolver, mapPropertyName));
			}
			if (type.equals(OrExpression.class))
			{
				cr = Restrictions.or(toSubclass(criterion.getLhs(), typeConverter, propertyTypeResolver, mapPropertyName), toSubclass(criterion.getRhs(), typeConverter, propertyTypeResolver, mapPropertyName));
			}
			if (type.equals(NotExpression.class))
			{
				cr = Restrictions.not(toSubclass(criterion.getCriterion(), typeConverter, propertyTypeResolver, mapPropertyName));
			}
			if (type.equals(Disjunction.class))
			{
				Disjunction j = Restrictions.disjunction();
				for (CriterionDto c : criterion.getCriteria())
				{
					j.add(toSubclass(c, typeConverter, propertyTypeResolver, mapPropertyName));
				}
				cr = j;
			}
			if (type.equals(Conjunction.class))
			{
				Conjunction j = Restrictions.conjunction();
				for (CriterionDto c : criterion.getCriteria())
				{
					j.add(toSubclass(c, typeConverter, propertyTypeResolver, mapPropertyName));
				}
				cr = j;
			}

			if (type.equals(EqPropertyExpression.class))
			{
				cr = Restrictions.eqProperty(mapPropertyName.apply(criterion.getProperty()), mapPropertyName.apply(criterion.getOtherProperty()));
			}
			if (type.equals(GtPropertyExpression.class))
			{
				cr = Restrictions.gtProperty(mapPropertyName.apply(criterion.getProperty()), mapPropertyName.apply(criterion.getOtherProperty()));
			}
			if (type.equals(LtPropertyExpression.class))
			{
				cr = Restrictions.ltProperty(mapPropertyName.apply(criterion.getProperty()), mapPropertyName.apply(criterion.getOtherProperty()));
			}
			if (type.equals(GePropertyExpression.class))
			{
				cr = Restrictions.geProperty(mapPropertyName.apply(criterion.getProperty()), mapPropertyName.apply(criterion.getOtherProperty()));
			}
			if (type.equals(LePropertyExpression.class))
			{
				cr = Restrictions.leProperty(mapPropertyName.apply(criterion.getProperty()), mapPropertyName.apply(criterion.getOtherProperty()));
			}
		}
		if (cr == null)
		{
			throw new UnsupportedOperationException(String.format("not supported criterion. type name: %1$s, %2$s", criterion._type, criterion));
		}
		criterion._innerCriterion = cr; // IsTypeDecided == true;
		return cr;
	}

	private static Object[] convertPropertyValuesFromStringArray(TypeConverter typeConverter, PropertyTypeResolver propertyTypeResolver, String propertyName, String[] strValues)
	{
		java.util.ArrayList<Object> list = new java.util.ArrayList<Object>();
		java.lang.Class type = propertyTypeResolver.resolveTypeByPropertyName(propertyName);
		for (String s : strValues)
		{
			list.add(typeConverter.convertFromString(type, s));
		}
		return list.toArray(new Object[]{});
	}

	private static Object convertPropertyValueFromString(TypeConverter typeConverter, PropertyTypeResolver propertyTypeResolver, String propertyName, String value)
	{
		return typeConverter.convertFromString(propertyTypeResolver.resolveTypeByPropertyName(propertyName), value);
	}

	private static CriterionDto[] toCriterionDtoArray(java.util.List<Criterion> criteria, TypeConverter typeConverter)
	{
		java.util.ArrayList<CriterionDto> list = new java.util.ArrayList<CriterionDto>();
		for (Criterion c : criteria)
		{
			list.add(new CriterionDto(c, typeConverter));
		}
		return list.toArray(new CriterionDto[]{});
	}


	protected final boolean getIsTypeDecided()
	{
		return _innerCriterion != null;
	}

	protected final boolean getIsSimpleExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof SimpleExpression;
	}

	protected final boolean getIsPropertyExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof PropertyExpression;
	}

	protected final boolean getIsBetweenExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof BetweenExpression;
	}

	protected final boolean getIsNullExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof NullExpression;
	}

	protected final boolean getIsNotNullExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof NotNullExpression;
	}

	protected final boolean getIsLogicalExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof LogicalExpression;
	}

	protected final boolean getIsNotExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof NotExpression;
	}

	protected final boolean getIsInsensitiveLikeExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof InsensitiveLikeExpression;
	}

	protected final boolean getIsJunction()
	{
		return _innerCriterion != null && _innerCriterion instanceof Junction;
	}

	protected final boolean getIsInExpression()
	{
		return _innerCriterion != null && _innerCriterion instanceof InExpression;
	}

	//if (IsSimpleExpression) { var e = _innerCriterion as SimpleExpression; return e.; }
	//if (IsPropertyExpression) { var e = _innerCriterion as PropertyExpression; return e.; }
	//if (IsBetweenExpression) { var e = _innerCriterion as BetweenExpression; return e.; }
	//if (IsNullExpression) { var e = _innerCriterion as NullExpression; return e.; }
	//if (IsNotNullExpression) { var e = _innerCriterion as NotNullExpression; return e.; }
	//if (IsLogicalExpression) { var e = _innerCriterion as LogicalExpression; return e.; }
	//if (IsNotExpression) { var e = _innerCriterion as NotExpression; return e.; }
	//if (IsInsensitiveLikeExpression) { var e = _innerCriterion as InsensitiveLikeExpression; return e.; }
	//if (IsJunction) { var e = _innerCriterion as Junction; return e.; }
	//if (IsInExpression) { var e = _innerCriterion as InExpression; return e.; }

}