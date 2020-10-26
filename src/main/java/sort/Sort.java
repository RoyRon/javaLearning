package sort;

public class Sort {
    public static int[] bubbleSort(int[] ints) {
        int tmp;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    tmp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
        return ints;
    }

    public static int[] selectionSort(int[] ints) {
        int minIndex;
        int tmp;
        for (int i = 0; i < ints.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = ints[i];
            ints[i] = ints[minIndex];
            ints[minIndex] = tmp;
        }
        return ints;
    }

    public static int[] insertSort(int[] ints) {
        int preIndex;
        int current;
        for (int i = 1; i < ints.length; i++) {
            preIndex = i - 1;
            current = ints[i];
            while (preIndex >= 0 && current < ints[preIndex]) {
                ints[preIndex + 1] = ints[preIndex];
                preIndex--;
            }
            ints[preIndex + 1] = current;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] testData = {9, 8, 7, 6, 5, 4, 3, 2, 2, 0, 1};
        int[] output = null;
//        output = Sort.bubbleSort(testData);
//        output = Sort.selectionSort(testData);
        output=Sort.insertSort(testData);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
