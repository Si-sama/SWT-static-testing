/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.he170077.project.test;

import com.sun.net.httpserver.HttpsServer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dal.DAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User_Info;
/**
 *
 * @author sinan
 */
public class DAOTest extends HttpServlet{
    
    public DAOTest() {
    }
    @Test
    public void testGetAllAccountReturnWell(HttpServletRequest request, HttpServletResponse response) {
        User_Info a =(User_Info)request.getSession().getAttribute("account");
        if(a==null) {
            
        }
    }
}
