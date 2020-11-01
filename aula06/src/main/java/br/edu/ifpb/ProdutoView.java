package br.edu.ifpb;

import br.edu.ifpb.Produto;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/produtoview")
public class ProdutoView extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

            Produto produto = (Produto) request.getAttribute("produtoEscolhido");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>");
            out.println("Detalhes do Produto");
            out.println("</h1>");
            out.println("<p>");
            out.println("Nome do produto: " + produto.getNomeProduto());
            out.println("Marca do Produto: " + produto.getTamanho());
            out.println("Marca do Produto: " + produto.getMarca());
            out.println("</p>");
            out.println("</body>");
            out.println("</html>");
            out.close();             
            }

    }
    

