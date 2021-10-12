package com.test;

import java.util.*;

public class Main {


    static String[] group1 = {"용태호김찬기윤종서오재영최세라", "김상진김형우이근희이희진정예지유지수"
                                , "한태준박지원장수옥이주훈장진영", "조준휘양성휘전용구이상준오도경"
                                , "신욱진최솔잎김바다배동민김자성", "최현준이다희김민정박상혁박동현"};


    //static List<String> list = Arrays.asList(listOfStudents);


    public static void main(String[] args) {

        VO vo = new VO();
        String[][] newGroup = new String[6][6];
        String[][] prevGroup = new String[7][5];
        String chosenPerson = "";
        boolean hasNull = false;
        StringBuffer sb = new StringBuffer();
        int n=0;
/*
        Group group = new Group();
        System.out.println(group.getGrouped());
        for (int i = 0; i < group1.length; i++) {
            sb.append(group1[i]);
        }
        String person = "최솔잎";
        for (int i = 0; i < group1.length; i++) {
            n = sb.indexOf(person);

        }
        System.out.println(n+"번째");
    }
}
*/

        vo.arrayNewGroup();
        vo.arrayPrevGroup();

        newGroup = vo.newGroup;
        prevGroup = vo.prevGroup;

        vo.findWhere1(vo.chosenPerson);
        vo.findWhere2(vo.chosenPerson);

        System.out.println(vo.chosenPerson);
        System.out.print("row1:" + vo.row1);
//        System.out.println(", column1:" + vo.column1);
        System.out.print("row2:" + vo.row2);
//        System.out.println(", column2:" + vo.column2);
        System.out.println();


        ArrayList<String> finalGroup = new ArrayList<>();


        while(finalGroup.size()<10) {
            vo.pickOne();
            System.out.println(vo.selectedPerson);
          if (!(finalGroup.contains(vo.selectedPerson)))
              finalGroup.add(vo.selectedPerson);
        }
        System.out.println(finalGroup);

    }
}

/*
        while (finalGroup.size() < 10) {
            vo.pickOne();
            System.out.println("selected:"+vo.selectedPerson);
            System.out.println("----------------------------");
            if (vo.selectedPerson == "") {
                hasNull++;
                if (hasNull > 5){
                    finalGroup.add(vo.selectedPerson);
                    System.out.println("adding: "+vo.selectedPerson);


                }
                System.out.println("hasNull: "+hasNull);
            } else if (finalGroup.contains(vo.selectedPerson)) {
                vo.pickOne();
                System.out.println("selected(else if):"+vo.selectedPerson);
            }


        }
        System.out.println(finalGroup);

    }
}



/*
        ArrayList finalGroup = new ArrayList();

        for (int i = 0; i < 31; i++) {
            chosenPerson=vo.pickOne();
            finalGroup.add(chosenPerson);
            System.out.println("chosenPerson: "+chosenPerson);
        }

        System.out.println(finalGroup);

*/


/*            int pickIndex = 0;
            pickIndex = (int) (Math.random() * 5);
            if(!group2[pickIndex].equals("신욱진")){
                group.add()
            }
*/



/*
    static String[] listOfStudents = {"용태호", "김찬기", "윤종서", "오재영", "최세라",
            "김상진", "김형우", "이근희", "이희진", "정예지", "유지수",
            "한태준", "박지원", "장수옥", "이주훈", "장진영",
            "조준휘", "양성휘", "전용수", "이상준", "오도경",
            "신욱진", "최솔잎", "김바다", "배동민", "김자성",
            "최현준", "이다희", "김민정", "박상현", "박동현"};
    static List<String> list = Arrays.asList(listOfStudents);


    public static void main(String[] args) {

        Collections.shuffle(list);
        System.out.println(list);

        for (int i = 0; i < 31 ; i++) {
            System.out.print(list.get(i)+" ");
            if((i%5)==0 && i!=0){
                System.out.println();
            }
        }
    }

 */
/////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////


  /*      HashSet<String> completedGroup;
        Group g = new Group();

//        String[][] allStudents = new String[5][6];

//            completedGroup = g.getGrouped();
        List<String> temp1 = new ArrayList<String>(g.getGrouped());
        List<String> temp2 = new ArrayList<String>(g.getGrouped());

//            System.out.println(completedGroup);

        int groupNumCnt = 0;


        //       for (int i = 0; groupNumCnt < 6 ; i++) {
        //           System.out.println(temp1);
        //           for (int j = 0; j < 5 ; j++) {

        System.out.println("clear전, temp1 : " + temp1);
        System.out.println("clear전, temp2 : " + temp2);
        System.out.println("------------------------------------------------\n");

        System.out.println(temp1);

        for (int i = 0; i < 6; i++) {

            if(!temp2.contains(temp1)) {
                System.out.println(temp2);
                temp1 = temp2;
                temp2.clear();
            }
            temp2 = new ArrayList<String>(g.getGrouped());

            System.out.println(i+"번째 도는중----------------------");


        }
    }
}

/*        }
        temp1 = temp2;
                    groupNumCnt++;
                    temp2 = new ArrayList<String>(g.getGrouped());
                    System.out.println("clear후: "+temp2);
                }

            }
        }
        }

        //       for (int i = 0; i < 5; i++) {
  //          System.out.println("list.get : " + list.get(i));
   //     }
*/