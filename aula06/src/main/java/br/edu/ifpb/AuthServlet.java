package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.security.KeyStore.Entry;
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

import org.apache.taglibs.standard.tag.common.xml.IfTag;

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
            HashMap<String, Usuario> usuario = new HashMap<String, Usuario>( );
            Enumeration<String> paramNames = config.getInitParameterNames();
            

          
            while (paramNames.hasMoreElements()) {
            String chave = paramNames.nextElement();
            String value = config.getInitParameter(chave);
            usuario.put(chave, new Usuario(chave, value));
            }
            
            Usuario usarioencontrado = null;
            for (Map.Entry<String, Usuario> usuarios : usuario.entrySet()) {
                System.out.println(usuarios.getValue().getNome());
                if(usuarios.getValue().getNome().equalsIgnoreCase(name) && usuarios.getValue().getSenha().equalsIgnoreCase(senha)){
                    usarioencontrado = usuarios.getValue();
                }
                    
            }
            response.setContentType("text/html");
            if(usarioencontrado != null){                   
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Usuário " + usarioencontrado.getNome() + " autenticado!");
                out.println("</h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();
                } 
                else{
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Usuário ou senha não cadastrado!");
                out.println("</h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();    
                }
           }
}
