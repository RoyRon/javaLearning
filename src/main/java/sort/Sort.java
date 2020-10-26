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

    public static int[] shellSort(int[] ints) {
        int len = ints.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = ints[i];
                while (j - gap >= 0 && current < ints[j - gap]) {
                    ints[j] = ints[j - gap];
                    j = j - gap;
                }
                ints[j] = current;
            }
        }
        return ints;
    }

    public static int[] merge(int[] ints, int left, int mid, int right) {
        int leftStart=left;
        int[] tmp = new int[right - left + 1];
        int rightStart = mid + 1;
        int i = 0;
        while (leftStart <=mid&&rightStart<=right) {
            if (ints[leftStart] < ints[rightStart]) {
                tmp[i++] = ints[leftStart++];
            } else {
                tmp[i++] = ints[rightStart++];
            }
        }
        while (leftStart <= mid) {
            tmp[i++] = ints[leftStart++];
        }
        while (rightStart <= right) {
            tmp[i++] = ints[rightStart++];
        }
        for (int j = 0; j < tmp.length; j++) {
            ints[left+j] = tmp[j];
        }
        return ints;
    }

    public static int[] mergeSort(int[] ints, int left, int right) {
        if (left < right) {
            int mid = ((left + right) / 2);
            mergeSort(ints, left, mid);
            mergeSort(ints, mid + 1, right);
            ints = merge(ints, left, mid, right);
        }
        return ints;
    }


    public static void main(String[] args) {
//        int[] testData = {9, 8, 7, 6, 5, 4, 3, 2, 2, 0, 1};
        int[] testData = {9};
        int[] output = null;
//        output = Sort.bubbleSort(testData);
//        output = Sort.selectionSort(testData);
//        output=Sort.insertSort(testData);
//        output = Sort.shellSort(testData);
        output=mergeSort(testData,0,testData.length-1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
