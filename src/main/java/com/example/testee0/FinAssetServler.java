package com.example.testee0;

import com.example.testee0.domain.Bond;
import com.example.testee0.domain.FinAsset;
import com.example.testee0.domain.Security;
import com.example.testee0.domain.Tiker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/finasset")
public class FinAssetServler extends HttpServlet {
    private List<FinAsset> finAssets = new ArrayList<>();
    private List<Security> securities = new ArrayList<>();
    private List<Bond> bonds = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Создаем тестовые данные
        Tiker appleTiker = new Tiker(1L, "AAPL", "NASDAQ");
        Tiker teslaTiker = new Tiker(2L, "TSLA", "NYSE");

        FinAsset appleStock = new FinAsset(1L, appleTiker, "SEC", new Date(), "Apple Inc.", "Безналичная", 100.0, 100000);
        FinAsset teslaStock = new FinAsset(2L, teslaTiker, "SEC", new Date(), "Tesla Inc.", "Наличная", 150.0, 50000);

        Security appleSecurity = new Security(1L, appleStock, new Date(), new Date());
        Security teslaSecurity = new Security(2L, teslaStock, new Date(), new Date());

        Bond appleBond = new Bond(1L, appleStock, new Date(), 5, 4.5);
        Bond teslaBond = new Bond(2L, teslaStock, new Date(), 10, 5.5);

        finAssets.add(appleStock);
        finAssets.add(teslaStock);

        securities.add(appleSecurity);
        securities.add(teslaSecurity);

        bonds.add(appleBond);
        bonds.add(teslaBond);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Передаем списки в JSP
        request.setAttribute("finAssets", finAssets);
        request.setAttribute("securities", securities);
        request.setAttribute("bonds", bonds);
        request.getRequestDispatcher("finassets.jsp").forward(request, response);
    }
}