package mir.project.array;

public class Test {

    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[2];
        array[1] = new int[4];

        System.out.println(array.length + " " + array[0].length + " " + array[1].length);
    }
}
