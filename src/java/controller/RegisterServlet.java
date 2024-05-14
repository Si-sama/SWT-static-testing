/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static dal.DAO.Instance;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 *
 * @author sinan
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/Register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String mail = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String cccd = request.getParameter("cccd");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("fname", fName);
        request.setAttribute("lname", lName);

        request.setAttribute("mail", mail);

        request.setAttribute("phone", phone);

        request.setAttribute("dob", dob);

        request.setAttribute("cccd", cccd);

        request.setAttribute("address", address);

        request.setAttribute("username", username);

        request.setAttribute("password", password);

        request.setAttribute("fname", fName);

        if (isNumber(phone) == false || phone.length() != 10) {
            request.setAttribute("Register", "Your phone number was entered incorrectly format");
            doGet(request, response);
            return;
        }
        if (isNumber(cccd) == false || cccd.length() != 12) {
            request.setAttribute("Register", "Your CCCD number was entered incorrectly format");
            doGet(request, response);
            return;
        }
        if (Instance.checkUsernameExist(username) == true) {
            request.setAttribute("Register", "UserName already Exist");
            doGet(request, response);
            return;
        }

        if (Instance.checkUsernameExist(username) == false) {

            boolean check = Instance.Register(fName, lName, phone, dob, cccd, address, username, password);
            if (check == true) {
                request.setAttribute("Register", "Register success");

            } else {
                request.setAttribute("Register", "Register failed");
            }
        } else {
            request.setAttribute("Register", "Fail");

        }

        request.getRequestDispatcher("view/Register.jsp").forward(request, response);
    }

    public boolean isNumber(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
