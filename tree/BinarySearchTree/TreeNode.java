public class TreeNode {
	
	//package asscess members
	TreeNode left;		//left node
	Number data;		//data item
	TreeNode right;		//right node
	private int num; 	//primary key
	private int numNew; 	//new data to be inserted

	//constructor
	public TreeNode(Number n) {
		num = n.getN();
		data = n;
		left = right = null;
	}

	//insert method
	//Ignore duplicate values
	public void insert(Number n) {
		
		numNew = n.getN();

		//check whether insert into right or left node
		if(numNew < num) {
			if(left == null) 
				left = new TreeNode(n);
			else
				left.insert(n);
		}
		else {
			if(right == null) 
				right = new TreeNode(n);
			else
				right.insert(n);
		}
	}
}
