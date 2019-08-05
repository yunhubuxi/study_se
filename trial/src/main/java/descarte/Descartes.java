package descarte;

import java.util.ArrayList;
import java.util.List;

public class Descartes {

    public static void run(List<List<String>> dimvalue, List<String> result, int layer, String curstring) {
        //大于一个集合时：
        if (layer < dimvalue.size() - 1) {
            //大于一个集合时，第一个集合为空
            if (dimvalue.get(layer).size() == 0)
                run(dimvalue, result, layer + 1, curstring);
            else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    StringBuilder s1 = new StringBuilder();
                    s1.append(dimvalue.get(layer).get(i));
                    s1.append(";"+curstring);
                    run(dimvalue, result, layer + 1, s1.toString());
                }
            }
        }
        //只有一个集合时：
        else if (layer == dimvalue.size() - 1) {
            //只有一个集合，且集合中没有元素
            if (dimvalue.get(layer).size() == 0)
                result.add(curstring);
                //只有一个集合，且集合中有元素时：其笛卡尔积就是这个集合元素本身
            else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    result.add(dimvalue.get(layer).get(i)+";" +curstring);
                }
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        List<List<String>> dimvalue = new ArrayList<List<String>>();
        List<String> v1 = new ArrayList<String>();
        v1.add("颜色：红");
        v1.add("颜色：蓝");
        List<String> v2 = new ArrayList<String>();
        v2.add("尺码：小");
        v2.add("尺码：中");
        v2.add("尺码：大");
//        List<String> v3 = new ArrayList<String>();
//        v3.add("产地：中国");
//        v3.add("产地：外国");
//        List<String> v4 = new ArrayList<>();
//        v3.add("身高：高");
//        v3.add("身高：低");

        dimvalue.add(v1);
        dimvalue.add(v2);
//        dimvalue.add(v3);
//        dimvalue.add(v4);


        List<String> result = new ArrayList<String>();

        Descartes.run(dimvalue, result, 0, "");

        for (String s : result) {
            System.out.println(s);
        }

//        int i = 1;
//        for (String s : result) {
//            System.out.println(i++ + ":" + s);
//        }
    }

}