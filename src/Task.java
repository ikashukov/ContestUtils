import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * Reading from STDIN:
 * - Integer _readInt(BufferedReader reader)
 * - Long _readLong(BufferedReader reader)
 * - BigInteger _readBigInteger(BufferedReader reader)
 * - BigDecimal _readBigDecimal(BufferedReader reader)
 * - List<Integer> _readIntList(BufferedReader reader)
 * - _readIntArray(BufferedReader reader)
 *
 * - <T> Map<T, Long> _getCount(Collection<T> values)
 * - _getMaxIndex(int[] array)
 * - int[] _concat(int[] array1, int[] array2)
 * - double _logb(double x)
 * - long _lcd(long a, long b)
 * - BigInteger _factorial(int i)
 * - BigInteger _pick(int i, int k)
 * - double _sqrt(double x)
 * - long _sqrt(long x)
 * - TreeMap<Long, Integer> _findDivisors(long x)
 * - _printArray(int[] array)
 * - _printBoolean(boolean b)
 */

public class Task {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int total = _readInt(reader);
    for (int _w = 0; _w < total; _w++) {
      int count = _readInt(reader);
      List<Integer> values = _readIntList(reader);

      // TODO add solution here

    }
    reader.close();
  }

  /*
  READING FROM STDIN
   */
  private static Integer _readInt(BufferedReader reader) {
    try {
      String s = reader.readLine();
      return Integer.parseInt(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static Long _readLong(BufferedReader reader) {
    try {
      String s = reader.readLine();
      return Long.parseLong(s);
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

  private static BigDecimal _readBigDecimal(BufferedReader reader) {
    try {
      String s = reader.readLine();
      return new BigDecimal(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
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
      for (int i = 0; i < sts.length; i++) {
        result[i] = Integer.parseInt(sts[i]);
      }
      return result;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /* AGGREGATE FUNCTIONS */

  private static <T> Map<T, Long> _getCount(Collection<T> values) {
    Map<T, Long> result = new HashMap<>();
    for (T key : values) {
      if (result.containsKey(key)) {
        result.put(key, result.get(key) + 1L);
      } else {
        result.put(key, 1L);
      }
    }
    return result;
  }

  private static int _getMaxIndex(int[] array) {
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > array[max]) {
        max = i;
      }
    }
    return max;
  }


  /* PROCESSING */

  static int[] _concat(int[] array1, int[] array2) {
    if (array1 == null || array1.length == 0) {
      return array2;
    }
    if (array2 == null || array2.length == 0) {
      return array1;
    }
    int[] result = Arrays.copyOf(array1, array1.length + array2.length);
    System.arraycopy(array2, 0, result, array1.length, array2.length);
    return result;
  }


  /* MATH */


  private static double _logb(double x) {
    return Math.log(x) / Math.log(2.0);
  }

  private static long _lcd(long a, long b) {
    if(a < b) {
      long t = a;
      a = b;
      b = t;
    }
    long t = a%b;
    if(t == 0) {
      return b;
    }
    return _lcd(b, t);
  }

  private static final Map<Integer, BigInteger> FACTORIALS = new HashMap<>();
  private static int MAX_F = 1;
  private static BigInteger _factorial(int i) {
    FACTORIALS.put(0, BigInteger.ONE);
    FACTORIALS.put(1, BigInteger.ONE);
    if(i <= MAX_F) {
      return FACTORIALS.get(i);
    }
    for(int j = MAX_F+1; j <= i; j++) {
      FACTORIALS.put(j, FACTORIALS.get(j-1).multiply(BigInteger.valueOf(j)));
    }
    MAX_F = i;
    return FACTORIALS.get(i);
  }

  private static BigInteger _pick(int n, int k) {
    return _factorial(n).divide(_factorial(k)).divide(_factorial(k));
  }

  private static long _sqrt(long x) {
    return BigInteger.valueOf(x).sqrt().longValue();
  }

  private static double _sqrt(double x) {
    return BigDecimal.valueOf(x).sqrt(MathContext.DECIMAL128).doubleValue();
  }

  private static TreeMap<Long, Integer> _findDivisors(long x) {
    TreeMap<Long, Integer> result = new TreeMap<>();
    long end = _sqrt(x);
    if(x % end != 0) {
      end++;
    }
    for (long i = 2; i <= end; i++) {
      if (i > x) {
        break;
      }
      while (x % i == 0) { // divisor
        x /= i;
        if(result.containsKey(i)) {
          result.put(i, result.get(i) + 1);
        } else {
          result.put(i, 1);
        }
      }
    }
    if(x >= 2L && result.isEmpty()) {
      result.put(x, 1);
    }
    return result;
  }

  /* WRITING TO STDOUT */


  private static void _printArray(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println(array[array.length - 1]);
  }

  private static void _printBoolean(boolean b) {
    if (b) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

}
