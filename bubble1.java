package bubble;

public class bubble1 {
        public static void main(String[] args) {
            char[] arr = {'d', 'b', 'a', 'c', 'e'};
            System.out.println("Original array: ");
            printArray(arr);
            bubbleSort(arr);
            System.out.println("Sorted array: ");
            printArray(arr);
        }

        public static void bubbleSort(char[] arr) {
            int n = arr.length;
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        // Swap arr[i] and arr[i + 1]
                        char temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }

        public static void printArray(char[] arr) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

}
