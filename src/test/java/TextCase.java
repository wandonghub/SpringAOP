import com.zzcedu.controller.HelloController;
import com.zzcedu.controller.WanDong;
import com.zzcedu.log.LianXi;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextCase {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        HelloController helloController = ac.getBean("helloController", HelloController.class);
        helloController.hello();
    }
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring1.xml");
        HelloController helloController = ac.getBean("helloController", HelloController.class);
        helloController.hello();
    }
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring2.xml");
        WanDong wanDong = ac.getBean("wanDong", WanDong.class);
        wanDong.wan();
    }
    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring1.xml");
        WanDong wanDong = ac.getBean("wanDong", WanDong.class);
        wanDong.wan();
    }
}
