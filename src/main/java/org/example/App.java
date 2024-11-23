package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Company company = new Company();
        company.setCompany_Id(1019191);
        company.setCompany_Name("Girmiti Software");
        company.setCompany_Location("Bangalore");
        BankConnection bankConnection = new BankConnection();
        bankConnection.setBank_Id(101);
        bankConnection.setBank_Name("SBI");
        BankConnection bankConnection2 = new BankConnection();
        bankConnection2.setBank_Id(102);
        bankConnection2.setBank_Name("BOI");
        EndUser endUser=new EndUser();
        endUser.setUser_id(201);
        endUser.setUser_name("Simanta Sen");
        EndUser endUser2=new EndUser();
        endUser2.setUser_id(202);
        endUser2.setUser_name("Santanu Sen");

        bankConnection.setCompany(company);
        bankConnection2.setCompany(company);
        endUser.setCompany(company);
        endUser2.setCompany(company);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Company.class)
                .addAnnotatedClass(BankConnection.class).addAnnotatedClass(EndUser.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        session.save(bankConnection);
        session.save(bankConnection2);
        session.save(endUser);
        session.save(endUser2);
        transaction.commit();
        session.close();
    }
}
