#include "Sort.h"
using namespace std;

template<class T>
void printArray(T a[], int n)
{
	for (int i = 0; i < n; ++i)
	{
		cout << a[i] << " ";
	}
	cout << endl;
}

int main()
{
	for (int i = 1; i <= 8; ++i)
	{
		int arr[] = { 45, 38, 26, 77, 128, 38, 25, 444, 61, 153, 9999, 1012, 43, 128 };
		switch (i)
		{
		case 1:
			insert_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 2:
			bubble_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 3:
			select_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 4:
			shell_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 5:
			quick_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 6:
			merge_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 7:
			heap_sort(arr, sizeof(arr) / sizeof(arr[0]));
			break;
		case 8:
			lst_radix_sort(arr, sizeof(arr) / sizeof(arr[0]), 10, 4);
			break;
		default:
			break;
		}
		printArray(arr, sizeof(arr) / sizeof(arr[0]));
	}
	return 0;
}