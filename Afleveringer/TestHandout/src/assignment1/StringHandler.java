package assignment1;

public class StringHandler
{

    /**
     *
     * @param str
     * @return a string where all characters 'c' is replaced by the character
     * 's' Case insensitive.
     */
    public String stringManipulation(String str)
    {
        String a = "";
        for (int i = 0; i<str.length(); i++)
        {
            if (str.charAt(i)+"" == "c"){
                a += "s";
            }
            else 
                a += str.charAt(i);
        }
        return str.replace("c", "s");
    }

    /**
     *
     * @param str
     * @return the length of str If the input str is null or "" you must return
     * 0
     *
     */
    public int stringLength(String str)
    {
        if (str == null || str.isEmpty())
        {
            return 0;
        } else
        {
            return str.length();
        }
    }

    /**
     *
     * @param arr
     * @return the cumulative length of all strings in arr e.g. if arr is
     * ["hi","hello","hej"] the method should return 10
     */
    public int stringArrayLength(String[] arr)
    {
        int y = 0;
        for (String x : arr)
        {
            y += x.length();
        }
        return y;
    }

    /**
     *
     * @param str
     * @return reverse the characters in the String str e.g. "Hello" -> "olleH"
     */
    public String stringReverse(String str)
    {
        String s = "";
        for (int i = 0; i < str.length(); i++)
        {
            s += str.charAt(str.length() - i - 1);
        }

        return s;

    }

    /**
     *
     * @param str any string
     * @param c the character to count
     * @return how many occurences of the character c in the String str The
     * method should not be case sensitive. e.g. parameters: "Change comes
     * through passion", 'g' should return 2
     */
    public int charCount(String str, char c)
    {
        int count = 0;
        String strLC = str.toLowerCase();
        String strUC = str.toUpperCase();

        for (int i = 0; i < str.length(); i++)
        {
            if (strLC.charAt(i) == c || strUC.charAt(i) == c)
            {
                count++;
            }
        }
        return count;

    }
}
