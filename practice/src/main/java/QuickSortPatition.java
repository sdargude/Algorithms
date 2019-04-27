public class QuickSortPatition {


    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    static int partition (int a[], int start, int end, int pivot) {

        int n = 0;
        swap(a,pivot,end);

        for (int i = 0; i <end; i++) {
            if (a[i] < a[end]) {
                swap(a,i,n);
                n++;
            }
        }

        swap(a,end,n);
        return n;
    }

    public static void main(String args[]) {

        int a[] = {5,1,9,2,4,6};


        for( int x:a ) {
            System.out.print(x + " ");
        }
        System.out.println();

        int new_pivot = partition(a,0,a.length-1, 0);

        System.out.println("New Pivot = " + new_pivot);

        for( int x:a ) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


}
