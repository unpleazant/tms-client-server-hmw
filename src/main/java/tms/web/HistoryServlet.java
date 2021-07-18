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
import java.util.List;

@WebServlet(name = "HistoryServlet", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    private CalculationService calcService = new CalculationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> all = calcService.findAllByUser((User) req.getSession().getAttribute("user"));
        for (Operation operation : all) {
            resp.getWriter().println(operation);
        }
    }

}