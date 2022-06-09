

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

public class RaceTest { 

@Before
public void before() throws Exception {
    Race.makeRace("Elf");
    Race.makeRace("Swamp");
    Race.makeRace("Ant");
} 

@After
public void after() throws Exception {
    Race.ListofRace.clear();
} 

/** 
* 
* Method: findType(String name) 
* 
*/ 
@Test
public void testFindType() throws Exception {
    assertEquals(Race.findType("Elf"), 1);
    assertEquals(Race.findType("Swamp"), 2);
    assertEquals(Race.findType("Ant"), 3);

} 


} 
