package mybatis.onttomany;

import mybatis.mapper.OrdersMapperCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class OrdersMapperCustomTest {

    public static void main(String[] args) throws Exception {

        // 创建sqlSessionFactory
        // mybatis配置文件
        String resource = "conf.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        //调用mapper的方法
//        List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        String statement = "mybatis.OrdersMapperCustom.findOrdersAndOrderDetailResultMap";
        List<Orders> list = sqlSession.selectList(statement);
        for (Orders order:
             list) {
            System.out.println(order);
        }

        sqlSession.close();
    }

}