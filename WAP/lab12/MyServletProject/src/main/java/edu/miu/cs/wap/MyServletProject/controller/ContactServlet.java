package edu.miu.cs.wap.MyServletProject.controller;

import edu.miu.cs.wap.MyServletProject.model.ContactMessage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContactServlet", value = "/contact-form")
public class ContactServlet extends HttpServlet {

    private int contactHitCounter,thankyoutHitCounter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().setAttribute("contactHit", contactHitCounter());
        request.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        ContactMessage contact = new ContactMessage(request.getParameter("nameId"), gender == null ? "" : gender, request.getParameter("category"), request.getParameter("message"));
        request.setAttribute("contact",contact);

        if(!contact.getCustomerName().isEmpty() && contact.getGender() != null && !contact.getCategory().isEmpty() && !contact.getMessage().isEmpty()) {
            request.getServletContext().setAttribute("thankYouHit", thankYoutHitCounter());
            request.getRequestDispatcher("/WEB-INF/views/thankyou.jsp").forward(request,response);
        }
        doGet(request,response);
    }

    private synchronized int contactHitCounter(){ return ++contactHitCounter; }
    private synchronized int thankYoutHitCounter(){ return ++thankyoutHitCounter; }

}

