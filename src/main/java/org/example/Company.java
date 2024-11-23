package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    private int company_Id;
    private String company_Name;
    private String company_Location;
    @OneToMany(mappedBy = "company")
    private List<BankConnection> bankConnectionList=new ArrayList<BankConnection>();
    @OneToMany(mappedBy = "company")
    private List<EndUser> endUserList=new ArrayList<EndUser>();

    public List<EndUser> getEndUserList() {
        return endUserList;
    }

    public void setEndUserList(List<EndUser> endUserList) {
        this.endUserList = endUserList;
    }

    public List<BankConnection> getBankConnectionList() {
        return bankConnectionList;
    }
    public void setBankConnectionList(List<BankConnection> bankConnectionList) {
        this.bankConnectionList = bankConnectionList;
    }

    public int getCompany_Id() {
        return company_Id;
    }

    public void setCompany_Id(int company_Id) {
        this.company_Id = company_Id;
    }

    public String getCompany_Name() {
        return company_Name;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public String getCompany_Location() {
        return company_Location;
    }

    public void setCompany_Location(String company_Location) {
        this.company_Location = company_Location;
    }
}
