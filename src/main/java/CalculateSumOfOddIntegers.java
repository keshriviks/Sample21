public class CalculateSumOfOddIntegers {
    public static void main(String[] args) {
        int[] arr = {4, 5};

        calculate(arr);
    }

    static void calculate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int query = arr[i];
            int sum = calculateSum(query);
            System.out.println(sum);
        }
    }

    static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }
}

