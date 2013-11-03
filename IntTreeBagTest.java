import java.util.Scanner;
public class IntTreeBagTest 
{
	public static void main(String [] args)
	{
		int action = 0;
		int rootValue = 0;
		int bag = 0;
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the First bag of the root value");
		rootValue = scan.nextInt();
		IntTreeBag bag1 = new IntTreeBag(rootValue);
		rootValue = 0;//re-initialize rootValue in order to get another root value


		System.out.println("Enter the Second bag of the root value");
		rootValue = scan.nextInt();
		IntTreeBag bag2 = new IntTreeBag(rootValue);


		do
		{
			System.out.println("--How do you want to manupilate Int Tree Bags?--");
			System.out.println("");
			System.out.println("1: Add an int data to a bag");
			System.out.println("2: Remove an int data from a bag");
			System.out.println("3: OutPut number of data in a bag");
			System.out.println("4: Add the contains of one bag to another");
			System.out.println("5: Combine the bag with another and get 3rd bag");
			System.out.println("6: Know occurence of a specific int value in a bag");
			System.out.println("7: OutPut the all contains in a bag");
			System.out.println("8: Iterate");
			System.out.println("9: Exit this program");
			action = scan.nextInt();

			switch(action)
			{
				case 1: 
					// Add an int data to a bag
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					int addedElement = 0;
					if(bag == 1)
					{
						System.out.println("Enter the element that you are going to add");
						addedElement = scan.nextInt();
						bag1.add(addedElement);
					}
					else if(bag == 2)
					{
						System.out.println("Enter the element that you are going to add");
						addedElement = scan.nextInt();
						bag2.add(addedElement);
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 2: 
					//Remove an int data from a bag
					int removedElement;
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					if(bag == 1)
					{
						System.out.println("Enter the element that you are going to remove");
						removedElement = scan.nextInt();
						if(bag1.remove(removedElement))
						{
							System.out.printf("%d is successfully removed",removedElement);
						}
						else
						{
							System.out.println("can not find %d or can not remove successfully");
						}
					}
					else if(bag == 2)
					{
						System.out.println("Enter the element that you are going to remove");
						removedElement = scan.nextInt();
						if(bag2.remove(removedElement))
						{
							System.out.printf("%d is successfully removed\n",removedElement);
						}
						else
						{
							System.out.println("can not find %d or can not remove successfully");
						}
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 3:
					//OutPut number of data in a bag
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					if(bag == 1)
					{
						System.out.println("size of bag1 = " + bag1.size());
					}
					else if(bag == 2)
					{
						System.out.println("size of bag2 = " + bag2.size());
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 4:
					//Add the contents of one bag to another
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					if(bag == 1)
					{
						bag1.addAll(bag2);
						bag1.print(10);
					}
					else if(bag == 2)
					{
						bag2.addAll(bag1);
						bag2.print(15);
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 5:
					//combine
					System.out.println("---union---");
					IntTreeBag.union(bag1, bag2).print(15);
					break;
				case 6:
					//Know occurence of a specific int value in a bag
					int specificInt = 0;
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					if(bag == 1)
					{
						System.out.println("Enter the specific int you want to count");
						specificInt = scan.nextInt();
						System.out.printf("occurence of %d = %d\n",specificInt,bag1.countOccurrences(specificInt));
					} 
					else if(bag == 2)
					{
						System.out.println("Enter the specific int you want to count");
						specificInt = scan.nextInt();
						System.out.printf("occurence of %d = %d\n",specificInt,bag2.countOccurrences(specificInt));
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 7:
					//OutPut the all contains in a bag
					System.out.println("Which bag do you want to manipulate?? /nType 1 for 1st bag--or 2 for 2nd bag");
					bag = scan.nextInt();
					int allData1 [] = new int [bag1.size()];
					int allData2 [] = new int [bag2.size()];
					if(bag == 1)
					{
						allData1 = bag1.getAllDatawihtArray();
						System.out.println("---All data in bag1---");
						for(int index = 0; index < bag1.size(); index++)
						{
							System.out.printf("%d\n",allData1[index]);
						}
					}
					else if(bag == 2)
					{
						allData2 = bag2.getAllDatawihtArray();
						System.out.println("---All data in bag2---");
						for(int index = 0; index < bag2.size(); index++)
						{
							System.out.printf("%d\n",allData2[index]);
						}
					}
					else
					{
						System.out.println("invalid number");
					}
					break;
				case 8:
					System.out.println("---iterate bag1---");
					bag1.start();
					while(bag1.isCurrent())
					{

						System.out.println(bag1.getCurrent().getData());
						bag1.advance();
					}

					System.out.println("---iterate bag2---");
					bag2.start();
					while(bag2.isCurrent())
					{
						System.out.println(bag2.getCurrent().getData());
						bag2.advance();
					}
					System.out.println("Exist this program");
					System.out.println("programmed by Kaya Ota");
					break;
				case 9:
					System.out.println("Exist this program");
					System.out.println("programmed by Kaya Ota");
					break;
			}//switch


		}while(action != 9);



	}

}