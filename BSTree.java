
public class BSTree{
	
	// an additional class representing a node in the tree
	private class BSTNode {
		// data members
		public Comparable data;
		public BSTNode left;
		public BSTNode right;

       // constructor
       BSTNode(Comparable newdata) {
          data = newdata;
       }
   }
	
	// data member
	protected BSTNode root;
	
	// methods
	public void insert(String string) {
		root = insert(string, root);
	}
	public BSTNode insert (Comparable value, BSTNode node) {
		if(node == null) {
			return new BSTNode(value);
		}
		if(value.compareTo(node.data) < 0) {
			node.left = insert(value, node.left);
			return node;
		} else {
			node.right = insert(value, node.right);
			return node;
		}
	}
	
	public boolean find(String string) {
		return find(string, root);
	}
	public boolean find(Comparable value, BSTNode node) {	
		if(node == null) {
			return false;
		}
		if(value.compareTo(node.data) == 0) {
			return true;
		} else if(value.compareTo(node.data) < 0) {
			return find(value, node.left);
		} else {
			return find(value, node.right);
		}
	}
	
	protected void delete(String string) {
		root = delete(string, root);
	}
	
	private BSTNode delete(Comparable value, BSTNode node) {
		if(node == null) {
			return null;
		}
		if (node.data.compareTo(value) == 0) {
			if(node.left == null) 
				return node.right;
			else if (node.right == null)
				return node.left;
			if(node.right.left == null) {
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			} else {
				node.data = removeSmallest(node.right);
				return node;
			}
		}
		return node;
	}
	private Comparable removeSmallest (BSTNode node) {
		
		if(node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}
	
	// returns a space-separated copy of the contents stored in the BST in (sorted) order.

	public String toStringInOrder() {
		return toStringInOrder(root);
	}
	public String toStringInOrder(BSTNode node) {
		if(node == null) {
			return " ";
		}
		return (toStringInOrder(node.left) + " " + node.data + " " + toStringInOrder(node.right) + " ").trim();
	}
	
	// returns a space-separated copy of the contents stored in the BST in pre-order: the contents of the root node, 
	// followed by the contents of the left child and the contents of the right child.

	public String toStringPreOrder() {
		return toStringPreOrder(root).trim();
	}
	public String toStringPreOrder(BSTNode node) {
		String result = "";
	      if (node == null) {
	         return "";
	      }
	      result += node.data + " " + toStringPreOrder(node.left) + toStringPreOrder(node.right);
	      return result;
	}

}
