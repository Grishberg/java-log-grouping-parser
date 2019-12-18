import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		String src = "start, a, 1\n" +
			"start, b, 2\n" +
			"call, a, 3\n"+
			"call, b, 4\n"+
			"get, b, 6\n"+
			"get, a, 10";
		String[] lines = src.split("\n");
		Parser p = new Parser();
		
		for(String l: lines) {
			p.process(l);
		}
		
		System.out.println(p);
	}
}
