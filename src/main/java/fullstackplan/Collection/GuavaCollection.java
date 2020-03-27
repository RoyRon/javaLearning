package fullstackplan.Collection;

import com.google.common.collect.*;

public class GuavaCollection {
    public static void main(String[]args){
        Multiset multiset= HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("a");
        System.out.println("multiset可以添加重复元素"+multiset);

        Multimap<String,String>multimap= HashMultimap.create();
        multimap.put("1","a");
        multimap.put("1","b");
        System.out.println("multimap一个key可以对应多个value"+multimap);

        BiMap biMap=HashBiMap.create();
        biMap.put("1","a");
        System.out.println("bimap支持反向映射"+biMap.inverse().get("a"));

        Table table=TreeBasedTable.create();
        table.put("row1","column1","value1");
        table.put("row2","column1","value2");
        System.out.println(table.column("colum1"));
        System.out.println(table.row("row2"));
        System.out.println("table通过行和列来取值"+table.get("row2","colum1"));


    }

}
