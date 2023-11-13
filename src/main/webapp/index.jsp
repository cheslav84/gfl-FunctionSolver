<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Equation solver</title>
        <link href="css/common.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h2><%= "Equation solver!" %></h2>
        <br/>
        <form method="post" action="results">
            <table>
                <thead>
                    <tr>
                        <td class="center">Equation system</td>
                        <td class="center">Compound number</td>
                        <td class="center">Coefficients</td>
                        <td class="center">The range <br/> and argument step</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="center">
                            <img src="img/equations.png" width="200px">
                        </td>
                        <td class="center">
                            <img src="img/compound.png" width="110px">
                        </td>
                        <td class="center">
                            <img src="img/coefficients.png" width="90px">
                        </td>
                        <td class="center">
                            <div>
                                <label for="rangeFrom">x &#8712; [</label>
                                <%--                                <input type="number" name="rangeFrom" min="-10000" max="10000" step="0.01" id="rangeFrom" class="number-input">--%>
                                <input type="number" name="rangeFrom" min="-10000" max="10000" step="0.01" id="rangeFrom" class="number-input" value="0.0">
                                <label for="rangeTo"> ; </label>
                                <%--                                <input type="number" name="rangeTo" min="-10000" max="10000" step="0.01" id="rangeTo" class="number-input">--%>
                                <input type="number" name="rangeTo" min="-10000" max="10000" step="0.01" id="rangeTo" class="number-input" value="2.0">
                                <span>]</span>
                            </div>
                            <div>
                                <label for="interval">&#8710;x = </label>
                                <input type="number" name="interval" min="0.00001" max="0.2"  step="0.00001" id="interval" class="number-input" value="0.002">
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <input type="submit" value="Get results">
        </form>
    </body>
</html>