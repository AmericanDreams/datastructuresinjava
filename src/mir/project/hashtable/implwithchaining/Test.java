package mir.project.hashtable.implwithchaining;

public class Test {
    public static void main(String[] args) {
        HashTableWithChaining<Integer> hashTableWithChaining = new HashTableWithChaining<>();
        hashTableWithChaining.put("bir", 1);
        hashTableWithChaining.put("iki", 2);
        hashTableWithChaining.put("bes", 5);

        System.out.println(hashTableWithChaining.get("bir"));
        System.out.println(hashTableWithChaining.get("iki"));
        System.out.println(hashTableWithChaining.get("bes"));

        System.out.println(hashTableWithChaining.put("bes",44));

        System.out.println(hashTableWithChaining.get("bes"));

        System.out.println("SIZE " + hashTableWithChaining.size());

        System.out.println(hashTableWithChaining.remove("aa"));
        System.out.println(hashTableWithChaining.remove("iki"));
        System.out.println(hashTableWithChaining.get("iki"));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
