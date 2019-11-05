package model;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WardrobeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StyleManager styleManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertClothesItem(request, response);
                break;
            case "/delete":
                deleteClothesItem(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateClothesItem(request, response);
                break;
            default:
                listClothesItem(request, response);
                break;
        }
    }

    private void listClothesItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ClothesItem> listClothesItem = styleManager.listAllClothesItem();
        request.setAttribute("listClothesItem", listClothesItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClothsList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClothsForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ClothesItem existingClothesItem = styleManager.getclothesItems(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClothsForm.jsp");
        request.setAttribute("clothesItem", existingClothesItem);
        dispatcher.forward(request, response);

    }

    private void insertClothesItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        float price = Float.parseFloat(request.getParameter("price"));
        String type = request.getParameter("type");


        ClothesItem newClothesItem = new ClothesItem(++StyleManager.ID_COUNT, color, price,name, Type.valueOf(type));
        styleManager.insertClothesItem(newClothesItem);
        response.sendRedirect("list");
    }

    private void updateClothesItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        float price = Float.parseFloat(request.getParameter("price"));
        String type = request.getParameter("type");
        ClothesItem newClothesItem = new ClothesItem(id, color, price,name, Type.valueOf(type));


        styleManager.updateClothesItem(newClothesItem);
        response.sendRedirect("list");
    }

    private void deleteClothesItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        styleManager.deleteClothesItem(id);
        response.sendRedirect("list");

    }
}
