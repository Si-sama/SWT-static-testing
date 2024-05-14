/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Admin;


import static dal.DAO.Instance;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author sinan
 */
public class AdminTable extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet AdminTable</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminTable at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("productList", Instance.getAllProduct2());
        request.setAttribute("categoryList", Instance.getAllCategory());
        request.setAttribute("userList", Instance.getAllUSer_Info());
        request.getRequestDispatcher("view/tables.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String onProduct=request.getParameter("OnProductButton");
       String onCategory=request.getParameter("ONcategoryProductButton");
       String deleteProductButton = request.getParameter("deleteProductButton");
       String deletecategoryProductButton = request.getParameter("deletecategoryProductButton");
       String updateProductButton=request.getParameter("updateProductButton");
       String updatecategoryProductButton=request.getParameter("updatecategoryProductButton");
       
        if(onProduct!=null) {
            if(Instance.getProductByID(onProduct).getCategory().getStatusCategory()==1) {
                request.setAttribute("msg", "Category of this product has been deleted , you must add or turn on to On this product");
                doGet(request, response);
                return ;
            }
            Instance.Onproduct(onProduct);
        }
        if(onCategory!=null) {
            Instance.OnCategory(onCategory);
        }
      
       if(deleteProductButton!=null) {
           Instance.deleteProduct(deleteProductButton);
       }if(deletecategoryProductButton!=null) {
       boolean a= Instance.deleteCategory(deletecategoryProductButton);
        if(a==true) {
            for (Product  po : Instance.getAllProductByCategoryID(deletecategoryProductButton)) {
             Instance.deleteProduct(po.getProductID());
            }
        }
           
       }
       if(updateProductButton!=null) {
           response.sendRedirect("UpdateProduct?id="+updateProductButton);
           return ;
       }if(updatecategoryProductButton!=null) {
           response.sendRedirect("UpdateCategory?id="+updatecategoryProductButton);
           return ;
       }
       
       
        doGet(request, response);
      
    }
    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
    
    
}
