package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Auth")
public class AuthServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            PrintWriter out = response.getWriter();

            String name = request.getParameter("name");
            String senha = request.getParameter("senha");

            HashMap<String, String> usuario = new HashMap<String, String>( );
            usuario.put("maria", "123maria");
            usuario.put("pedro", "456pedro");
            usuario.put("laura", "122laura");

           out.println(usuario);

            
            
        }
}

