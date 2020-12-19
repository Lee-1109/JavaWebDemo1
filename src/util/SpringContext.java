package util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringContext  {

    private static ApplicationContext applicationContext;

    static {
        SpringContext.applicationContext=new FileSystemXmlApplicationContext("D:/MySoftwareSpace/Tomcat/apache-tomcat-9.0.39/webapps/JavaWebDemo1/WEB-INF/applicationContext.xml");
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContext.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext(){
        return SpringContext.applicationContext;
    }


    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

}
