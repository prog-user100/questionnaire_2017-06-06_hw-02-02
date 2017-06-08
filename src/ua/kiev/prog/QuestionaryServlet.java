package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuestionaryServlet extends HttpServlet {
    private final static String TOTAL = "total";

    private static Map<String, Integer> numbers = new HashMap<>();
    static {
        numbers.put(TOTAL, 0);
        numbers.put("10", 0);
        numbers.put("50", 0);
        numbers.put("100", 0);
    }

    private static Map<String, Integer> letters = new HashMap<String, Integer>() {{
        put(TOTAL, 0);
        put("A", 0);
        put("B", 0);
        put("C", 0);
    }};

    private static Map<String, Integer> operators = new HashMap<String, Integer>() {{
        put(TOTAL, 0);
        put("=", 0);
        put("<", 0);
        put(">", 0);
    }};

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String number = request.getParameter("question_1");
        if (numbers.containsKey(number)) {
            numbers.replace(TOTAL, numbers.get(TOTAL)+1);
            numbers.replace(number, numbers.get(number)+1);
        }

        String[] letterArray = request.getParameterValues("question_2");
        if (letterArray != null) {
            for (int i = 0; i < letterArray.length; i++) {
                if(letters.containsKey(letterArray[i])) {
                    letters.replace(TOTAL, letters.get(TOTAL) + 1);
                    letters.replace(letterArray[i], letters.get(letterArray[i]) + 1);
                }
            }
        }

        String operator = request.getParameter("question_3");
        if (operators.containsKey(operator)) {
            operators.replace(TOTAL, operators.get(TOTAL)+1);
            operators.replace(operator, operators.get(operator)+1);
        }

        response.getWriter().println(createHtml());
    }

   private String createHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><title>Servey results</title><body>");
        builder.append("<h4>The results of the first questionary</h4>");
        builder.append(mapToHtmlTable(numbers));
        builder.append("<h4>The results of the second questionary</h4>");
        builder.append(mapToHtmlTable(letters));
        builder.append("<h4>The results of the third questionary</h4>");
        builder.append(mapToHtmlTable(operators));
        builder.append("</body></html>");
        return builder.toString();
    }

    private StringBuilder mapToHtmlTable(Map<String, Integer> map) {
        Integer total = map.get(TOTAL);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<p>Total votes: %d", total));
        builder.append("<table><tr><th>Option |</th><th>Percent of votes |</th></tr>");
        for(String key : map.keySet()) {
            if(key.equals("total")) {
                continue;
            }
            builder.append("<tr><td>");
            builder.append(key);
            builder.append("</td><td>");
            builder.append ( total == 0 ? 0 : (int)((double)map.get(key)/total*100) );
            builder.append("%<tr><td></td></tr>");
        }
        builder.append("</table>");
        return builder;
    }
}
