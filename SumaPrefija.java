public class SumaPrefija {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java SumaPrefija <número> <números enteros>");
            return;
        }

        int targetSum = Integer.parseInt(args[0]);
        int[] numbers = new int[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            numbers[i - 1] = Integer.parseInt(args[i]);
        }

        int[] prefixSum = new int[numbers.length];
        prefixSum[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        System.out.println("Suma prefija:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + ", " + prefixSum[i]);
        }

        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == targetSum) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        System.out.println(found ? "Si" : "No");
    }
}
