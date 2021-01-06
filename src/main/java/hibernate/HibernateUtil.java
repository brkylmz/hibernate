package hibernate;

import Model.Domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory _sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            settings.put(Environment.URL, "jdbc:sqlserver://192.168.1.1;database=hibernate");
            settings.put(Environment.USER, "sa");
            settings.put(Environment.PASS, "******");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.FORMAT_SQL, "true");
            settings.put(Environment.AUTOCOMMIT, "true");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(UserEntity.class);
            configuration.addAnnotatedClass(UserStickyNotesEntity.class);
            configuration.addAnnotatedClass(PurchaseRequestEntity.class);
            configuration.addAnnotatedClass(LogEntity.class);
            configuration.addAnnotatedClass(StockEntity.class);
            SessionFactory factory = configuration.buildSessionFactory();
            return factory;
        }
        catch (Exception ex)
        {
            System.out.println(String.format("Session Factory Oluştururken Hata Meydana Geldi. Hata Detayı: %s", ex.toString()));
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return _sessionFactory;
    }
}