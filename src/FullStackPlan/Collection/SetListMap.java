package FullStackPlan.Collection;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class SetListMap {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);
//        set.add("1");
//        set.add(null);
//        set.add(true);
//        set.add(new SetListMap());
//        set.add("最有趣的天才");
//        System.out.println("输出set："+set);
//        System.out.println("输出set.first()："+ ((TreeSet) set).first());
//        System.out.println("输出set.last()："+ ((TreeSet) set).last());
//        System.out.println("输出set.lower()："+ ((TreeSet) set).lower(3));  //小于3
//        System.out.println("输出set.floor()："+ ((TreeSet) set).floor(3)); //小于等于3
//        System.out.println("输出set.ceiling()："+    ((TreeSet) set).ceiling(3));
//        System.out.println("输出set.remove()："+    ((TreeSet) set).remove(3));
//
//        System.out.println("输出set："+set);


        List list = new ArrayList();
        list.add(2);
        list.add("天才");
        list.add('苏');
        list.add(true);
        list.add(null);
//        System.out.println("输出list"+list);
//        System.out.println("返回第三个元素"+list.get(2));
//        System.out.println("删除最后一个元素"+list.remove(list.size()-1));
//        System.out.println("输出list"+list);
//        Iterator iterator=list.iterator();
//        while (iterator.hasNext()){
//           System.out.println(iterator.next());
//        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {

            System.out.println(listIterator.next()); //不调用next()方法，ListIterator的指针不移动
           listIterator.add("dd");
            System.out.println("输出list"+list);

        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        Map map=new HashMap();
        map.put("1","a");
        System.out.println(map.get("1"));

    }
}
