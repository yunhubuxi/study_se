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

        //创建代理对象，即获取映射器
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        // List<Orders> list_1 = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        String statement = "mybatis.mapper.OrdersMapperCustom.findOrdersAndOrderDetailResultMap";
        List<Orders> list_2 = sqlSession.selectList(statement);
        for (Orders order:
             list_2) {
            System.out.println(order);
        }

        sqlSession.close();
    }

}
