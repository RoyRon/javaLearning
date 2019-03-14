package TencentClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 江映锋
 * Create on 2019/03/14
 */
public class CollectionTest {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "a", "a"};
        CollectionTest.printWordCount(strings);
    }

    public static void printWordCount(String[] args) {

        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < args.length; i++) {
            if (!map.containsKey(args[i])) {
                map.put(args[i], 1);
            } else {
                int freq = map.get(args[i]);
                map.put(args[i], freq +1);  //一开始这里写成了freq++；结果导致输出结果计数不正确，说明没有正确理解freq++计算，先使用freq再将freq加1，所以加入map的值一直都是1
            }


        }
        System.out.println(map);

    }

    public static void printWordCount2(String[] args) {

        Map<String, Integer> map = new HashMap();
        Integer freq = null;
        for (int i = 0; i < args.length; i += 1) {
            map.put(args[i], freq = map.get(args[i]) == null ? 1 : freq.intValue() + 1);


        }
        System.out.println(map);

    }
}
