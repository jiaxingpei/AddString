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
            String check = checkNegative(arr);
            if(check != null)
                for(int i = 0; i < arr.length; i++)
                    if(arr[i] < 0)
                        throw new RuntimeException("negative not allowed: " + check.substring(4, check.length()-1));
            //Call function calculator Sum
            return calSum(arr);
        }
    }
    //function for convert string to int
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
    //funtion calculation sum
    public static int  calSum(int [] arr){
        int sum = 0, i;
        for (i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    //funtion for check number is a negative?
    public static String checkNegative(int []arr){
        int i;
        String result = null;
        for (i = 0; i < arr.length; i++)
            if (arr[i] < 0){
                result += arr[i] + " ";
            }
        return result;
    }
}


