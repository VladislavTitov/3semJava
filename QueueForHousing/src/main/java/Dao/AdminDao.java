package Dao;

import Models.FullModel;

import java.util.List;

public interface AdminDao {

    List<FullModel> getNormalQueueWithPromotions();

    List<FullModel> getNormalFirstOfQueue();

    List<FullModel> getNormalOutOfQueue();


    List<FullModel> getDeletedQueueWithPromotions();

    List<FullModel> getDeletedFirstOfQueue();

    List<FullModel> getDeletedOutOfQueue();

    void deleteFromNormalQueue(String userName);

    void deleteFromDeletedQueue(String userName);

}
