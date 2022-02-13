import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = _readInt(reader);
        for(int i = 0; i < total; i++) {
            int count = _readInt(reader);
            List<Integer> values = _readIntList(reader);

            // TODO add solution here

        }
        reader.close();
    }

    private static Map<Integer, Integer> _getCount(List<Integer> ints) {
        Map<Integer, Integer> result = new HashMap<>();
        for(Integer key: ints) {
            if(result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }
        return result;
    }

    private static List<Integer> _readIntList(BufferedReader reader) {
        try {
            String s = reader.readLine();
            return Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int[] _readIntArray(BufferedReader reader) {
        try {
            String s = reader.readLine();
            String[] sts = s.split(" ");
            int[] result = new int[sts.length];
            for(int i = 0; i < sts.length; i++) {
                result[i] = Integer.parseInt(sts[i]);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int _getMaxIndex(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    static int[] _concat(int[] array1, int[] array2) {
        if(array1 == null || array1.length == 0) {
            return array2;
        }
        if(array2 == null || array2.length == 0) {
            return array1;
        }
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    private static void _print(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[array.length-1]);
    }

    private static Integer _readInt(BufferedReader reader) {
        try {
            String s = reader.readLine();
            return Integer.parseInt(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BigDecimal _readBigDecimal(BufferedReader reader) {
        try {
            String s = reader.readLine();
            return new BigDecimal(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BigInteger _readBigInteger(BufferedReader reader) {
        try {
            String s = reader.readLine();
            return new BigInteger(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void _printBoolean(boolean b) {
        if(b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static double _logb(double x) {
        return Math.log(x)/Math.log(2.0);
    }

}
