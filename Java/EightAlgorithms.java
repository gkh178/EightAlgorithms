import java.util.Arrays;
/*
 * ʵ���˰˸����õ������㷨����������ð������ѡ������ϣ������
 * �Լ��������򡢹鲢���򡢶������LST��������
 * @author gkh178
 */
public class EightAlgorithms {
	
	//��������ʱ�临�Ӷ�o(n^2) 
	public static void insertSort(int a[], int n) {
		for (int i = 1; i < n; ++i) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > temp) {
				a[j + 1] =a[j];
				--j;
			}
			a[j + 1] = temp;
		}
	}
	
	//ð������ʱ�临�Ӷ�o(n^2)  
	public static void bubbleSort(int a[], int n) {
		for (int i = n - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;		
				}
			}	
		}	
	}
	
	//ѡ������ʱ�临�Ӷ�o(n^2)  
	public static void selectSort(int a[], int n) {
		for (int i = 0; i < n - 1; ++i) {
			int min = a[i];
			int index = i;
			for (int j = i + 1; j < n; ++j) {
				if (a[j] < min) {
					min = a[j];
					index = j;
				}	
			}
			a[index] = a[i];
			a[i] = min;
		}
	}
	
	//ϣ������ʱ�临�ӶȽ���o(n^2)��o(nlgn)֮��  
	public static void shellSort(int a[], int n) {
		for (int gap = n / 2; gap >= 1; gap /= 2) {
			for (int i = gap; i < n; ++i) {
				int temp = a[i];
				int j = i -gap;
				while (j >= 0 && a[j] > temp) {
					a[j + gap] = a[j];
					j -= gap;
				}
				a[j + gap] = temp;
			}
		}	
	}
	
	//��������ʱ�临�Ӷ�o(nlgn)  
	public static void quickSort(int a[], int n) {
		_quickSort(a, 0, n-1);
	}
	public static void _quickSort(int a[], int left, int right) {
		if (left < right) {
			int q = _partition(a, left, right);
			_quickSort(a, left, q - 1);
			_quickSort(a, q + 1, right);
		}
	}
	public static int _partition(int a[], int left, int right) {
		int pivot = a[left];
		while (left < right) {
			while (left < right && a[right] >= pivot) {
				--right;
			}
			a[left] = a[right];
			while (left <right && a[left] <= pivot) {
				++left;
			}
			a[right] = a[left];
		}
		a[left] = pivot;
		return left;
	}
	
	//�鲢����ʱ�临�Ӷ�o(nlgn) 
	public static void mergeSort(int a[], int n) {
		_mergeSort(a, 0 , n-1);
	}
	public static void _mergeSort(int a[], int left, int right) {
		if (left <right) {
			int mid = left + (right - left) / 2;
			_mergeSort(a, left, mid);
			_mergeSort(a, mid + 1, right);
			_merge(a, left, mid, right);
		}
	}
	public static void _merge(int a[], int left, int mid, int right) {
		int length = right - left + 1;
		int newA[] = new int[length];
		for (int i = 0, j = left; i <= length - 1; ++i, ++j) {
			newA[i] = a[j];
		}
		int i = 0;
		int j = mid -left + 1;
		int k = left;
		for (; i <= mid - left && j <= length - 1; ++k) {
			if (newA[i] < newA[j]) {
				a[k] = newA[i++];
			}
			else {
				a[k] = newA[j++];
			}
		}
		while (i <= mid - left) {
			a[k++] = newA[i++];
		}
		while (j <= right - left) {
			a[k++] = newA[j++];
		}
	}
	
	//������ʱ�临�Ӷ�o(nlgn) 
	public static void heapSort(int a[], int n) {
		builtMaxHeap(a, n);//������ʼ�����
		//������βԪ�أ����Խ������ų�βԪ�ص��������һ���ϵ���
		for (int i = n - 1; i >= 1; --i) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			upAdjust(a, i);
		}
	}
	//����һ������Ϊn�Ĵ����
	public static void builtMaxHeap(int a[], int n) {
		upAdjust(a, n);
	}
	//�Գ���Ϊn���������һ���ϵ���
	public static void upAdjust(int a[], int n) {
		//��ÿ��������Ů�ڵ��Ԫ�ر��������Ӻ󵽸��ڵ�λ��
		for (int i = n / 2; i >= 1; --i) {
			adjustNode(a, n, i);
		}
	}
	//�������Ϊi�Ľڵ��ֵ
	public static void adjustNode(int a[], int n, int i) {
		//�ڵ������Һ���
		if (2 * i + 1 <= n) {
			//�Һ��ӵ�ֵ���ڽڵ��ֵ����������
			if (a[2 * i] > a[i - 1]) {
				int temp = a[2 * i];
				a[2 * i] = a[i - 1];
				a[i - 1] = temp;
			}
			//���ӵ�ֵ���ڽڵ��ֵ����������
			if (a[2 * i -1] > a[i - 1]) {
				int temp = a[2 * i - 1];
				a[2 * i - 1] = a[i - 1];
				a[i - 1] = temp;
			}
			//�Խڵ�����Һ��ӵĸ��ڵ���е���
			adjustNode(a, n, 2 * i);
			adjustNode(a, n, 2 * i + 1);
		}
		//�ڵ�ֻ�����ӣ�Ϊ���һ�������Һ��ӵĽڵ�
		else if (2 * i == n) {
			//���ӵ�ֵ���ڽڵ��ֵ����������
			if (a[2 * i -1] > a[i - 1]) {
				int temp = a[2 * i - 1];
				a[2 * i - 1] = a[i - 1];
				a[i - 1] = temp;
			}	
		}
	}
	
	//���������ʱ�临�Ӷ�Ϊo(distance(n+radix)),distanceΪλ����nΪ���������radixΪ����
	//����������LST�������л�������MST��������������
	//���в���radixΪ������һ��Ϊ10��distance��ʾ�������������������λ����nΪ����ĳ���
	public static void lstRadixSort(int a[], int n, int radix, int distance) {
		int[] newA = new int[n];//�����ݴ�����
		int[] count = new int[radix];//���ڼ������򣬱�����ǵ�ǰλ��ֵΪ0 �� radix-1��Ԫ�س��ֵĵĸ���
		int divide = 1;
		//�ӵ�����һλ������һλ
		for (int i = 0; i < distance; ++i) {
			System.arraycopy(a, 0, newA, 0, n);//�������鿽����newA������
			Arrays.fill(count, 0);//������������0
			for (int j = 0; j < n; ++j) {
				int radixKey = (newA[j] / divide) % radix; //�õ�����Ԫ�صĵ�ǰ����λ��ֵ
				count[radixKey]++;
			}
			//��ʱcount[]��ÿ��Ԫ�ر������radixKeyλ���ֵĴ���
			//����ÿ��radixKey�������еĽ���λ�ã�λ����ŷ�ΧΪ1-n
			for (int j = 1; j < radix; ++j) {
				count[j] = count[j] + count[j - 1];
			}
			//���ü��������ԭ��ʵ��һ���������������������a[]
			for (int j = n - 1; j >= 0; --j) {
				int radixKey = (newA[j] / divide) % radix;
				a[count[radixKey] - 1] = newA[j];
				--count[radixKey];
			}
			divide = divide * radix;
		}
	}
}
