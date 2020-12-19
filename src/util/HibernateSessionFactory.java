package util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 工具类 帮助获取Hibernate的Session对象
 */
public class HibernateSessionFactory {
    //线程管理
    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<>();
    //会话工厂类
    private static SessionFactory sessionFactory;
    //配置类
    private static Configuration configuration= new Configuration();
    //Service注册表
    private static ServiceRegistry serviceRegistry;

    /**
     * 静态代码块
     */
    static{
        try{
            configuration.configure();//得到configuration对象
            sessionFactory=configuration.buildSessionFactory();
            serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
            try {
                sessionFactory =new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            }catch (Exception e){
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("%%%%% Error Creating SessionFactory %%%%%");
            e.printStackTrace();
        }
    }

    /**
     * 初始构造方法
     */
    private HibernateSessionFactory(){

    }

    /**
     * 获得Session对象
     * @return
     */
    public static Session getSession(){
        Session session= threadLocal.get();
         if(session == null || !session.isOpen()){
             if (sessionFactory==null){
                 rebuildSessionFactory();
             }
             session=(sessionFactory !=null)?sessionFactory.openSession():null;
             threadLocal.set(session);
         }
         return session;
    }

    /**
     *
     */
    public static void rebuildSessionFactory(){
        try {
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            try {
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("%%%%%%Error Creating SessionFactory %%%%%%%");
            e.printStackTrace();
        }
    }

    /**
     * 关闭Session对象
     */
    public static void closeSession(){
        Session session=threadLocal.get();
        threadLocal.set(null);
        if(session!=null){
            session.close();
        }
    }

    /**
     * 获取配置管理类
     * @return
     */
    public static Configuration getConfiguration(){
        return configuration;
    }
}
