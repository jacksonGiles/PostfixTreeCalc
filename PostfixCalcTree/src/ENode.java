// created by: Jackson Giles
class ENode {
	
	double value;
	
	String op;
	ENode right = null, left = null;
	
	boolean isLeaf;
	
	// constructor for value, isLeaf
	public ENode(double value) {
		
		this.value = value;
		isLeaf = true;
	}
	
	// constructor for operator, !isLeaf
	public ENode(String op) {
		
		this.op = op;
		isLeaf = false;
	}

	// switch for math operations
	public double op(double op1, double op2) {
		
		switch(op) {
		
		case "+":
			
			return op1 + op2;
			
		case "-":
			
			return op1 - op2;
			
		case "*":
			
			return op1 * op2;
			
		case "/":
			
			return op1 / op2;
		}
		
		return 0;
	}
}