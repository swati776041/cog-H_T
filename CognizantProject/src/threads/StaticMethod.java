package threads;
interface DemoInterface
{
static void	 hello()
{
System.out.println("hello new");
}
public void overrideMethod(String str);
}

public class StaticMethod implements DemoInterface{
	public static void main(String[] args)
	{
	
	StaticMethod static1=new StaticMethod();
	DemoInterface.hello();
static1.overrideMethod("hello overridden");
	}
	@Override
	public void overrideMethod(String str)
	{
	System.out.println(str);
}
}