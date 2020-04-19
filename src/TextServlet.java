import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/converter")
public class TextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String textArea = request.getParameter("textArea");

        response.getWriter().println(String.format(textArea));
        response.getWriter().println(String.format("<h1>Ilość słów: %d</h1>", wordsInText(textArea)));
        response.getWriter().println(String.format("<h1>Ilość znaków: %d</h1>", textLength(textArea)));
        response.getWriter().println(String.format("<h1>Ilość znaków bez spacji: %d</h1>", withoutSpace(textArea)));
        response.getWriter().println(String.format("<h1>Palindrom: %b</h1>", isThisTextAPalindrome(textArea)));

        response.setContentType("text/html");
    }

    private static boolean isThisTextAPalindrome(String text) {
        text = text.toLowerCase();
        text = text.replaceAll(" ", "");
        text = text.trim();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static int textLength(String text) {
        return text.length();
    }

    private static int withoutSpace(String text) {
        return text.replaceAll(" ", "").length();
    }

    private static int wordsInText(String text) {
        return text.split(" ").length;
    }
}

