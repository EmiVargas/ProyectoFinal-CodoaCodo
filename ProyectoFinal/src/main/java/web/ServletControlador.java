package web;

import data.CelularesDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    eliminarCelular(req, res);
                    break;
                case "editar":
                    editarCelular(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String queryParam = req.getParameter("accion");
        if (queryParam != null) {
            switch (queryParam) {
                case "insertar":
                    insertarCelular(req, res);
                    break;
                case "modificar":
                    modificarCelular(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String motorola="Motorola";
        String samsung="Samsung";
        String iphone = "iPhone";
        String huawei = "Huawei";
        List<Tienda> celulares = new CelularesDAO().findAll();
        celulares.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("celulares", celulares);
        sesion.setAttribute("cantidadCelulares", calcularStock(celulares));
        sesion.setAttribute("precioTotal", calcularPrecio(celulares));
        sesion.setAttribute("cantidadMotorola", calcularMarca(celulares, motorola));
         sesion.setAttribute("cantidadSamsung", calcularMarca(celulares, samsung));
          sesion.setAttribute("cantidadIphone", calcularMarca(celulares, iphone));
          sesion.setAttribute("cantidadHuawei", calcularMarca(celulares, huawei));
        
//        req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("celulares.jsp");
    }

    private void insertarCelular(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        int memoria = Integer.parseInt(req.getParameter("memoria"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Tienda celular = new Tienda(modelo, marca, memoria, precio, stock);

        int registrosMod = new CelularesDAO().insert(celular);

        System.out.println("insertados = " + registrosMod);

        accionDefault(req, res);
    }

    private void eliminarCelular(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idcelular = Integer.parseInt(req.getParameter("idCelular"));

        int regMod = new CelularesDAO().deleteCelular(idcelular);

        System.out.println("SE ELIMINARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
    }

    private void editarCelular(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idCelular = Integer.parseInt(req.getParameter("idcelular"));
        Tienda celular = new CelularesDAO().findById(idCelular);
        req.setAttribute("celular", celular);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarCelular(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        int memoria = Integer.parseInt(req.getParameter("memoria"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        int idCelular = Integer.parseInt(req.getParameter("idCelular"));

        Tienda tienda = new Tienda(idCelular, modelo, marca, memoria, precio, stock);

        int regMod = new CelularesDAO().update(tienda);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
    }

    private int calcularStock(List<Tienda> cel) {
        int cant = 0;
        for (int i = 0; i < cel.size(); i++) {
            cant += cel.get(i).getStock();
        }
        return cant;
    }

    private double calcularPrecio(List<Tienda> cel) {
        double precio = 0;
        for (int i = 0; i < cel.size(); i++) {
            precio += (cel.get(i).getPrecio() * cel.get(i).getStock());
        }
        return precio;
    }


private int calcularMarca(List<Tienda> cel, String marca){
int cont=0;
        for (int i = 0; i < cel.size(); i++) {
            if(cel.get(i).getMarca().equals(marca)){
cont += 1;
}
        }
        return cont;
    }
}