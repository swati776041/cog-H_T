package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Course {
	public static void main(String[] args)
	{
		List<JEE> a1=new ArrayList<JEE>();
	a1.add(new JEE(12, "Physics", "sam", 5, 10000));
	a1.add(new JEE(10, "maths", "mike", 4, 5000));
	a1.add(new JEE(8, "chemistry", "advik", 6, 8000));
	a1.add(new JEE(7, "biology", "javik", 7, 12000));
	a1.add(new JEE(11, "science", "advit", 8, 15000));
	a1.add(new JEE(6, "kannada", "sonu", 3, 7000));
	a1.add(new JEE(2, "english", "golu", 2, 20000));
	a1.add(new JEE(12, "hindi", "samesh", 9, 9000));
	
	Collections.sort(a1, new Comparator<JEE>() {

		@Override
		public int compare(JEE o1, JEE o2) {
			
			return (int)(o1.getName().compareTo(o2.getName()));
		}
	});
	Collections.sort(a1, (o1, o2) -> (o2.getName().compareTo(o1.getName())));
	System.out.print("Desending order=" + a1);
	Collections.sort(a1, Comparator.comparing(JEE::getName));
	}
}

	class MySort implements Comparator<JEE>
	{
		@Override
		public int compare(JEE o1, JEE o2)
		{
			return (int)(o2.getFees()-o1.getFees());
	}

	}