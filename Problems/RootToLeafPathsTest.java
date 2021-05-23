import static org.junit.Assert.*;
import org.junit.Test;

public class RootToLeafPathsTest {

@RunWith(MockitoJUnitRunner.RootToLeafPaths.class)
public class AddSubTest {

   @InjectMocks
   RootToLeafPaths rootToLeafPaths;

   // With no element
   @Test
   public void testEmptyValue() {
      // Since we are not setting any value in model or any class variable
      // Else we could do 
      // String inputString = "";
      // when(rootToLeafPaths.getInput()).thenReturn(inputString);
      int emptyElementsList = rootToLeafPaths.doTreeOperations();
      assertEquals(0,  emptyElementsList);
   }

   // With one element
   @Test
   public void testSingleValue() {
      // Since we are not setting any value in model or any class variable
      // Else we could do 
      // String inputString = "4";
      // when(rootToLeafPaths.getInput()).thenReturn(inputString);
      int emptyElementsList = rootToLeafPaths.doTreeOperations();
      assertEquals(4,  emptyElementsList);
   }

   //WithoutSpace
   @Test
   public void testWithContinuosString() {
      // Since we are not setting any value in model or any class variable
      // Else we could do 
      // String inputString = "490";
      // when(rootToLeafPaths.getInput()).thenReturn(inputString);
      // 49 + 40 = 89
      int emptyElementsList = rootToLeafPaths.doTreeOperations();
      assertEquals(89,  emptyElementsList);
   }

   //With ","" seperated values
   @Test
   public void testWithCommaSeperatedString() {
      // Since we are not setting any value in model or any class variable
      // Else we could do 
      // String inputString = "4,9,0";
      // when(rootToLeafPaths.getInput()).thenReturn(inputString);
      // 49 + 40 = 89
      int emptyElementsList = rootToLeafPaths.doTreeOperations();
      assertEquals(89,  emptyElementsList);
   }
 
   //With " " seperated values
   @Test
   public void testWithSpaceSeperatedString() {
      // Since we are not setting any value in model or any class variable
      // Else we could do 
      // String inputString = "4 9 0";
      // when(rootToLeafPaths.getInput()).thenReturn(inputString);
      // 49 + 40 = 89
      int emptyElementsList = rootToLeafPaths.doTreeOperations();
      assertEquals(89,  emptyElementsList);
   }

   //For Invalid input
}
    
}
