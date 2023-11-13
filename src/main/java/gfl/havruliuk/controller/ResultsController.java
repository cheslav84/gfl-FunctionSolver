package gfl.havruliuk.controller;

import gfl.havruliuk.model.domain.ResultsDto;
import gfl.havruliuk.model.domain.function.CompoundFunction;
import gfl.havruliuk.model.domain.util.FunctionSolver;
import gfl.havruliuk.model.service.SolverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "resultsServlet", value = "/results")
public class ResultsController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        double compound = Double.parseDouble(request.getParameter("compound"));
        double eps = Double.parseDouble(request.getParameter("eps"));



        CompoundFunction function = new CompoundFunction(a, b, c, compound, eps);

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