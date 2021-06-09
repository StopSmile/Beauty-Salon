package service;

import db.DBConnect;
import entity.Order;
import entity.OrdersForMaster;
import entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class OrderService extends DBConnect {
    Connection connection = getConnection();
    private static final String INSERT_ORDER = "INSERT INTO public.order (id,clientid, masterid, timeslotid,date, serviceid, orderstatusid) VALUES (DEFAULT,?,?,?,?,?,?);";
    private static final String SELECT_ORDERS_BY_MASTER_AND_STATUS = "select * from public.order where masterid = ? and orderstatusid = ?;";
    private static final String SELECT_ORDERS_FOR_MASTER = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername,u1.firstname as mastername, u1.lastname as masterlastname " +
            "from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid where masterid = ? and o.orderstatusid = 1;";

    private static final String SELECT_ORDERS_BY_ORDER_ID = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername, " +
            "u1.firstname as mastername, u1.lastname as masterlastname from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid where o.id = ?;";


    private static final String SELECT_ALL_ORDERS = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername, " +
            "u1.firstname as mastername, u1.lastname as masterlastname from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid order by o.date DESC";


    private static final String SELECT_ALL_ORDERS_WHERE_STATUS_ACTIVE = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername, " +
            "u1.firstname as mastername, u1.lastname as masterlastname from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid where os.id = 1;";

    private static final String SELECT_ALL_ORDERS_WHERE_STATUS_DONE = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername, " +
            "u1.firstname as mastername, u1.lastname as masterlastname from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid where os.id = 3;";

    private static final String UPDATE_ORDER_STATUS = "UPDATE public.order SET orderstatusid = ? where public.order.id = ?;";


    private static final String UPDATE_ORDER_TIMESLOT_BY_ID = "UPDATE public.order SET timeslotid = ?, date = ? WHERE id = ?;";


    private static final String SELECT_ALL_ORDERS_PAGINATIONS = "select o.id,o.masterid,o.date,u.firstname,u.lastname,s.name as servicename,ts.timestart,ts.timeend,os.ordername, " +
            "u1.firstname as mastername, u1.lastname as masterlastname from public.order o inner join users u on u.id = o.clientid inner join services s on s.id = o.serviceid inner join " +
            "public.timeslots ts on ts.id = o.timeslotid inner join public.orderstatus os on os.id = o.orderstatusid inner join users u1 on u1.id = o.masterid order by o.date DESC limit ? offset ?";


    public void addOrder(Order order) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(INSERT_ORDER);
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getMasterId());
            ps.setInt(3, order.getTimeSlotId());
            ps.setDate(4, order.getDate());
            ps.setInt(5, order.getServiceId());
            ps.setInt(6, order.getOrderStatusId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
        }
    }

    public void upDateOrderStatus(int orderId, int orderStatusId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_ORDER_STATUS);
            ps.setInt(1, orderStatusId);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
        }

    }

    public void updateOrderTimeslotById(int orderId, int timeSlotId, Date date) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_ORDER_TIMESLOT_BY_ID);
            ps.setInt(1, timeSlotId);
            ps.setDate(2, date);
            ps.setInt(3, orderId);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
        }
    }

    public ArrayList<Order> getOrdersByMasterAndActiveStatus(int masterid, int status) throws SQLException, IOException {
        ArrayList<Order> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_ORDERS_BY_MASTER_AND_STATUS);
            ps.setInt(1, masterid);
            ps.setInt(2, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setClientId(rs.getInt("clientid"));
                order.setMasterId(rs.getInt("masterid"));
                order.setTimeSlotId(rs.getInt("timeslotid"));
                order.setDate(rs.getDate("date"));
                order.setServiceId(rs.getInt("serviceid"));
                order.setOrderStatusId(rs.getInt("orderstatusid"));
                list.add(order);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }

    public ArrayList<OrdersForMaster> getOrdersForMaster(int masterid) throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_ORDERS_FOR_MASTER);
            ps.setInt(1, masterid);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterLastName(rs.getString("mastername"));
                ordersForMaster.setMasterFirstName("masterlastname");
                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }

    public ArrayList<OrdersForMaster> getOrdersByOrderId(int orderId) throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_ORDERS_BY_ORDER_ID);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterFirstName(rs.getString("mastername"));
                ordersForMaster.setMasterLastName(rs.getString("masterlastname"));
                ordersForMaster.setMasterId(rs.getInt("masterid"));

                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }

    public ArrayList<OrdersForMaster> getAllActiveOrders() throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        Statement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.createStatement();
            rs = ps.executeQuery(SELECT_ALL_ORDERS_WHERE_STATUS_ACTIVE);
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterFirstName(rs.getString("mastername"));
                ordersForMaster.setMasterLastName(rs.getString("masterlastname"));
                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }

    public ArrayList<OrdersForMaster> getAllDoneOrders() throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        Statement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.createStatement();
            rs = ps.executeQuery(SELECT_ALL_ORDERS_WHERE_STATUS_DONE);
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterFirstName(rs.getString("mastername"));
                ordersForMaster.setMasterLastName(rs.getString("masterlastname"));
                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }

    public ArrayList<OrdersForMaster> getAllOrders() throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        Statement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.createStatement();
            rs = ps.executeQuery(SELECT_ALL_ORDERS);
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterFirstName(rs.getString("mastername"));
                ordersForMaster.setMasterLastName(rs.getString("masterlastname"));
                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }
    public ArrayList<OrdersForMaster> getAllOrdersForPagination(int limit,int offset) throws SQLException, IOException {
        ArrayList<OrdersForMaster> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_ALL_ORDERS_PAGINATIONS);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdersForMaster ordersForMaster = new OrdersForMaster();
                ordersForMaster.setId(rs.getInt("id"));
                ordersForMaster.setDate(rs.getDate("date"));
                ordersForMaster.setFirstName(rs.getString("firstname"));
                ordersForMaster.setLastName(rs.getString("lastname"));
                ordersForMaster.setServiceName(rs.getString("servicename"));
                ordersForMaster.setTimeStart(rs.getTime("timestart"));
                ordersForMaster.setTimeEnd(rs.getTime("timeend"));
                ordersForMaster.setOrderName(rs.getString("ordername"));
                ordersForMaster.setMasterFirstName(rs.getString("mastername"));
                ordersForMaster.setMasterLastName(rs.getString("masterlastname"));
                ordersForMaster.setMasterId(rs.getInt("masterid"));
                list.add(ordersForMaster);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }
}
