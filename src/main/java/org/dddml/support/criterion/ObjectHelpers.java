package org.dddml.support.criterion;

/** 
 Various small helper methods.
 
*/
public final class ObjectHelpers
{
	/** 
	 Return an identifying string representation for the object, taking
	 NHibernate proxies into account. The returned string will be "null",
	 "classname@hashcode(hash)", or "entityname#identifier". If the object
	 is an uninitialized NHibernate proxy, take care not to initialize it.
	 
	*/
	public static String identityToString(Object obj)
	{
		if (obj == null)
		{
			return "null";
		}

		//var proxy = obj as Proxy.INHibernateProxy;

		//if (null != proxy)
		//{
		//    var init = proxy.HibernateLazyInitializer;
		//    return StringHelper.unqualify(init.EntityName) + "#" + init.Identifier;
		//}

		return StringHelper.unqualify(obj.getClass().getName()) + "@" + obj.hashCode() + "(hash)";
	}
}