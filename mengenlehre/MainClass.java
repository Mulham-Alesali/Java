import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class MainClass {
	
    private final static String regex =
    		"^(?<m1>(\\[\\])|(\\[\\d+\\])|(\\[(\\d+,)+\\d+\\]))(?<op>\\+|\\*|\\-)(?<m2>(\\[\\])|(\\[[0-9]+\\])|(\\[(\\d+,)+\\d+\\]))$";
    private final static Pattern pattern = Pattern.compile(regex);
    
    private final static String regex2 = "\\D(?<number>\\d+)";
    
    private final static Pattern pattern2 = Pattern.compile(regex2);
    
	public static void main(String[] args) {
		
		String m1 = "";
		String m2 = "";
		char op = ' ';
		
		System.out.println("Enter the Operation:");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		
		while(!input.trim().equals("")) {
		input = input.replace(" ", "");
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.groupCount() == 0)
			System.out.println("the Format is wrong");
		else
		while(matcher.find()) {
				 m1 = matcher.group("m1");
				 op = matcher.group("op").charAt(0);
				 m2 = matcher.group("m2");
				 
				 Set<Integer> result = doOperation(
				 getArrayFromMenge(m1),
				 getArrayFromMenge(m2),
				 op);
				 				 
		System.out.println(result);
		
		}
		
		System.out.println("Enter the Operation:");		
		input = sc.nextLine();
		
		}
		
		System.out.println("ende");
		sc.close();
		
	}
	
	
	public static Set<Integer> doOperation(Set<Integer> s1, Set<Integer> s2, char op){
		//TODO write the code to do the operations
		
		Set<Integer> sr = new HashSet<Integer>();
		
		switch (op) {
		case '+':
			sr.addAll(s1);
			sr.addAll(s2);
			break;
		case '-':
			sr.addAll(s1);
			sr.removeAll(s2);
			break;
		case '*':
			sr.addAll(s1);
			sr.retainAll(s2);
			break;
		}
		return sr;
		
	}
	
	
	public static Set<Integer> getArrayFromMenge(String menge) {
		
		Matcher matcher = pattern2.matcher(menge);
		Set<Integer> set = new HashSet<Integer>();
		
		while(matcher.find()) {
				set.add(Integer.parseInt(matcher.group("number")));
			}
		
		return set;
	}
	

}
