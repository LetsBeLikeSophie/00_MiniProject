package com.test;

import java.lang.reflect.Array;
import java.util.*;

public class Group {

    String[] listOfStudents = {"용태호", "김찬기", "윤종서", "오재영", "최세라",
            "김상진", "김형우", "이근희", "이희진", "정예지", "유지수",
            "한태준", "박지원", "장수옥", "이주훈", "장진영",
            "조준휘", "양성휘", "전용구", "이상준", "오도경",
            "신욱진", "최솔잎", "김바다", "배동민", "김자성",
            "최현준", "이다희", "김민정", "박상혁", "박동현"};
    List<String> list = Arrays.asList(listOfStudents);

    HashSet<String> getGrouped() {

        HashSet<String> grouped = new HashSet<String>();

            for (int j = 0; grouped.size() < 5; j++) {
                int pickIndex = 0;
                pickIndex = (int) (Math.random() * 30) + 1;
                grouped.add(listOfStudents[pickIndex]);
            }

        return grouped;
    }



    public void shuffled(){




    }
}
