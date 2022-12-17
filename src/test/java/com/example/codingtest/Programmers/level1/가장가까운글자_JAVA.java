package com.example.codingtest.Programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class 가장가까운글자_JAVA {

    @Test
    void main() {
        int[] result = solution("banana");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
            }else {
                int before = map.get(s.charAt(i));
                answer[i] = i - before;
                map.put(s.charAt(i), i);
            }
        }
        return answer;
    }


}
