import java.io.File;
import java.util.*;

public class Assignment1
{
    //sum : FLoatList -> float
    //Given: A List of Floats
    //Returns: The sum of all the elements in the list
    //Example: sum([1.0,2.0,3.0,4.0]) -> 10.0
    private static float sum(List<Float> v)
    {
        float tot = 0;
        for(Object element : v)
        {
            tot = tot + Float.parseFloat(element.toString());
        }
        return tot;
    }
    
    //Main Method
    //Effect: Prints the Min, Max, Avg and Total of the balance and Matitial 
    //        Status, grouped by Maritial Status for the given .csv file
    public static void main(String ar[]) throws Exception
    {
        List<Float> single, married, divorced;
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        single = new ArrayList<Float>();
        married = new ArrayList<Float>();
        divorced = new ArrayList<Float>();
        File f = new File(System.getProperty("user.dir")+ File.separator + "bank.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
        while(sc.hasNextLine())
        {
            s = sc.nextLine();
            //The following line of code ensures that no record has a balnk
            //entry.
            s = s.replace(",,", ",0,");
            StringTokenizer st1 = new StringTokenizer(s, ",");
            // temporarily store the data of each row in a list of strings. 
            while(st1.hasMoreTokens())
                words.add(st1.nextToken());
            //Based on the matitial status, group data into appropriate lists.
            switch(words.get(2).toString())
            {
                case "married":
                    married.add(Float.parseFloat(words.get(5)));
                    break;
                case "single":
                    single.add(Float.parseFloat(words.get(5)));
                    break;
                case "divorced":
                    divorced.add(Float.parseFloat(words.get(5)));
                    break;
            }
            words.removeAll(words);
        }
        //Print data in a tabular format.
        System.out.println("Maritial \t Min \t Max \t Avg \t\t Count");
        System.out.println("single  \t" + Collections.min(single) +"\t" + 
                            Collections.max(single)+ "\t" + 
                            sum(single)/single.size() + "\t" + 
                            single.size());
        System.out.println("married \t" + Collections.min(married) +"\t" + 
                           Collections.max(married) + "\t" + 
                           sum(married)/married.size() + "\t" + married.size());
        System.out.println("divorced \t" + Collections.min(divorced) +"\t" + 
                           Collections.max(divorced) + "\t" + 
                           sum(divorced)/divorced.size() + "\t" + 
                           divorced.size());
    }
}