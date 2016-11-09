package Services;

import Models.Queue;

public interface QueueService {

    void save(String userName, Queue queue);

    Queue givePromotions(Queue queue);

    boolean checkRecorded(String userName);

    int findId(String userName);

    String findInfo(String userName);

    String findPromotions(String userName);
}
