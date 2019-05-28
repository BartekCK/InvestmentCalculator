package calculator.utilies.converters;

import javafx.collections.ObservableList;

public interface ListConverter<T,I,N> {

    ObservableList<N> returnFxObject(ObservableList<T> list, I converter);
}
