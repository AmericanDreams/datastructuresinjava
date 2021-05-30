package mir.project.tst.impl2;

public class Test {
    public static void main(String[] args) {
        AAWithTST tst = new AAWithTST();
        System.out.println(tst.putRecursively("apple", "apple"));
        System.out.println(tst.putRecursively("apar", "apar"));

//        System.out.println(tst.getRecursively("apple"));
//        System.out.println(tst.getRecursively("apar"));

        tst.traverse();
    }
}
