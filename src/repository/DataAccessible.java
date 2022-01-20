package repository;

import entity.Student;

import java.io.*;

public interface DataAccessible<T,K > {


    public boolean save(T type) ;

    public boolean deleteAll() ;

    public T[] getAll();

    public T getById(K id);

}
