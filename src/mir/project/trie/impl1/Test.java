package mir.project.trie.impl1;

public class Test {
    public static void main(String[] args) {
//        AssociativeArrayWithTrie associativeArrayWithTrie = new AssociativeArrayWithTrie();
//        associativeArrayWithTrie.insert(" ", "ROOT");
//        //trie.insert("ana", "ANA");
//        associativeArrayWithTrie.insert("de", "DE");
//        associativeArrayWithTrie.insert("anam", "ANAM");
//        associativeArrayWithTrie.insert("ata", "ATA");
//        associativeArrayWithTrie.insert("aza", "AZA");
//
//        associativeArrayWithTrie.traverse("in-order");
//
////        System.out.println(associativeArrayWithTrie.remove("anam"));
////        associativeArrayWithTrie.traverse("in-order");
//
//        //System.out.println(trie.search("aza" ));

        Trie trie = new Trie();
//        System.out.println(trie.insert("salam"));
//        System.out.println(trie.insert("salam"));
//
//        System.out.println(trie.search("sal"));
//        System.out.println(trie.search("salam"));
//
//        System.out.println(trie.remove("sal"));
//        System.out.println(trie.remove("salam"));
//
//        System.out.println(trie.insert("salama"));
//        System.out.println(trie.insert("sal"));
//        System.out.println(trie.insert("salam"));
//
//        System.out.println(trie.remove("sal"));

        System.out.println(trie.insert("salam"));
        System.out.println(trie.insert("saldim"));
        System.out.println(trie.insert("salxim"));



        trie.autoComplete("sal").forEach(a -> System.out.println(a));

        System.out.println(trie.getLongestCommonPrefix());



    }
}
