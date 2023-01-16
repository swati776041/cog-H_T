package threads;
@FunctionalInterface
interface Run
{
public void count(int num);	
}

public class Mainclass {
public static void main(String[] args) {
Run ref1=(int num)->
{
	for(int i=1; i<=num; i++)
	{
		System.out.println(i);
	}

	};
	ref1.count(5);
}
}
