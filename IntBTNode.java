public class IntBTNode
{
	private int data;
	private IntBTNode left;//Meta-data
	private IntBTNode right;//Meta-data

	public IntBTNode(int initialData, IntBTNode initialLeft, IntBTNode initialRight)
	{
		data = initialData;
		left = initialLeft;
		right = initialRight;
	}
	public int getData()
	{
		return data;
	}
	public IntBTNode getLeft()
	{
		return left;
	}
	public int getLeftmostData()
	{
		if(left == null)
		{
			return data;
		}
		else 
		{
			return left.getLeftmostData();
		}
	}
	public int getRightmostData()
	{
		if(right == null)
		{
			return data;
		}
		else
		{
			return right.getRightmostData();
		}
	}
	public IntBTNode getRight()
	{
		return right;
	}
	public void inorderPrint()
	{
		//left --->> middle --->> right
		if(left != null)
		{
			left.inorderPrint();
		}
		System.out.println(data);
		if(right != null)
		{
			right.inorderPrint();
		}
	}
	public boolean isLeaf()
	{
		return (left == null)&&(right == null);
	}
	public void preorderPrint()
	{
		System.out.println(data);//first shows root -> left -> right->....
		if(left != null)
		{
			left.preorderPrint();
		}
		if(right != null)
		{
			right.preorderPrint();
		}
	}
	public void postorderPrint()
	{
		if(left != null)
		{
			left.postorderPrint();
		}
		if(right != null)
		{
			right.postorderPrint();
		}
		System.out.println(data);//show children first -->> root
	}
	public void print(int depth)
	{
		int i;
		//print the indentation and the data from the current node
		for(i = 1; i <= depth; i++)
		{
			System.out.print("   ");
		}
		//System.out.print("print data " );
		System.out.println(data);//in order to print, every data printed from here

		//Print left subtree (or depth if there is a right child and no left child)
		if(left != null)
		{
			left.print(depth+1);
		}
		else if (right != null)
		{
			for(i = 1; i <= depth+1; i++)
			{
				System.out.println("     ");
			}
			System.out.println("------------");
		} 
		//print the right subtree (or a depth if there is a left child and no left child)
		if(right != null)
		{
			right.print(depth+1);
		}else if(left != null)
		{
			for(i = 1; i <= depth +1; i++)
			{
				System.out.println("     ");
			}
			System.out.println(" ----------");
		}	
	}//print
	public IntBTNode removeLeftmost()
	{
		if(left == null)
		{
			return right;
		}
		else 
		{
			left = left.removeLeftmost();
			return this;
		}
	}//removeLeftmost
	public IntBTNode removeRightmost()
	{
		if(right == null)
		{
			return left;
		}
		else
		{
			right = right.removeRightmost();
			return this;
		}
	}//removeRightmost()
	public void setData(int newData)
	{
		data = newData;
	}
	public void setLeft(IntBTNode newLeft)
	{
		left = newLeft;
	}
	public void setRight(IntBTNode newRight)
	{
		right = newRight;
	}
	public static IntBTNode treeCopy(IntBTNode source)
	{
		IntBTNode leftCopy;
		IntBTNode rightCopy;
		if(source == null)
		{
			return null;
		}
		else 
		{
			leftCopy = treeCopy(source.left);
			rightCopy = treeCopy(source.right);
			return new IntBTNode(source.data,leftCopy,rightCopy);
		}
	}
	public static int treeSize(IntBTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return 1 + treeSize(root.left) + treeSize(root.right);
		}
	}
	public IntBTNode getLeftmost()
	{
		if(left == null)
		{
			return this;
		}
		else
		{
			return left.getLeftmost();
		}
	}

	public IntBTNode getRightmost()
	{
		if(right == null)
		{
			return this;
		}
		else
		{
			return right.getRightmost();
		}
	}
}//class