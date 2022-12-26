package com.example.codingtest.Programmers.level1.가장가까운글자;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Java {

    @Test
    void main() {
        int[] result = solution("banana");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> charPositionMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int position = charPositionMap.getOrDefault(c, -1);
            charPositionMap.put(c, i);

            if (position != -1) {
                position = i - position;
            }

            answer[i] = position;
        }

        return answer;
    }


}
