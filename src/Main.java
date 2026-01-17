import java.util.Arrays;

public class Main{

    // ========= SORTING =========
    //SelectionSort Aldorithm:
    public static int []SelectionSort(int []arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min_idx=i;
            for(int j=i+1;j<n;j++){
                if(arr[min_idx]<arr[j]){
                    min_idx=j;
                }
            }
            int k=arr[i];
            arr[i]=arr[min_idx];
            arr[min_idx]=k;
        }
        return arr;
    }
    //************************************************************************

    //BubbleSort Algorithm:
    public static int [] BubbleSort(int [] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n;j++){
                if(arr[j]>arr[j+1]){
                    int k=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=k;
                }
            }
        }
        return arr;
    }
//************************************************************************

    //InsertionSort Algorithm:
    public static int []InsertionSort(int []arr){
        int n=arr.length;
        for(int i=2;i<n;i++)
        {
            int key=arr[i];
            int j=i-1;

            while (j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=key;
        }
        return arr;
    }
    //QuickSort Algorithm
    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            QuickSort(arr, low, pivotIndex - 1);
            QuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    //************************************************************************
    //MergeSort Algorithm
    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++]; 
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }
    // ========= SEARCH =========
    //LinearSearch Algorithm:
    public static int LinearSearch(int[] arr ,int key) {
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }
    //BinarySearch Algorithm without Recursion:
    public static int BinarySearch(int[] arr, int key){
        int n=arr.length;
        int l=0 ,r =n-1,mid;
        while (l<=r){
            mid=(l+r)/2;
            if (arr[mid]<key){
                l=mid+1;
            }
            else if(arr[mid]>key){
                r=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    // ========= MAIN =========
    public static void main(String[] args) {
        new AlgoGUI(); // تشغيل الـ GUI
    }
}