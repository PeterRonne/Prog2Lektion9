package opgave03;

import opgave03.models.ArrayListRing;

public class Opgave03 {
    public static void main(String[] args) {

        ArrayListRing<Integer> intergerRing = new ArrayListRing<>();


        intergerRing.add(1);
        intergerRing.add(2);
        intergerRing.add(3);

        intergerRing.map(num -> num * 4);


//        intergerRing.add(6);
//        intergerRing.add(7);
//        intergerRing.add(8);
//        intergerRing.add(9);
//        intergerRing.add(10);

        intergerRing.print();
        System.out.println();

        System.out.println(intergerRing.getCurrentItem());

        System.out.println();
        ArrayListRing strinRing = new ArrayListRing<>();

        strinRing.add("Hej");
        strinRing.add("Hello");
        strinRing.add("Hola");
        strinRing.add("Bonjour");
        strinRing.add("Konnichiwa");

        strinRing.map(s -> s + " hej");
        strinRing.print();

        System.out.println("strinRing.getCurrentItem() = " + strinRing.getCurrentItem());


    }

}
