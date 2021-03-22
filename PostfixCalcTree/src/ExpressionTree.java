// created by: Jackson Giles
import java.util.Stack;

public class ExpressionTree {

	Stack<ENode> tree = new Stack<>();
	
    public void pushNumber(double d) {
    	
    	// new node w value
    	tree.push(new ENode(d));
    }
    
    public void pushOp(String op) {
    	
    	// create new node with operator
    	ENode node = new ENode(op);
        node.right = tree.pop();
        node.left = tree.pop();
        tree.push(node);
    }
    
    // (for all math functions) creates new node w operator
    public void pushAdd() {
    	
    	pushOp("+");
    	
    }
    
    public void pushMultiply() {
    	
    	pushOp("*");
    	
    }
    
    public void pushSubtract() {
    	
    	pushOp("-");
    	
    }
    
    public void pushDivide() {
    	
    	pushOp("/");
    	
    }
    
    // returns value of the tree
    public double evaluateNode(ENode n) {
    	
    	if(n.isLeaf) {
    		
    		return n.value;
    	}
    	
    	else {
    		
    		//left = evaluateNode(n.left);
    		//right = evaluateNode(n.right);
    		
    		return n.op(evaluateNode(n.left), evaluateNode(n.right));
    	}
    }
    
    public double evaluate() {
    	
    	return evaluateNode(tree.peek());
    	
    }
    
    // turns node into string
    public String infix(ENode n) {
		
		if (n.isLeaf) {
			
			return Double.toString(n.value);
		}
		
		else {
			
			return "(" + infix(n.left) + " " + n.op + " " + infix(n.right) + ")";
		}
	}

    // returns the string of the tree
    public String infixString() {
    	
    	return infix(tree.peek());
    	
    }
    
    public int heightNode(ENode n) {
    	
    	if (n.left == null) {
    		
    		return 0;
    	}
    	
    	// finds max height between left/right
    	return Math.max(heightNode(n.left), heightNode(n.right)) + 1;
    }

    public int height() {
    	
    	// should return the height of the expression tree
    	return heightNode(tree.peek());
    }
    
    public void clear() {
    	
    	tree.clear();
    }

    // For bonus:
    // public void pushVariable();
    // public void evaluate(double variableVal);
}