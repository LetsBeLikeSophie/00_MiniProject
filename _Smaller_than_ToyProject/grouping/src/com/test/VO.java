package com.test;

import java.util.ArrayList;
import java.util.Random;

public class VO {

    static final String[] students1 = {"용태호", "김찬기", "윤종서", "오재영", "최세라", "빈칸1",
            "한태준", "박지원", "장수옥", "이주훈", "장진영", "빈칸2",
            "김상진", "김형우", "이근희", "이희진", "정예지", "유지수",
            "조준휘", "양성휘", "전용구", "이상준", "오도경", "빈칸3",
            "신욱진", "최솔잎", "김바다", "배동민", "김자성", "빈칸4",
            "최현준", "이다희", "김민정", "박상혁", "박동현", "빈칸5"};

    static final String[] students2 = {  "신욱진", "용태호", "이희진", "정예지", "빈칸1",
            "김상진", "한태준", "김민정", "박지원", "최현준",
            "최솔잎", "유지수", "이상준", "양성휘", "박동현",
            "배동민", "김형우", "최세라", "이다희", "빈칸2",
            "윤종서", "조준휘", "장수옥", "오재영", "빈칸3",
            "최현준", "이근희", "김바다", "김찬기", "전용구",
            "박상혁", "장진영", "오도경", "이주훈", "빈칸4"};

    static ArrayList students3 = new ArrayList();

    public String[][] newGroup = new String[6][6];
    public String[][] prevGroup = new String[7][5];
    public String chosenPerson = "최솔잎";

    void arrayNewGroup() {
        int n = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                newGroup[i][j] = students1[n];
                n++;
            }
        }
    }

    void arrayPrevGroup() {
        int n = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                prevGroup[i][j] = students2[n];
                n++;
            }
        }
    }

    public int row1 = 0;
//    public int column1 = 0;

    public void findWhere1(String person){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (newGroup[i][j] == person) {
                    row1 = i;
 //                   column1 = j;
                }
            }
        }
    }



    public String selectedPerson;

    int row2 = 0;
//    int column2 = 0;

    public void findWhere2(String person){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (prevGroup[i][j] == person) {
                    row2 = i;
//                    column2 = j;
                }
            }
        }
    }

    int rowSP = 0;
//    int columnSP = 0;

    public void findWhere3(String person){

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (prevGroup[i][j] == person) {
                    rowSP = i;
//                    columnSP = j;
                }
            }
        }
    }

    void pickOne() {

        int randomRow = 0;
        int randomColumn = 0;

        Random rd = new Random();

        randomRow = rd.nextInt(6);
        randomColumn = rd.nextInt(6);

        System.out.println("randomRow: " + randomRow);
        System.out.println("randomColumn: " + randomColumn);

        selectedPerson = newGroup[randomRow][randomColumn];
        findWhere3(selectedPerson);

        if ((randomRow == row1)||(rowSP == row2)) {
            System.out.println("re-picking");
            pickOne();
        }

        else {
            selectedPerson = newGroup[randomRow][randomColumn];
            System.out.println("final selected Person" + selectedPerson);
        }




    }

}

