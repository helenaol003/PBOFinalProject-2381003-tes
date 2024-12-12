package repositories;

import config.Database;
import entities.EventList;
import entities.PesertaList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PesertaRepositoryDbImpl implements PesertaRepository{
    private final Database database;

    public PesertaRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addPeserta(PesertaList peserta) {
        String sql = "INSERT INTO peserta(nama, nim, event_name) VALUES(?, ?, ?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, peserta.getNama());
            stmt.setString(2, peserta.getNim());
            stmt.setString(3, peserta.getEventpilih().getNameEvent());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Peserta successfully added!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removePeserta(PesertaList peserta) {
        String sql = "DELETE FROM peserta WHERE nim = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, peserta.getNim());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Peserta successfully removed!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PesertaList getPesertaByNim(String nim) {
        String sql = "SELECT * FROM peserta WHERE nim = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nim);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EventList event = new EventList(rs.getString("event_name"), "", "");
                return new PesertaList(rs.getString("nama"), rs.getString("nim"), event);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    @Override
//    public ArrayList<PesertaList> getPesertaByEvent(EventList event) {
//        ArrayList<PesertaList> pesertaByEvent = new ArrayList<>();
//        for (PesertaList peserta : Database.pesertaList) {
//            if (peserta.getEventpilih().equals(event)) { // Gunakan equals dari EventList
//                pesertaByEvent.add(peserta);
//            }
//        }
//        return pesertaByEvent;
//    }

    @Override
    public ArrayList<PesertaList> getAllPeserta() {
        String sql = "SELECT * FROM peserta";
        Connection conn = database.getConnection();
        ArrayList<PesertaList> pesertaList = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EventList event = new EventList(rs.getString("event_name"), "", "");
                pesertaList.add(new PesertaList(rs.getString("nama"), rs.getString("nim"), event));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pesertaList;
    }

    @Override
    public ArrayList<PesertaList> getPesertaByEvent(EventList event) {
        String sql = "SELECT * FROM peserta WHERE event_name = ?";
        Connection conn = database.getConnection();
        ArrayList<PesertaList> pesertaList = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, event.getNameEvent());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pesertaList.add(new PesertaList(
                        rs.getString("nama"),
                        rs.getString("nim"),
                        event
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pesertaList;
    }
}