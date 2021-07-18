package tms.web;

import tms.entity.Operation;
import tms.entity.User;
import tms.service.CalculationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ДЗ:
 *  Реализовать остальные операции вычислений
 *  Доработать защиту сервлетов Registration, Authorization, Logout
 *  Доработать получение истории вычислений пользователя(при запросе пользователь видит только свои вычисления)
 */

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")
public class CalculationServlet extends HttpServlet {

    private final CalculationService calcService = new CalculationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        User user = (User) req.getSession().getAttribute("user");
        Operation calc = calcService.calc(num1, num2, operation, user);
        resp.getWriter().print(calc);
    }

}