public class StringOperation {


    //Check If all characters are same in a string
    private static boolean allCharsSame(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;

        return true;
    }

    /*Given String array, if any string contains same values except default
       then return repeated character. If not any exists, return space
    */

    public static char checkCharWithAllSameInAnyString(String strings[]) {
        for (String str : strings)
            if (allCharsSame(str) && str.charAt(0) != '\u0000') {
                return str.charAt(0);
            }
        return ' ';
    }
}
