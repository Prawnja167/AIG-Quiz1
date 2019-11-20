public class BubbleSort {
    int [] arr = new int[10];
    boolean isSwapped;

    public void printArray(int[] arr) {
        for (int i=0; i<9; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public void doSort(int[] arr) {
        for (int i=0; i<9-1; i++) {
            isSwapped = false;

            for (int j=0; j<9-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
        }

        printArray(arr);
    }

    public BubbleSort() {
        arr = new int[]{9,8,7,6,5,4,3,2,1};
        doSort(arr);
    }
}
