public class ds_06{
    public static void main(String[] var0) {
        int[] a = {55,66,88,41,92,46,71,52,36,91};
        int max = a[0];

        for (int i=1; i<a.length; i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.println("最大值：" + max);
    }
    
}