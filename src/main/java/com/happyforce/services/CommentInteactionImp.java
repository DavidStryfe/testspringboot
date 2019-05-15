package com.happyforce.services;

import com.happyforce.objetos.CommentInteraction;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class CommentInteactionImp implements CommentInteractionInt{

    @Override
    public int getCommentLikes(int idComment) {
        int numLikes = 0;
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
            String selectSQL = "SELECT COUNT(*) as contador FROM commentlike WHERE comment = "
                    + idComment + " AND kind = 'like'";
            PreparedStatement stmt = (PreparedStatement) conexion
                    .prepareStatement(selectSQL);
            ResultSet rs = (ResultSet) stmt.executeQuery(selectSQL);
            while (rs.next()) {
                numLikes = rs.getInt("contador");
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conexion = null;
        }

        return numLikes;
    }

    @Override
    public int getCommentDislikes(int idComment) {
        int numDislikes = 0;
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
            String selectSQL = "SELECT COUNT(*) as contador FROM commentlike WHERE comment = "
                    + idComment + " AND kind = 'dislike'";
            PreparedStatement stmt = (PreparedStatement) conexion
                    .prepareStatement(selectSQL);
            ResultSet rs = (ResultSet) stmt.executeQuery(selectSQL);
            while (rs.next()) {
                numDislikes = rs.getInt("contador");
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conexion = null;
        }

        return numDislikes;
    }

    @Override
    public boolean updateCommentInteractions(CommentInteraction like) {
        return false;
    }
}
