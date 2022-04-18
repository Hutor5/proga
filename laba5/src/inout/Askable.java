package inout;

import exceptions.WrongDataException;

public interface Askable<T>{
    T ask() throws WrongDataException;
}

