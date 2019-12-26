package anma.hibernate.cfg;

import anma.hibernate.cfg.crud.CreateDog;
import anma.hibernate.noncfg.HibernateUtilNoCfg;
import org.hibernate.Session;

public class CfgExec {

    public static void main(String[] args) {

//        Session session = HibernateCfgUtil.getSessionFactory().openSession();
//        session.beginTransaction();


        CreateDog.createDog("Sharik", 7, "red");


    }
}
