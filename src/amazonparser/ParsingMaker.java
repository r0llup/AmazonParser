/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazonparser;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sh1fT
 */

public final class ParsingMaker {
    protected Pattern pattern;
    protected Matcher matcher;

    /**
     * Creates new instance ParsingMaker
     * @param regex
     * @param data 
     */
    public ParsingMaker(String regex, String data) {
        this.setPattern(Pattern.compile(regex));
        this.setMatcher(this.getPattern().matcher(data));
    }

    public Pattern getPattern() {
        return this.pattern;
    }

    protected void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher() {
        return this.matcher;
    }

    protected void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    /**
     * Find 0ut
     * @param firstDelim
     * @param lastDelim
     * @return String
     */
    public String findOut(String firstDelim, String lastDelim) {
        String str = null;
        while (this.getMatcher().find()) {
            str = this.getMatcher().group();
            str = str.substring(str.lastIndexOf(firstDelim)+firstDelim.length(),
                str.lastIndexOf(lastDelim));
            return str;
        }
        return str;
    }

    /**
     * Find 0ut2
     * @param firstDelim
     * @param lastDelim
     * @return List<String>
     */
    public List<String> findOut2(String firstDelim, String lastDelim) {
        List<String> strList = new LinkedList<>();
        while (this.getMatcher().find()) {
            String str = this.getMatcher().group();
            str = str.substring(str.lastIndexOf(firstDelim)+firstDelim.length(),
                str.lastIndexOf(lastDelim));
            strList.add(str);
        }
        return strList;
    }
}