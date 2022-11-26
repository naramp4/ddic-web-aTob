package io.goorm.basicJava;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaBasic {
    public static void main(String[] args){
        /*
        * 숫자형
        */
        int a = 1;
//        int v = 1.1;
        double b = 1.1;
        System.out.println(a);
        System.out.println(b);
        System.out.println("----------");
        /*
         * 문자
         */
        char charVar = 'a';
//        char charVar2 = 'adf';
//        char charVar3 = "a";
        System.out.println(charVar);
        System.out.println("----------");
        /*
         * 문자열
         */
        String strVar = "a";
        String strVar2 = "hello World";
        System.out.println(strVar2);

        System.out.println("strVar" + strVar2);
        System.out.println("----------");

        /*
        * 연산
        */


        // int형
        int x = 6;
        int y = 3;
        int z;
        System.out.println( x + y);
        System.out.println( x * y);
        System.out.println( x / y);

        System.out.println( x++ );
        System.out.println( x );

        // string형
        System.out.println("안녕하세요" + " java입니다.");

        // string형 + int형
        System.out.println("a" + 1 + 2);
        System.out.println("a" + (1 + 2));
        System.out.println("----------");
        /*
        * Boolean 데이터 타입
        */
        //int형
        System.out.println(x > y);
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println(x == y);
        System.out.println("----------");

        //String형
        strVar = "hello";
        strVar2 = "hello";
        String strVar3 = new String("hello");
        System.out.println(strVar == strVar2);
        System.out.println(strVar == strVar3);
        System.out.println(strVar.equals(strVar3));
        System.out.println("----------");

        //논리연산
        boolean t = true;
        boolean f = false;

        System.out.println(t && t);
        System.out.println(t && f);
        System.out.println(f && f);

        /*
        * if 조건문
        */

        int intVar1 = 1;
        int intVar2 = 2;

        if (intVar1 > intVar2){
            System.out.println("참입니다.");
        }else{
            System.out.println("거짓입니다.");
        }
        System.out.println("----------");

        /*
        * for문
        */
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        /*
        * 배열
        */
        // 정수형 배열
        int[] odds = {1, 3, 5, 7, 9};
        // 문자열 배열
        String[] fruits1 = {"apple", "mango", "banana"};
        // or
        String[] fruits2 = new String[3];
        fruits2[0] = "apple";
        fruits2[1] = "mango";
        fruits2[2] = "banana";

        // 오류발생
//        String[] fruits = new String[];

        /*
        *  리스트
        */

        ArrayList fruitList = new ArrayList();
        fruitList.add("abc");
        fruitList.add(1);
        fruitList.add("2");

        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(fruitList.get(i));
            String listTest;
//            listTest = fruitList.get(i);
        }

        ArrayList<String> fruitList2 = new ArrayList();
        fruitList2.add("abc");
        fruitList2.add("1");
        fruitList2.add("2");

        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(fruitList.get(i));
            String listTest;
            listTest = fruitList2.get(i);
        }

        /*
        * 맵(Map)
        */

        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");

        System.out.println(map.get("people"));

        /*
        * final
        */

        final double fi = 3.14;
//        fi = 3;












    }
}
