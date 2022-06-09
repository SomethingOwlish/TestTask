


import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class solutionTest { 

@Before
public void before() throws Exception {
    solution.fL =2;
    solution.fR =2;

} 

@After
public void after() throws Exception {
    solution.fL =4;
    solution.fR =4;
} 

/** 
* 
* Method: getResult(String fieldMarkers, String race) 
* 
*/ 
@Test
public void testGetResult() throws Exception {
    solution.fL =4;
    solution.fR =4;
    int res = solution.getResult("STWSWTPPTPTTPWPP","Human");
    assertEquals(10, res);

} 


/** 
* 
* Method: step(int a, int b) 
* 
*/ 
@Test
public void testStep() throws Exception {
    String fieldMarkers = "PWTS";
    Point.point[][] testField =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testField);
    ArrayList<String> history = new ArrayList<String>();
    solution.makeStep(history,testField,3);
    solution.makeStep(history,testField,2);
    solution.position.step(-1,0);

    int eLine = 0;
    int eRow = 1;
    assertEquals(eLine, solution.position.getLine());
    assertEquals(eRow, solution.position.getRow());
} 


/** 
* 
* Method: makeStep(ArrayList<String> history, Point.point[][] field, int raceType) 
* 
*/ 
@Test
public void testMakeStep() throws Exception {
    String fieldMarkers = "PWTS";
    Point.point[][] testField =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testField);
    ArrayList<String> history = new ArrayList<String>();
    int testRes = solution.makeStep(history,testField,3);
    int eLine = 1;
    int eRow = 1;
    assertEquals(eLine, solution.position.getLine());
    assertEquals(eRow, solution.position.getRow());
    solution.position.step(-1,-1);
    testRes += solution.makeStep(history,testField,2);
    testRes += solution.makeStep(history,testField,1);
    assertEquals(10,testRes);
} 

/** 
* 
* Method: checkCoast(int l, int r, Point.point[][] field, int raceType) 
* 
*/ 
@Test
public void testCheckCoast() throws Exception {
    String fieldMarkers = "PWTS";
    Point.point[][] testField =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testField);
    int testRes = solution.checkCoast(0,0, testField, 2);
    assertEquals(2, testRes);
    testRes = solution.checkCoast(1,1, testField, 1);
    assertEquals(5, testRes);
    testRes = solution.checkCoast(0,1, testField, 3);
    assertEquals(3, testRes);
    testRes = solution.checkCoast(1,0, testField, 2);
    assertEquals(5, testRes);
} 

/** 
* 
* Method: validCheck(int l, int r, String typeSwitcher, Point.point[][] field, int raceType) 
* 
*/ 
@Test
public void testValidCheck() throws Exception {
    String fieldMarkers = "SPWT";
    Point.point[][] testField =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testField);
    int testRes = solution.validCheck(0,0, "Row", testField, 2);
    assertEquals(2, testRes);
    testRes = solution.validCheck(0,1, "Line", testField, 1);
    assertEquals(3, testRes);
    testRes = solution.validCheck(1,1, "Line", testField, 3);
    assertEquals(100, testRes);

}

/** 
* 
* Method: findBetter(int l, int r, Point.point[][] field, int raceType) 
* 
*/ 
@Test
public void testFindBetter() throws Exception {
    String fieldMarkers = "SPWS";
    Point.point[][] testFieldFinder =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testFieldFinder);
  boolean act = solution.findBetter(0, 0, testFieldFinder, 2);
    assertTrue(act);
   act = solution.findBetter(1, 0, testFieldFinder, 1);
    assertFalse(act);
   act = solution.findBetter(0, 1, testFieldFinder, 3);
    assertTrue(act);
} 

/** 
* 
* Method: isFinal() 
* 
*/ 
@Test
public void testIsFinal() throws Exception {
//TODO: Test goes here...
    solution.position Testposition = new solution.position(2,3);
    solution.fL = 1;
    solution.fR = 0;
    assertEquals(true, solution.position.isFinal());
   solution.fL = 0;
    solution.fR = 3;
    assertEquals(true, solution.position.isFinal());
    solution.fL = 1;
    solution.fR = 2;
    assertEquals(true, solution.position.isFinal());
    solution.fL = 6;
    solution.fR = 6;
    assertEquals(false, solution.position.isFinal());
}

}
