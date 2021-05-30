package mir.project.tst.impl;

public class Test {
    public static void main(String[] args) {
        TST tst = new TST();
        System.out.println(tst.insert("saldim"));
        System.out.println(tst.insert("salam"));
        System.out.println(tst.insert("salximi"));

        //System.out.println(tst.find("bus"));
        System.out.println(tst.find("saldim"));
        System.out.println(tst.find("salam"));
        System.out.println(tst.find("salximi"));

    }
}
