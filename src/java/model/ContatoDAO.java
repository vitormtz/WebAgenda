/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.conf.PropertyKey;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import model.Contato;

/**
 *
 * @author Vinicius
 */
public class ContatoDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties prop = new Properties();
            try (InputStream entrada = ContatoDAO.class.getResourceAsStream("/db.properties")) {
                if (entrada == null) {
                    throw new IOException("db.properties nao encontrado. "
                            + "Copie db.properties.example para db.properties e preencha os dados de conexao.");
                }
                prop.load(entrada);
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(prop.getProperty("db.url"),
                    prop.getProperty("db.user"), prop.getProperty("db.senha"));
        } catch (Exception e) {
            System.out.println(e);

        }
        return con;
    }

    public static int salvar(Contato u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into register(name,password,email,sex,country) values(?,?,?,?,?)");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSexo());
            ps.setString(5, u.getPais());
            status = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }
        return status;
    }

    public static int atualizar(Contato u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update register set name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSexo());
            ps.setString(5, u.getPais());
            ps.setInt(6, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int deletar(Contato u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from register where id=?");
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("STATUS  " + status);
        return status;
    }

    public static List<Contato> lerTudo() {
        List<Contato> list = new ArrayList<Contato>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contato u = new Contato();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("name"));
                u.setSenha(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSexo(rs.getString("sex"));
                u.setPais(rs.getString("country"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static Contato getContatoPorId(int id) {
        Contato u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Contato();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("name"));
                u.setSenha(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSexo(rs.getString("sex"));
                u.setPais(rs.getString("country"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
}
