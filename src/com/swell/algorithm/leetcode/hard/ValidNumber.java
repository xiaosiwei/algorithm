package com.swell.algorithm.leetcode.hard;

/**
 * Created by xiaosiwei on 16/8/12.
 * Refer to : https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        String noBlankStr = getNoBlankStr(s);
        if (!checkDigit(noBlankStr)) return false;
        if (noBlankStr.length() == 0) return false;
        if (containsNoDigit(noBlankStr)) return false;

        boolean hasPoint = noBlankStr.indexOf('.') >= 0 ? true : false;
        boolean hasCharE = noBlankStr.indexOf('e') >= 0 ? true : false;
        boolean hasMinus = noBlankStr.indexOf('-') >= 0 ? true : false;
        boolean hasPlus = noBlankStr.indexOf('+') >= 0 ? true : false;

        if (hasCharE) {
            if (noBlankStr.length() <= 1) return false;
            if (noBlankStr.charAt(0) == 'e' || noBlankStr.charAt(noBlankStr.length()-1) == 'e') {
                return false;
            }
            int pos = noBlankStr.indexOf('e');
            String first = noBlankStr.substring(0, pos);
            String second = noBlankStr.substring(pos+1);

            if (hasMinus && (first.charAt(0) != '-' && second.charAt(0) != '-')) return false;
            if (hasPlus && (first.charAt(0) != '+' && second.charAt(0) != '+')) return false;
            if (hasMinus || hasPlus) {
                if (second.length() == 1 && (second.charAt(0) == '-' || second.charAt(0) == '+')) return false;
            }

            if (isNumber(first)) {
                return true;
            } else {
                return false;
            }
        }

        if (hasPoint) {
            if (hasMinus && noBlankStr.charAt(0) != '-') return false;
            if (hasPlus && noBlankStr.charAt(0) != '+') return false;
            if (noBlankStr.length() <= 1) return false;
            return true;
        }

        if (hasMinus && noBlankStr.charAt(0) != '-') return false;
        if (hasPlus && noBlankStr.charAt(0) != '+') return false;

        return true;
    }

    private boolean containsNoDigit(String noBlankStr) {
        for (int i = 0;i < noBlankStr.length();i++) {
            if (noBlankStr.charAt(i) >= '0' && noBlankStr.charAt(i) <= '9') return false;
        }
        return true;
    }

    private boolean legalWithBeginZero(String s) {
        if (s.length() > 1) {
            if (s.charAt(0) == '0') return false;
        }
        return true;
    }

    private boolean checkDigit(String s) {
        boolean hasPoint = false;
        boolean hasCharE = false;
        int minusCnt = 0;
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (hasPoint) return false;
                if (hasCharE && s.indexOf('.') > s.indexOf('e')) return false;
                hasPoint = true;
                continue;
            }
            if (c == 'e') {
                if (hasCharE)   return false;
                if (hasPoint && s.indexOf('.') > s.indexOf('e')) return false;
                hasCharE = true;
                continue;
            }
            if (c == '-' || c == '+') {
                if (minusCnt >= 2) return false;
                if (minusCnt == 1) {
                    if (hasCharE) {
                        int pos = s.indexOf('-');
                        if (pos < 0) pos = s.indexOf('+');
                        if (! (pos < s.indexOf('e') && i > s.indexOf('e')) ) return false;
                    } else {
                        return false;
                    }
                }
                minusCnt++;
                continue;
            }

            if (c < '0' || c > '9' ) return false;
        }
        return true;
    }

    public String getNoBlankStr(String s) {
        String withOutEndBlankStr = s.trim();
        int i = 0;
        for (;i < withOutEndBlankStr.length();i++) {
            if (withOutEndBlankStr.charAt(i) != ' ') break;
        }
        return withOutEndBlankStr.substring(i);
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber(" -.7e+0435"));
    }

}
