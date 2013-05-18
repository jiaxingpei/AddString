package AddString;


/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 5/16/13
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddString {
    public static int Add(String numbers) {

        //check numbers string is empty
        if (numbers.isEmpty())
            return 0;
            //Calculator sum
        else{
            //regex for split string
            String regex = ("[//;,\n.*%]");
            //Render split string with regex
            String [] result = numbers.split(regex);
            //convert string to int
            int [] arr = convertStringToInt(result);
            //catch exception when string have a negative
           /* String check = print(checkNegative(arr));
            if(check != null)
            for(int i = 0; i < arr.length; i++)
                if(arr[i] < 0)
                    throw new RuntimeException("negative not allowed: " + check);*/
            //Call function calculator Sum
            return calSum(arr);
        }
    }

    public static int[] convertStringToInt(String[] numbers){

        int [] arr = new int [numbers.length];
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i].isEmpty())
                arr[i] = 0;
            else
                arr[i] = Integer.parseInt(numbers[i]);
            if(arr[i] > 1000)
                arr[i] = 0;
        }
        return arr;
        }
    public static int  calSum(int [] arr){
        int sum = 0, i;
        for (i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    /*public static int[] checkNegative(int []arr){
        int i, j = 0 ;
        int [] negative = new int[arr.length];
        for (i = 0; i < arr.length; i++)
            if (arr[i] < 0){
                negative[j++] = arr[i];
            }
        return negative;
    }
    private static String print(int[] negative) {
        String result = null;
        for(int i = 0; i < negative.length; i++)
            result += negative[i] + " ";
        return result;
    }*/
}


