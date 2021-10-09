package com.xjf.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/10/4 13:34
 */
class LetterCombinations {


    private List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character,String> phoneMap = new HashMap<Character,String>() {
            {
               put('2',"abc");
               put('3',"def");
               put('4',"ghi");
               put('5',"jkl");
               put('6', "mno");
               put('7', "pqrs");
               put('8', "tuv");
               put('9', "wxyz");

            }

        };

        backTrace(digits,new StringBuilder(),phoneMap,result,0);

        return result;
    }

    public void backTrace(String digits,StringBuilder combination,Map<Character,String> phoneMap,List<String> combinations,int index) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for(int i=0;i<letters.length();i++) {
            combination.append(letters.charAt(i));
            backTrace(digits,combination,phoneMap,combinations, index+1);
            combination.deleteCharAt(index);
        }
    }
}
