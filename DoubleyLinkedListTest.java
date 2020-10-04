import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoubleyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testNewListIsEmpty ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue(testDLL.isEmpty());
    }
    
    @Test 
    public void testListNotEmpty ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	assertFalse(testDLL.isEmpty());
    }
    
    @Test
    public void testGetForEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals(testDLL.get(0), null);
    }
    
    @Test 
    public void testGetForOutOfBoundsPosition ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
    	testDLL.insertBefore(1,2);
    	testDLL.insertBefore(2,3);
    	int dataAtNodeFour = 9;
     	int dataAtNodeFive = -40;
    	assertEquals(testDLL.get(dataAtNodeFour), null);
    	assertEquals(testDLL.get(dataAtNodeFive), null);
    	}
    
    @Test
    public void testGet ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	int dataAtNodeTwo = 2;
    	String data = "3";
    	assertEquals(testDLL.get(dataAtNodeTwo).toString(), data );
    }

    @Test
    public void testDeleteForOutOfBoundsPosition ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	int dataAtNodeFour = 9;
     	int dataAtNodeFive = -40;
     	assertFalse(testDLL.deleteAt(dataAtNodeFour));
     	assertFalse(testDLL.deleteAt(dataAtNodeFive));
    }
    
    @Test
    public void testDeleteForEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertFalse(testDLL.deleteAt(0));
    }
    
    @Test
    public void testDelete ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.deleteAt(0);
    	assertTrue(testDLL.isEmpty());
    	
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	assertTrue(testDLL.deleteAt(0));
    	assertEquals(testDLL.get(0).toString(), "2");
    	
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	assertTrue(testDLL.deleteAt(2));
    	assertEquals(testDLL.get(1).toString(), "2");
    	
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	assertTrue(testDLL.deleteAt(1));
    	assertEquals(testDLL.get(1).toString(), "3");
    }
    
    @Test 
    public void testReverseForEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.reverse();
    	String expectedResult = "";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testReverseForSize1 ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.reverse();
    	String expectedResult = "1";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testReverse ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	String expectedResult = "3,2,1";
    	
    	testDLL.reverse();
    	
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testMakeUniqueForEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue(testDLL.isEmpty());
    	testDLL.makeUnique();
    	String expectedResult = "";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testMakeUniqueForSize1 ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.makeUnique();
    	String expectedResult = "1";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testMakeUniqueForWithoutDuplication ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	testDLL.makeUnique();
    	String expectedResult = "1,2,3";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testMakeUniqueWithDuplication()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	testDLL.insertBefore(3, 2);
    	testDLL.makeUnique();
    	String expectedResult = "1,2,3";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test 
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.push(3);
    	String addedItem= "3";
    	assertEquals(testDLL.get(0).toString(), addedItem);
    	
    }
    
    @Test
    public void testPopIfEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.pop();
    	assertTrue(testDLL.isEmpty());
    	String expectedResult = "";
    	assertEquals(testDLL.toString(), expectedResult );
    }
    
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	testDLL.pop();
    	String expectedResult2 = "2,3";
    	assertEquals(testDLL.toString(), expectedResult2 );

    }
    
    @Test
    public void testEnqueueIfEmptyList ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue(testDLL.isEmpty());
    	testDLL.enqueue(1);
    	String expectedResult = "1";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test 
    public void testEnqueue ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	testDLL.enqueue(4);
    	String expectedResult = "1,2,3,4";
    	assertEquals(testDLL.toString(), expectedResult);
    	
    }
    
    @Test 
    public void testDequeueIsEmptyList()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue(testDLL.isEmpty());
    	assertEquals(testDLL.dequeue(),null );
    }
    
    @Test
    public void testDequeueForSize1()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.dequeue();
    	String expectedResult = "";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test
    public void testDequeueForSize2 ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.dequeue();
    	String expectedResult = "2";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    	
    @Test
    public void testDequeue ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 1);
    	testDLL.insertBefore(1, 2);
    	testDLL.insertBefore(2, 3);
    	testDLL.dequeue();
    	String expectedResult = "2,3";
    	assertEquals(testDLL.toString(), expectedResult);
    }
    
    @Test 
    public void testEmptyAfterDequeue ()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.dequeue();
    	assertTrue( testDLL.isEmpty());
    }
    
}
