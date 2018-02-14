package com.group7.daveslist;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findById(long id);
}
