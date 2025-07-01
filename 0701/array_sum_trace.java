public class array_sum_trace {

    public static void main(String[] args) {
        int[] n = {1,3,5};
        int sum = 0;

        for(int i = 0 ; i < n.length ; i++){
            int  total = sum;
            sum += n [i];

            System.out.println("加總過程="+ total + "+" + n[i] + "=" + sum );
        }
        System.out.println("總和為="+ sum );

    }
}
