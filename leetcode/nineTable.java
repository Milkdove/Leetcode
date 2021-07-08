package leetcode;

public class nineTable {
    public static void print() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i <= j)
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print();
    }
}
