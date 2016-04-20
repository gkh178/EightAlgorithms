public class TestEightAlgorithms {

	public static void printArray(int a[], int n) {
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
			if ( i == n - 1) {
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 8; ++i) {
			int arr[] = {45, 38, 26, 77, 128, 38, 25, 444, 61, 153, 9999, 1012, 43, 128};
			switch(i) {
			case 1:
				EightAlgorithms.insertSort(arr, arr.length);
				break;
			case 2:
				EightAlgorithms.bubbleSort(arr, arr.length);
				break;
			case 3:
				EightAlgorithms.selectSort(arr, arr.length);
				break;
			case 4:
				EightAlgorithms.shellSort(arr, arr.length);
				break;
			case 5:
				EightAlgorithms.quickSort(arr, arr.length);
				break;
			case 6:
				EightAlgorithms.mergeSort(arr, arr.length);
				break;
			case 7:
				EightAlgorithms.heapSort(arr, arr.length);
				break;
			case 8:
				EightAlgorithms.lstRadixSort(arr, arr.length, 10, 4);
				break;
			default:
				break;
			}
			printArray(arr, arr.length);
		}
	}
}
