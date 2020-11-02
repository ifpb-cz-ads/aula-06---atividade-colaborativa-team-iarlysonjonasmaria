package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
urlPatterns  = {"/Auth"},
initParams = {
    @WebInitParam(name = "Jose", value = "jose12"),
    @WebInitParam(name = "Maria", value = "maria12"),
    @WebInitParam(name = "Joao", value = "joao12"),
    @WebInitParam(name = "Laura", value = "laura12"),
}
)
public class AuthServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            PrintWriter out = response.getWriter();

            String name = request.getParameter("name");
            String senha = request.getParameter("senha");

            ServletConfig config = this.getServletConfig();
            HashMap<Usuario, Usuario> usuario = new HashMap<Usuario, Usuario>( );
            Enumeration<String> paramNames = config.getInitParameterNames();
            

          
            while (paramNames.hasMoreElements()) {
            String nome = paramNames.nextElement();
            String value = config.getInitParameter(nome);
            usuario.put( new Usuario(nome, config.getInitParameter(nome)), 
            new Usuario(senha, config.getInitParameter(value)) );
        }
           
            out.println(usuario);
            
        }
}

