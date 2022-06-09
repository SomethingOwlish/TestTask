

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.*;


public class PointTest { 

@Before
public void before() throws Exception {
    String fieldMarkers = "STWSWTPPTPTTPWPP";
    Point.point[][] TestBfield = new Point.point[4][4];
    int raceType = 3;
} 

@After
public void after() throws Exception {
    solution.fL =4;
    solution.fR =4;

} 

/** 
* 
* Method: selectType(char type) 
* 
*/ 
@Test
public void testSelectType() throws Exception { 
    assertEquals(Point.typeofPoint.firstPointType, Point.selectType('W'));
    assertEquals(Point.typeofPoint.secondPointType, Point.selectType('T'));
    assertEquals(Point.typeofPoint.thirdPointType, Point.selectType('S'));
    assertEquals(Point.typeofPoint.forthPointType, Point.selectType('P'));
} 

/** 
* 
* Method: getTitle() 
* 
*/
void getAll(List<String> testList){
    testList.add(Point.typeofPoint.firstPointType.getTitle());
    testList.add(Point.typeofPoint.secondPointType.getTitle());
    testList.add(Point.typeofPoint.thirdPointType.getTitle());
    testList.add(Point.typeofPoint.forthPointType.getTitle());
}
@Test
public void testGetTitle() throws Exception {

    List<String> actual = new ArrayList<String>();
    getAll(actual);

            String[] array ={"water", "thicket", "swap", "plate"};
    List<String> exp = new ArrayList<String>();
    for(String lang:array){
        exp.add(lang);
    }
    assertEquals(exp, actual);


} 

/** 
* 
* Method: initialize(String fieldMarkers, point[][] field) 
* 
*/ 
@Test
public void testInitialize() throws Exception {
    solution.fL =2;
    solution.fR =2;
    String fieldMarkers = "SSWS";
    Point.point[][] testField =  new Point.point[2][2]; ;
    Point.typeofPoint.initialize(fieldMarkers, testField);
    assertEquals(testField[1][0].type, Point.typeofPoint.firstPointType);

} 

/** 
* 
* Method: getCost(int raceType) 
* 
*/ 
@Test
public void testGetCost() throws Exception {
    assertNotNull(Point.typeofPoint.firstPointType.getCost(1));
    assertEquals(Point.typeofPoint.secondPointType.getCost(2), 5);
    assertEquals(Point.typeofPoint.thirdPointType.getCost(3), 3);
    assertNotNull(Point.typeofPoint.forthPointType.getCost(3));
} 



}
