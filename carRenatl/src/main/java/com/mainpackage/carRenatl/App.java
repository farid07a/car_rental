package com.mainpackage.carRenatl;

/**
 * Hello world!
 *
 */
import domain.User;
import domain.UserRole;
public class App 
{
    public static void main( String[] args )
    {
        User us01=new domain.User();
        us01.setUserName("Farid");
        us01.setUserRole(UserRole.ADMIN);
        System.out.println(us01);
        
        
        
    }
}
