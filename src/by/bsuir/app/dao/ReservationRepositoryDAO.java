package by.bsuir.app.dao;

import by.bsuir.code.lab4.entity.Reservation;

import java.util.List;

public interface ReservationRepositoryDAO {
    void add(Reservation reservation);
    List<Reservation> getReservationsByUserId(int userId);
}
