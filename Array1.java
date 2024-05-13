package Array1;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter the numbers into the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter your number: ");
        int searchNumber = scanner.nextInt();

        int count = countOccurrences(numbers, searchNumber);

        if (count > 0) {
            System.out.println("The number " + searchNumber + " is present in the array " + count + " time(s).");
        } else {
            System.out.println("The number " + searchNumber + " is not present in the array");
        }
    }

    public static int countOccurrences(int[] numbers, int searchNumber) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                count++;
            }
        }
        return count;
    }
}