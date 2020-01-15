package json;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import json.bean.TestA;
import json.bean.TestB;


public class Demo {
    public static void main(String[] args) throws Exception{
        TestA testA = new TestA();
        TestB testB = new TestB();
        testA.setName("testA");
        testA.setTestB(testB);
        testB.setName("testB");
        testB.setTestA(testA);

        // ObjectMapper mapper = new ObjectMapper();
        //
        // System.out.println(mapper.writeValueAsString(testB));

       // Gson gson = new Gson();
       // gson.toJson(testB);


       System.out.println(JSONObject.toJSONString(testB));
       System.out.println(JSONObject.toJSON(testB));



//        System.out.println(ResultMessage.data(testA));
    }
}
