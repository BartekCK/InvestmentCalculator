package calculator.currency;

import calculator.user.SuperUser;


import java.util.ArrayList;
import java.util.List;

public interface ManageCurrency {
    void changeRate();
//    default void checkMoneyFame(List<SuperUser> superUserList){
//
//        List<ManageCurrency> list = new ArrayList<>();
//        for (SuperUser superUser : superUserList) {
//            list.addAll(superUser.getListCurrency());
//        }
//        list.forEach(System.out::println);
//
//    }
    double returnCurrentValue();
    String returnName();

}
