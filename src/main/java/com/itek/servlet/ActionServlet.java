package com.itek.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itek.domain.Area;
import com.itek.domain.City;
import com.itek.domain.Province;
import com.itek.util.DBUtil;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/ajax1/province.do")) {
            // 查询province表中
            Connection conn = DBUtil.getPoolConnection();
            List<Province> provinces = new ArrayList<>();
            String sql = "select name, code from province";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    provinces.add(new Province(rs.getString(1), rs.getString(2)));
                }
                response.setContentType("text/html;charset=utf-8");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.closeConnection(conn);
            }
            response.getWriter().print(JSONArray.fromObject(provinces));

        } else if (uri.equals("/ajax1/city.do")) {
            // 接收省份的编号
            String code = request.getParameter("code");

            // 查询province表中所有的数据
            Connection conn = DBUtil.getPoolConnection();
            List<City> cities = new ArrayList<>();

            String sql = "select name, code, provincecode from city where provincecode = ?";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, code);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    cities.add(new City(rs.getString(1), rs.getString(2), rs.getString(3)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.closeConnection(conn);
            }
            response.getWriter().print(JSONArray.fromObject(cities).toString());

        } else if (uri.equals("/ajax1/area.do")) {

            // 接收省份的编号
            String code = request.getParameter("code");

            // 查询province表中所有的数据
            Connection conn = DBUtil.getPoolConnection();
            List<Area> areas = new ArrayList<>();

            String sql = "select name, code,citycode from area where citycode = ?";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, code);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    areas.add(new Area(rs.getString(1), rs.getString(2), rs.getString(3)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.closeConnection(conn);
            }
            response.getWriter().print(JSONArray.fromObject(areas).toString());

        }
    }

}
