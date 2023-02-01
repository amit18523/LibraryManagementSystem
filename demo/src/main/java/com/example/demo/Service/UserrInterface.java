package com.example.demo.Service;

import com.example.demo.Model.Userr;

import java.util.List;

public interface UserrInterface {
    Userr createUserr(Userr userr);
    Userr updateUserr(Userr userr);
    List<Userr> getAllUserr();
    Userr getUserrById(long id);

    void deleteUserr(long id);
}
