package haythem.hd.retrofit.data.repository;

import java.util.ArrayList;

/**
 * Created by Haythem on 17/11/2017.
 */

public interface IResponse<T> {

    void reponseSuccess(ArrayList<T> objects);

    void responseFail(Throwable t);
}
