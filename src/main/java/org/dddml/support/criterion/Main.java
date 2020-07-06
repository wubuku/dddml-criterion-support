package org.dddml.support.criterion;

/**
 * Created by Yang on 2016/7/28.
 */
public class Main {

    public static void main(String[] args) {
        AbstractCriterion c1 = Restrictions.and(Restrictions.eq("I", "am alive"), Restrictions.eq("U", "are dead"));
        System.out.println(c1);
        SimpleExpression c2 = Restrictions.like("But I", "U.");
        Criterion c3 = Restrictions.and(c1, c2);
        System.out.println(c3);
        Criterion c5 = Restrictions.conjunction().add(Restrictions.not(c3)).add(Restrictions.like("true", true));
        System.out.println(c5);

        TypeConverter typeConverter = new DefaultTypeConverter();

        Long long1 = (Long) typeConverter.convertFromString(Long.class, "999");
        System.out.println(long1);

//        Date date1 = new Date();
//        System.out.println(date1);
//        System.out.println(date1.toGMTString());
//        String str1 = typeConverter.convertToString(date1);
//        System.out.println(str1);
//        Date date2 = (Date)typeConverter.convertFromString(Date.class, str1);
//        System.out.println(date2);
//        System.out.println(date2.toGMTString());
//        System.out.println(date1.toGMTString().equals(date2.toGMTString()));

    }

}
