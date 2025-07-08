public class BasicArrayOperations {
    public static void main(String[] args) {
        int[]arr = {15, 28, 7, 42, 91, 33, 66, 58,24, 81};
        System.out.println("陣列長度："+arr.length);
        arr[2] = 99;
        arr[9] = 100;
        for (int i =0; i<arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
