package com.hrs.view.models;

import java.util.Set;

public class Session
{
    private static Set<Customer> customer = null;
    
    public Session() {}
    
    public boolean isInSession(Customer customer)
    {
        return true;
    }
    
    public boolean addInSession(Customer customer)
    {
        return true;
    }
    
    public boolean deleteFromSession(Customer customer)
    {
        return true;
    }
    
    public void deleteGlobalAdminFromSession()
    {
        return;
    }
    
    public boolean isCustomerInSession()
    {
        return true;
    }
}
