import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Caoimhe Shanahan
 *  		 - The people I discussed this assignment with were : Aoife Gardiner, Sinead McGetrick and the Lab Assistants
 *  		 - I also found the Algorithms, 4th Edition Book by Robert Sedgewick and Kevin Wayne very 
 *  		   helpful in order to understand what each function was doing and how each function works.
 *  		 - In total I probably spent approximately 5 hours working on this assignment. 
 */

@RunWith(JUnit4.class)
public class BSTTest
{

	@Test 
	public void testIsEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking isEmpty() for an empty tree.", true, bst.isEmpty());

		bst.put(1, 1);
		bst.put(2, 2);
		bst.put(3, 3);
		assertEquals("Checking isEmpty() for a non-empty tree.", false, bst.isEmpty());

	}

	@Test public void testSize()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking size() for an empty tree.",0, bst.size());

		bst.put(1, 1);
		assertEquals("Checking size() for a tree with one pair.",1, bst.size());

		bst.put(2, 2);
		bst.put(3, 3);
		bst.put(4, 4);
		assertEquals("Checking size() for a tree with four pairs.", 4, bst.size());
	}

	@Test public void testContains()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		assertEquals("Checking contains() for an empty tree.",false, bst.contains(0));

		bst.put(1, 1);
		assertEquals("Checking contains() for a tree with one pair.",true, bst.contains(1));
		assertEquals("Checking contains() for a tree with one pair.",false, bst.contains(2));

		bst.put(2, 2);
		bst.put(3, 3);
		bst.put(4, 4);
		assertEquals("Checking contains() for a tree with four pairs.", true, bst.contains(4));
		assertEquals("Checking contains() for a tree with four pairs.", false, bst.contains(5));

		bst.put(5, 5);
		bst.put(6, 6);
		bst.put(7, 7);
		assertEquals("Checking contains() for a tree with many pairs.", true, bst.contains(7));
		assertEquals("Checking contains() for a tree with many pairs.", false, bst.contains(8));

	}

	@Test public void testGet()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		assertEquals("Checking get() for an empty tree.",null, bst.get(0));

		bst.put(1, 1);
		int expectedValue = bst.get(1);
		assertEquals("Checking get() for a tree with one node.", expectedValue, 1);
		assertNull("Checking get() for a tree with one node.",bst.get(2));

		bst.put(8, 8);   
		bst.put(3, 3);   
		bst.put(2, 2); 
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5); 

		expectedValue = bst.get(8);
		assertEquals("Checking get() for a tree with many nodes.", expectedValue, 8);
		assertNull("Checking get() for a tree with many nodes.", bst.get(9));

	}

	@Test public void testPut()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertNull("Checking get() for an empty tree.",bst.get(1));

		bst.put(1, 1);
		int expectedValue = bst.get(1);
		assertEquals("Checking get() for a tree with one node.", expectedValue, 1);
		assertNull("Checking get() for a tree with one node.", bst.get(2));

		bst.put(8, 8);   
		bst.put(3, 3);   
		bst.put(2, 2); 
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5); 

		expectedValue = bst.get(8);
		assertEquals("Checking get() for a tree with many node.", expectedValue, 8);
		assertNull("Checking get() for a tree with many node.", bst.get(9));

	}

	@Test
	public void testHeight()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		assertEquals("Checking height() for an empty tree",-1, bst.height());

		bst.put(1, 1);
		assertEquals("Checking height() for a tree with one node",0, bst.height());

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5

		assertEquals("Checking height() when left height should be greater than right height",5, bst.height());
	}

	@Test 
	public void testMedian()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		assertEquals("Checking median() for an empty tree", null, bst.median());

		bst.put(1, 1);
		int expectedValue = bst.median();
		assertEquals("Checking median() for bst with one node:", 1, expectedValue);

		bst.put(2, 2);
		bst.put(3, 3);
		expectedValue = bst.median();
		assertEquals("Checking median() for bst with three nodes (odd number of nodes):", 2, expectedValue);
		bst.put(4, 5);
		bst.put(5, 4);
		bst.put(6, 4);
		expectedValue = bst.median();
		assertEquals("Checking median() for bst tree with 6 nodes (even number of nodes):", 3, expectedValue);

	}

	@Test 
	public void testPrintKeysInOrder() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking printKeysInOrder() for an empty tree", "()", bst.printKeysInOrder());

		bst.put(7, 7);
		assertEquals("Checking printKeysInOrder() for a tree with one node", "(()7())", bst.printKeysInOrder());

		bst.put(8, 8);       
		bst.put(3, 3);       
		bst.put(1, 1);      
		bst.put(2, 2);       
		bst.put(6, 6);       
		bst.put(4, 4);       
		bst.put(5, 5);  

		assertEquals("Checking printKeysInOrder() for a tree with many node", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

	}
	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testPrettyPrint() 
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree",
				"-null\n", bst.prettyPrintKeys());

		//  -7
		//   |-3
		//   | |-1
		//   | | |-null
		bst.put(7, 7);       //   | |  -2
		bst.put(8, 8);       //   | |   |-null
		bst.put(3, 3);       //   | |    -null
		bst.put(1, 1);       //   |  -6
		bst.put(2, 2);       //   |   |-4
		bst.put(6, 6);       //   |   | |-null
		bst.put(4, 4);       //   |   |  -5
		bst.put(5, 5);       //   |   |   |-null
		//   |   |    -null
		//   |    -null
		//    -8
		//     |-null
		//      -null

		String result = 
				"-7\n" +
						" |-3\n" + 
						" | |-1\n" +
						" | | |-null\n" + 
						" | |  -2\n" +
						" | |   |-null\n" +
						" | |    -null\n" +
						" |  -6\n" +
						" |   |-4\n" +
						" |   | |-null\n" +
						" |   |  -5\n" +
						" |   |   |-null\n" +
						" |   |    -null\n" +
						" |    -null\n" +
						"  -8\n" +
						"   |-null\n" +
						"    -null\n";
		assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}


	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testDelete() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}


}
