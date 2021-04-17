package edu.miu.cs.PracticeFinalWAP.controller;

import com.google.gson.Gson;
import edu.miu.cs.PracticeFinalWAP.model.Product;
import edu.miu.cs.PracticeFinalWAP.model.Supplier;
import edu.miu.cs.PracticeFinalWAP.service.ProductService;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productController", value = "/products")
public class ProductController extends HttpServlet {

    private ProductService service;

    public ProductController(){ }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext appContext = config.getServletContext();
        if(appContext.getAttribute("productsData") == null) {
            List<Product> productsData = new Vector<>();
            Supplier s1 = new Supplier("S10001","El Segundo Agro Products, Inc.");
            Supplier s2 = new Supplier("S10002","Organic Farms of Des Moines");
            Supplier s3 = new Supplier("S10003","United WholeFoods Corporation");

            productsData.add(new Product("P1000001","Apples",1.49,156, LocalDate.of(2020, 3,29),s1));
            productsData.add(new Product("P1000002","Bananas",2.25,48, LocalDate.of(2020, 4,13),s3));
            productsData.add(new Product("P1000003","Pears",5.55,127, LocalDate.of(2020, 3,27),s2));
            productsData.add(new Product("P1000004","Avocados",4.65,125, LocalDate.of(2020, 4,11),s3));

            this.service = new ProductService(productsData);
            appContext.setAttribute("productsData",this.service.getAllProductsSorted());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // defining the PrintWriter object
        PrintWriter out = response.getWriter();
        // setting the response type
        response.setContentType("application/json");
        // converting object to json using Gson api.
        out.println(new Gson().toJson(service.getAllProductsSorted()));
        out.close();

        //out.println(productsToJson(service.getAllProductsSorted()));
        //   OR hardcode - creating or method for.. loop
        //String jsonData = "[{"productId":"Apples"},{}...]"

        /** Sending cookie
         * Cookie cookie = new Cookie(“Name”, “Jack”);
         * response.addCookie(cookie);
         * cookie.setMaxAge(seconds); //only for permanent cookies
         * • A zero value causes an existing permanent cookie to be deleted.
         *
         * Reading cookies
         * for (Cookie cookie : request.getCookies()) {
         *  if (cookie.getName().equals(“Name”)) {
         *  String userName= cookie.getValue(); } }
         */

        //request.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(request,response);
    }

    public void destroy() {
    }

    public String productsToJson(List<Product> list){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int index = 0;
        for(Product p: list){
            builder.append(index != 0 ? ",{" : "{");
            builder.append("\"productId\" : \""+p.getProductId()+"\"");
            builder.append(",\"name\" : \""+p.getName()+"\"");
            builder.append(",\"unitPrice\" : \""+p.getUnitPrice()+"\"");
            builder.append(",\"qty\" : \""+p.getQty()+"\"");
            builder.append(",\"dateSupplied\" :{ \"year\" : \""+ p.getDateSupplied().getYear()+"\", \"month\" : \""+ p.getDateSupplied().getMonth()+"\", \"day\" : \""+ p.getDateSupplied().getDayOfMonth()+"\"}");
            builder.append(",\"supplier\" :{\"supplierId\" : \""+ p.getSupplier().getSupplierId()+"\", \"name\" : \""+ p.getSupplier().getName()+"\"}");
            builder.append("},");
            index++;
        }

        builder.append("]");
        return builder.toString();
    }
}