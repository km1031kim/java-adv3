package functional;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();


        list1.add("appel");
        list1.add("banana");
        changeList(list1);
        System.out.println("after list = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");

        // 함수형 프로그래밍에서는 원본 데이터를 건들지 않는다.
        List<String> newList = changeList2(list2);
        System.out.println("list2 = " + list2);
        System.out.println("newList = " + newList);

    }

    private static List<String> changeList2(List<String> list2) {
        List<String> newList = new ArrayList<String>();
        for (String s : list2) {
            newList.add(s);
        }
        return newList;
    }

    private static void changeList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + " _compelete");
        }
    }
}
