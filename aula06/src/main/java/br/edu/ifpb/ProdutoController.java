package br.edu.ifpb;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class ProdutoController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            PrintWriter out = response.getWriter();
    int id = Integer.parseInt(request.getParameter("produto"));
        
    List<Produto> produtos = new ArrayList<Produto>();

    Produto produto1 = new Produto(1, "Arroz", "1kg", "Caçarola");  
    Produto produto2 = new Produto(2, "Feijão", "1kg", "Terra Nossa");  
    Produto produto3 = new Produto(3, "Macarrão", "500g", "Fortaleza");  
    Produto produto4 = new Produto(4, "Queijo", "2kg", "Isis");  
    Produto produto5 = new Produto(5, "Leite", "1L", "Italac");  

    produtos.add(produto1);
    produtos.add(produto2);
    produtos.add(produto3);
    produtos.add(produto4);
    produtos.add(produto5);
            

    for(int i=0; i <produtos.size(); i++){
       if(produtos.get(i).getId() == id){
            out.println(produtos.get(i).getNomeProduto());
            request.setAttribute("produtoEscolhido", produtos.get(i));
            RequestDispatcher view = request.getRequestDispatcher("produtoview");
            view.forward(request, response);
       }
    }

    }
}
