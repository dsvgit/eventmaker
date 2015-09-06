package eventmaker;

import eventmaker.data.Company;
import eventmaker.hibernate.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EventMaker {

    public static void main(String[] args) {
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();

        String strSql ="from Company o";
        Query query = session.createQuery(strSql);
        List lst = query.list();
        for(Iterator it=lst.iterator();it.hasNext();){

                Company emp=(Company)it.next();
                System.out.println("Hello: " + emp.getName());
        }

        tr.commit();
        System.out.println("Data displayed");
        sessFact.close();
    }
    
}
