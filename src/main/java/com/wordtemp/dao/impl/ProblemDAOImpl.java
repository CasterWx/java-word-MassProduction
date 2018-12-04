package com.wordtemp.dao.impl;

import com.wordtemp.dao.IProblemDAO;
import com.wordtemp.domain.Problem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2018-11-15-16:11
 */
public class ProblemDAOImpl implements IProblemDAO {
    private Configuration configuration = null;
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private void initSession(){
        configuration = new Configuration() ;
        configuration.configure("hibernate.cfg.xml") ; //"hibernate.cfg.xml"
        sessionFactory = configuration.buildSessionFactory() ;
        session = sessionFactory.openSession() ;
    }
    private void closeSession(){
        session.close();
        sessionFactory.close();
    }

    public void save(Problem user) {
        initSession();
        Transaction transaction = session.getTransaction() ;
        transaction.begin();
        session.save(user);
        transaction.commit();
        closeSession();
    }

    public void update(Problem user) {
        initSession();
        Transaction transaction = session.getTransaction() ;
        transaction.begin();
        session.update(user);
        transaction.commit();
        closeSession();
    }

    public void delete(Problem user) {
        initSession();
        Transaction transaction = session.getTransaction() ;
        transaction.begin();
        session.delete(user);
        transaction.commit();
        closeSession();
    }

    public Problem get(Integer id) {
        initSession();
        Problem user = (Problem) session.get(Problem.class,id);
        closeSession();
        return user;
    }

    public List<Problem> listAll() {
        initSession();
        String hql = "SELECT  u FROM Problem u" ;
        Query query = session.createQuery(hql) ;
        List<Problem> users = query.list() ;
        closeSession();
        return users;
    }
}
