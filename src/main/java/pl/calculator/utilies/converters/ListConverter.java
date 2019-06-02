package pl.calculator.utilies.converters;

import javafx.collections.ObservableList;

import java.util.List;

public interface ListConverter<T,I,N> {
    ObservableList<N> returnFxObject(List<T> list, I converter);
}