package com.mycompany.userregistr.web;

import com.mycompany.userregistr.dao.AppWareDaoImpl;
import com.mycompany.userregistr.model.AppWare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "AddWareServlet", urlPatterns = "/addWare")
public class AddWareServlet extends HttpServlet {
    private AppWareDaoImpl wareDao = new AppWareDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String productName = req.getParameter("productName");
        String manufacturer = req.getParameter("manufacturer");
        BigDecimal pricePerUnit = new BigDecimal(req.getParameter("pricePerUnit"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String warehouseNumber = req.getParameter("warehouseNumber");
        int minimumBatch = Integer.parseInt(req.getParameter("minimumBatch"));

        AppWare ware = new AppWare();
        ware.setProductName(productName);
        ware.setManufacturer(manufacturer);
        ware.setPricePerUnit(pricePerUnit);
        ware.setQuantity(quantity);
        ware.setWarehouseNumber(warehouseNumber);
        ware.setMinimumBatch(minimumBatch);

        wareDao.create(ware);
        req.getRequestDispatcher("/WaresServlet").forward(req, resp);
    }
}
