import com.solvd.carina.demo.gui.interfaces.UserMapper;
import com.solvd.carina.demo.gui.interfaces.UserOrdersMapper;
import com.solvd.carina.demo.gui.models.User;
import com.solvd.carina.demo.gui.models.UserOrder;

import com.solvd.carina.demo.gui.services.UserOrderService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.SessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        /*try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper userMapper = session.getMapper(UserMapper.class);

                *//*User newUser = new User();
                newUser.setName("problem_user");
                newUser.setPassword("secret_sauce");
                userMapper.insertUser(newUser);*//*

//                User retrievedUser = userMapper.getUserById(1);
//                System.out.println("Retrieved user: " + retrievedUser.toString());

                UserOrdersMapper userOrdersMapper = session.getMapper(UserOrdersMapper.class);

//                UserOrder newOrder = new UserOrder();
//                newOrder.setUserId(retrievedUser.getId());
//                newOrder.setProductName("Sauce Labs Backpack");
//                newOrder.setPrice(29.99);
//                userOrdersMapper.insertUserOrder(newOrder);

                List<UserOrder> userOrders = userOrdersMapper.getUserOrdersByUserId(1);
                System.out.println("User orders:");
                for (UserOrder order : userOrders) {
                    System.out.println("Product: " + order.getProductName() + ", Price: " + order.getPrice());
                }

//                session.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /*UserOrderService userOrderService = new UserOrderService();
        List<UserOrder> byId = userOrderService.getById(1);
        byId.forEach(System.out::println);*/
    }
}