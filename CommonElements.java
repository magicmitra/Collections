

public class CommonElements implements Comparable
{
   private int comparisons = 0;
   private int commonIndex = 0;
   private int[] marker; // these will aid in marking 
                         // theoretically, should eliminate
                         // repeated comparisons
   
   public Comparable[] findCommonElements(Comparable[][] collections)
   {
      Comparable[] query;  // the query array
      populateMarker(collections);
      
      // sort the individual arrays, using my 
      // implemented insertion sort for practice
      for(int i = 0; i < collections.length; i++)
      {
         insertionSort(collections[i]);
      }
      
      // use the first entry as the query collection
      query = collections[0]; 
      Comparable[] common = new Comparable[query.length];
      
      for(int i = 0; i < query.length; i++)
      {
         for(int j = 1; j < collections.length; j++)
         {
            int k = getMarker(j); // initialize control loop
            boolean exitWhile = false;
            while((!exitWhile) 
            && k < collections[j].length)
            {
               if(query[i].compareTo(collections[j][k]) == 0)
               {
                  comparisons++;
                  common[commonIndex] = query[i];
                  commonIndex++;
                  setMarker(j, k++);
                  exitWhile = true;
               }
               else if(query[i].compareTo(collections[j][k]) > 0)
               {
                  // check if common element can be found
                  comparisons++;
                  setMarker(j, k++);
                  k++;
               }
               else
               {
                  comparisons++;
                  setMarker(j, k);
                  common[commonIndex] = 0;
                  if(commonIndex > 0)
                     commonIndex--;
                  else
                     commonIndex = 0;
                  exitWhile = true;
               }
            }
         }
      }
      
      return common;
   }
   
   // my implementation of the insertion sort for practice
   public void insertionSort(Comparable[] a)
   {
      Comparable temp;
      int j; // inner loop controller
      
      for(int i = 0; i < a.length; i++)
      {
         temp = a[i];
         for(j = i; j > 0 && temp.compareTo(a[j - 1]) < 0;
             j--)
         {
            a[j] = a[j - 1];
         }
         a[j] = temp;
      }
   }
   
   public void populateMarker(Comparable[][] c)
   {
      marker = new int[c.length];
   }
   
   // set the marker specific to an array
   public void setMarker(int index, int m)
   {
      marker[index] = m;
   }
   
   // return the marker specific to an array
   public int getMarker(int index)
   {
      return marker[index];
   }
   
   // accessor method to get comparison
   public int getComparisons()
   {
      return comparisons;
   }
   
   // since we implemented Comparable
   public int compareTo(Object c)
   {
      return this.compareTo(c);
   }
}
