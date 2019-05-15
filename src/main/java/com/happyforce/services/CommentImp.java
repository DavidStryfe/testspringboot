package com.happyforce.services;

import com.happyforce.objetos.Comment;
import com.happyforce.objetos.CommentInteraction;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommentImp implements  CommentInt {

    @Override
    public List<Comment> listaComentarios() {
        List<Comment> listaComentarios = new LinkedList<>();
        //Connection conexion = conexionDao.crearConexion();

        Connection conexion = null;

        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://195.55.99.47:3306/hf", "root",
                        "JoinSP1415.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            String selectSQL = "SELECT * FROM hf.comment";
            PreparedStatement stmt = (PreparedStatement) conexion
                    .prepareStatement(selectSQL);
            ResultSet rs = (ResultSet) stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int idComment = rs.getInt("idcomment");
                String text = rs.getString("text");
                String user = rs.getString("user");
                java.sql.Timestamp date = rs.getTimestamp("date");


                Comment comentario = new Comment(idComment, text, user, date);

                listaComentarios.add(comentario);
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //conexionDao.cerrarConexion(conexion);
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conexion = null;
        }

        return listaComentarios;

    }

    @Override
    public boolean insertComment(Comment comentario) {
        return false;
    }
}
