/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DokterDAO;
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
import model.Dokter;
import model.Klaim;
import model.Obat;
import model.Tanggal;
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
            int jumlahDokter = Integer.parseInt(request.getParameter("jumlahDokter"));
            int jumlahObat = Integer.parseInt(request.getParameter("jumlahObat"));

            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("currentSessionUser");
//
            Klaim klaim = new Klaim(null, Tanggal.getTanggalSekarang(), user.getUsername());
            klaim.setId(KlaimDAO.insert(klaim));
//          
            for (int i = 0; i < jumlahDokter; i++) {
                DokterDAO.insert(new Dokter(null, request.getParameter("namaDokter" + i), request.getParameter("hargaDokter" + i), klaim.getId()));
            }
            
            for (int i = 0; i < jumlahObat; i++) {
                ObatDAO.insert(new Obat(null, request.getParameter("namaObat" + i), request.getParameter("hargaObat" + i), klaim.getId()));
            }
            response.sendRedirect("index.jsp");
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
