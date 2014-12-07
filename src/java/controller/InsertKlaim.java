/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KlaimDAO;
import dao.ObatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Klaim;
import model.Obat;
import model.User;

/**
 *
 * @author Reza Harli
 */
@WebServlet(name = "InsertKlaim", urlPatterns = {"/InsertKlaim"})
public class InsertKlaim extends HttpServlet {

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
            out.println("<title>Servlet InsertKlaim</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertKlaim at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        try {
            String namaDokter = request.getParameter("namaDokter");
            String hargaDokter = request.getParameter("hargaDokter");
            String namaObat = request.getParameter("namaObat");
            String hargaObat = request.getParameter("hargaObat");

            Calendar now = Calendar.getInstance();
            int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
            String dayOfMonthStr = dayOfMonth + "";
            int month = now.get(Calendar.MONTH) + 1;
            String monthStr = ((month < 10) ? "0" : "") + month;
            String tanggal = now.get(Calendar.YEAR) + "-" + monthStr + "-" + dayOfMonthStr;

            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("currentSessionUser");

            Klaim klaim = new Klaim("", tanggal, "admin");
            klaim.setId(KlaimDAO.insert(klaim));
            
            Obat obat = new Obat(null, namaObat, hargaObat, klaim.getId());
            ObatDAO.insert(obat);
        } catch (NullPointerException m) {
            m.printStackTrace(response.getWriter());
        }
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
