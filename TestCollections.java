 
public class TestCollections
{
   public static void main(String[] args)
   {
      // Create a CommonElements object
      CommonElements c = new CommonElements();
      
      // initialize arrays
      Comparable[] collection1 = {2, 4, 10, 3, 20, 21};
      Comparable[] collection2 = {10, 5, 7, 2, 8, 20, 9};
      Comparable[] collection3 = {10, 20, 23};
      
      Comparable[][] collections = {collection1, collection2, collection3};
      
      Comparable[] array = c.findCommonElements(collections);
      for(int i = 0; i < array.length; i++)
      {
         System.out.print(array[i] + " ");
      }
            
      System.out.println("Comparisons" + " " + c.getComparisons());
   }
}
