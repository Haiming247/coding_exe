import java.util.LinkedList;
import java.util.Queue;


public class FindTreeDepth {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		// bfs
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int depth=0;
		q.add(root);
		q.add(null);
		TreeNode currentNode;
		while(q.isEmpty()==false){
			currentNode=q.poll();
			if(currentNode==null) {
				depth++;
				if(q.isEmpty()==true) return depth;
				else q.add(null);
			}else{
				if(currentNode.left!=null) q.add(currentNode.left);
				if(currentNode.right!=null) q.add(currentNode.right);
			}
		}
		return depth;
	}
	
	public static void main(String[] args){
//		this example shows that though there's only a null in the queue, it's not empty.
//		Queue<String> qq = new LinkedList<String>();
//		System.out.print(qq);
//		qq.add(null);
//		System.out.print(qq);
//		System.out.print(qq.isEmpty());
//		if(qq.isEmpty()==false) System.out.print(qq);
		
	} 
}