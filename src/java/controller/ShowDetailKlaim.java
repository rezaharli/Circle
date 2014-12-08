/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DokterDAO;
import dao.ObatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dokter;
import model.Obat;

/**
 *
 * @author Reza Harli
 */
@WebServlet(name = "ShowDetailKlaim", urlPatterns = {"/ShowDetailKlaim"})
public class ShowDetailKlaim extends HttpServlet {

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

        String idKlaim = request.getParameter("idKlaim");
        String statusKlaim = request.getParameter("statusKlaim");

        LinkedList<Dokter> dokters = DokterDAO.selectAllByIdKlaim(idKlaim);
        LinkedList<Obat> obats = ObatDAO.selectAllByIdKlaim(idKlaim);

        int totalHargaDokter = 0;
        int totalHargaObat = 0;

        PrintWriter out = response.getWriter();
        if (dokters.size() > 0) {
            out.write("<table width=\"100%\">");
            out.write("<tr><td colspan=\"2\" align=\"left\">Dokter:</td></tr>");
            for (Dokter dokter : dokters) {
                out.write("<tr>");
                out.write("<td> - " + dokter.getNama() + ":</td><td align=right>Rp " + dokter.getHarga() + ",-</td>");
                out.write("</tr>");
                totalHargaDokter += Integer.parseInt(dokter.getHarga());
            }
            out.write("<tr border=\"1\">");
            out.write("<td> Total:</td><td align=right>Rp " + totalHargaDokter + ",-</td>");
            out.write("</tr>");
            out.write("</table>");
            out.write("<br />");
        }
        if (obats.size() > 0) {
            out.write("<table width=\"100%\">");
            out.write("<tr><td colspan=\"2\" align=\"left\">Obat:</td></tr>");
            for (Obat obat : obats) {
                out.write("<tr>");
                out.write("<td> - " + obat.getNama() + ":</td><td align=right>Rp " + obat.getHarga() + ",-</td>");
                out.write("</tr>");
                totalHargaObat += Integer.parseInt(obat.getHarga());
            }
            out.write("<tr border=\"1\">");
            out.write("<td> Total:</td><td align=right>Rp " + totalHargaObat + ",-</td>");
            out.write("</tr>");
            out.write("</table>");
            out.write("<br />");
        }

        if (dokters.size() == 0 && obats.size() == 0) {
            out.write("<table width=\"100%\">");
            out.write("<tr><td colspan=\"2\" align=center>Detail tidak ditemukan.</td></tr>");
            out.write("</table>");
        }

        out.write("Total Klaim: Rp " + (totalHargaDokter + totalHargaObat) + ",-<br />");
        out.write(statusKlaim);
        if (statusKlaim.equalsIgnoreCase("waiting")) {
            out.write("<a href=\"http://localhost:8080/Circle/DeleteKlaim?idKlaim=" + idKlaim + "\" > - Cancel Klaim</a>");
        }
        if (statusKlaim.equalsIgnoreCase("ditolak")) {
            out.write("<a href=\"http://localhost:8080/Circle/DeleteKlaim?idKlaim=" + idKlaim + "\" > - Delete Klaim</a>");
        }
    }

}
