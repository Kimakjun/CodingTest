package com.example.codingtest.Programmers.level1.성격유형검사하기;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Java {

    @Test
    void main() {
        solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] scores = {3, 2, 1, 0, 1, 2, 3};

        HashMap<java.lang.Character, Integer> characterScore = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            int score = scores[choice - 1];

            if (choice == 4) continue;
            if (choice < 4) characterScore.compute(survey[i].charAt(0), (k, v) -> (v == null) ? score : v + score);
            if (choice > 4) characterScore.compute(survey[i].charAt(1), (k, v) -> (v == null) ? score : v + score);
        }

        System.out.println(characterScore.toString());

        List<Pair> indicators = new ArrayList() {{
            add(new Pair('R', 'T'));
            add(new Pair('C', 'F'));
            add(new Pair('J', 'M'));
            add(new Pair('A', 'N'));
        }};

        for (Pair indicator : indicators) {
            char indicatorA = indicator.getFirst();
            char indicatorB = indicator.getSecond();

            int indicatorAscore = characterScore.getOrDefault(indicatorA, 0);
            int indicatorBscore = characterScore.getOrDefault(indicatorB, 0);

            if (indicatorAscore == indicatorBscore) {
                answer += indicator.getFastOrder();
            }

            if (indicatorAscore > indicatorBscore) {
                answer += indicator.getFirst();
            }
            if (indicatorAscore < indicatorBscore) {
                answer += indicator.getSecond();
            }

        }

        return answer;
    }

}

class Pair {
    private char first;
    private char second;

    public Pair(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public char getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }

    char getFastOrder() {
        if (first - second > 0) return second;
        else return first;
    }

}
