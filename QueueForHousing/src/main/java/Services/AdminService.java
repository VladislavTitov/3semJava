package Services;

import Models.FullModel;

public interface AdminService {

    /**
     * возращает пользователей с параметрами, которые еще стоят в очереди
     */
    FullModel getNormalQueue();

    /**
     * возращает пользователей с параметрами, которые уже не стоят в очереди
     */
    FullModel getDeletedQueue();


    void deleteFromNormalQueue(String userName);

    void deleteFromDeletedQueue(String userName);

}
