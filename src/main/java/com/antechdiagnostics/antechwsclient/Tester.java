/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antechdiagnostics.antechwsclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author knguyen
 */
public class Tester {
      
    public static void main(String[] args) {
        
        try {
            
            Services port = new Services();
            ZoasisServicesPort soap = port.getZoasisServicesPort();
            
            LoginObject lio = new LoginObject();
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter clinic id:");
            int cid = reader.nextInt();
            lio.setClinicId(cid);
            lio.setCorporateId(0);
            System.out.print("Enter username:");
            String uname = reader.next();
            lio.setUserName(uname);
            System.out.print("Enter password:");
            String userPassword = reader.next();
            lio.setPassword(userPassword);
            ArrayOfPubCodeListPrice p = soap.getUSPubCodeListPrice(lio);
            p.getPubCodeListPrice().forEach((l) -> {
                System.out.println(l.orderCode + " ; " + l.orderCodeName + " ; " + l.orderCodePrice);
            });
        } catch (FinderException_Exception ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
