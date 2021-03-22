// created by: Jackson Giles
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		ExpressionTree tree = new ExpressionTree();
		
		System.out.println("Enter Postfix Expression:");
		
		String line = input.nextLine();
		
		Scanner lineScanner = new Scanner(line);
		
		
		while (lineScanner.hasNext()) {
		    // grab items from lineScanner
			
			// create string of line element
			String x = lineScanner.next();
			
			// checks if element is a digit
			boolean numTF = x.matches(".*\\d.*");
			
			try {
				
				if (numTF) {
					
					// creates new node with num
					double num = Double.parseDouble(x);
					
					tree.pushNumber(num);
				}
				
				else {
					
					// creates new node with operator
					switch(x) {
					
					case "+":
						
						tree.pushAdd();
						break;
						
					case "-":
						
						tree.pushSubtract();
						break;
						
					case "*":
						
						tree.pushMultiply();
						break;
						
					case "/":
						
						tree.pushDivide();
						break;
						
					default:
						
						System.out.println("error");
						break;
					}
					
				}
			}
			
			catch (Exception e) {
				
				System.out.println("Invalid Expression");
			}
		}
		
		// infix
		System.out.println("Infix: " + tree.infixString());
		
		// evaluate
		System.out.println("evaluate(): " + tree.evaluate());
		
		// height
		System.out.println("height(): " + tree.height());
		
		tree.clear();
		
		input.close();
		lineScanner.close();
	}

}
