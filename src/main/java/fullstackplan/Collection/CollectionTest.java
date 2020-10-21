package fullstackplan.Collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest {
    public static void main(String[] args){
        Map map= new HashMap();
        map.put("1","a");
        map.put("1","b");
        System.out.println("map对同一个key赋值，新值会覆盖旧值"+map);
    }
}
