package br.edu.ifpb.resteasyapp.hibernate;
  
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
  
public class HibernateUtil {
  
	private static Logger logger = LogManager.getLogger(HibernateUtil.class);
	
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    private static SessionFactory buildSessionFactory() {
        try {
        	
        	logger.info("Configurando conex�o Hibernate->MySQL");
        	Configuration configuration = new Configuration().configure();
        	
        	logger.info("Hibernate->MySQL - Properties: " + configuration.getProperties());
        	
        	// Create the SessionFactory from hibernate.cfg.xml
            return configuration.buildSessionFactory();
        
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
        	logger.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
  
}