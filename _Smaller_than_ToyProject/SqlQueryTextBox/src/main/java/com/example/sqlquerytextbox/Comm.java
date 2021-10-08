package com.example.sqlquerytextbox;

public class Comm {

    public String getQuery(String query)
    {
        if(query.contains(";")){

            StringBuffer sb = new StringBuffer();
            sb.append(query);
            int index = sb.indexOf(";");
            sb.deleteCharAt(index);
            query = sb.toString().toUpperCase();
            System.out.println("; << deleted");
        }
        else
            query = query.toUpperCase();

        return query;
    }



    public String getKeyword(String query){

        char letter=' ';
        String keyword="";
        boolean wordIsFound = false;


        for (int i = 0; !wordIsFound ; i++) {
            System.out.println("----------------");

            /*
            find first letter of word :
            is not "" and has next variable letter */
            if (letter != (query.charAt(i)) && letter != (query.charAt(i + 1))) {
                System.out.println("---1query.chartAt[i]: " + query.charAt(i));
                keyword += query.charAt(i);
            /*
            find last letter of word :
            is not "" and has "" as next letter */
            } else if (letter != (query.charAt(i)) && letter == (query.charAt(i + 1))) {
                System.out.println("---2query.chartAt[i]: " + query.charAt(i));
                keyword += query.charAt(i);
                wordIsFound = true;
            }
        }
        return keyword;
    }
}
