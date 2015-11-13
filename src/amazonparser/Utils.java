/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazonparser;

import java.util.List;

/**
 *
 * @author Sh1fT
 */

public class Utils {
    /**
     * Retourne une liste de chaînes de caractères séparées par une virgule
     * @param array
     * @return String
     */
    protected static String arrayToString(List<String> array) {
        if (array != null) {
            String str = "";
            for (String s : array) {
                s = s.replaceAll("%20", " ").replaceAll("%C3%A9", "é")
                    .replaceAll("%C3%A7", "ç").replaceAll("%2C", "");
                if (str.compareTo("") == 0)
                    str = s + ",";
                else
                    str += s + ",";
            }
            return str;
        }
        return null;
    }
}