package gfl.havruliuk.controller;

import gfl.havruliuk.model.domain.function.CompoundFunction;
import gfl.havruliuk.model.domain.util.FunctionSolver;
import gfl.havruliuk.model.service.SolverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "resultsServlet", value = "/results")
public class ResultsController extends HttpServlet {

    private CompoundFunction function;

    @Override
    public void init() throws ServletException {
        super.init();
        function = new CompoundFunction(2.7, -0.3, 4, 1.4, 10e-6);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        FunctionSolver solver = new FunctionSolver(function);
        double rangeFrom = Double.parseDouble(request.getParameter("rangeFrom"));
        double rangeTo = Double.parseDouble(request.getParameter("rangeTo"));
        double interval = Double.parseDouble(request.getParameter("interval"));

        request.setAttribute("results", new SolverService().getResults(solver, rangeFrom, rangeTo, interval));
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }

    public void destroy() {
    }
}