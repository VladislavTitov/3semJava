package Services;

import Dao.QueueDao;
import Dao.UserDao;
import Factories.DaoFactory;
import Models.Queue;

public class QueueServiceImpl implements QueueService {
    @Override
    public void save(String userName, Queue queue) {

        QueueDao queueDao = DaoFactory.getInstance().getQueueDao();

        int fatherId = queueDao.saveFather(queue.getHousing().getFamily().getFather());

        int motherId = queueDao.saveMother(queue.getHousing().getFamily().getMother());

        int[] childrenId = queueDao.saveChildren(queue.getHousing().getFamily().getChildren(), fatherId, motherId);

        int familyId = queueDao.saveFamily(fatherId, motherId);

        int wishesId = queueDao.saveWishes(queue.getHousing().getWishes());

        int housingId = queueDao.saveHousing(queue.getHousing(), familyId, wishesId);

        int queueId = queueDao.saveQueue(queue, familyId, housingId);

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        userDao.addQueueToUser(userName, queueId);
    }

    @Override
    public Queue givePromotions(Queue queue) {
        Queue.Builder builder = new Queue.Builder();
        builder.setHousing(queue.getHousing());

        if (queue.getHousing().getCondition() == 0){
            builder.setOutOfQueue(true)
                    .setFirstOfQueue(false);

        }else if (queue.getHousing().getCondition() == 1 || queue.getHousing().getCondition() == 2){
            builder.setOutOfQueue(false)
                    .setFirstOfQueue(true);
        }else {
            builder.setOutOfQueue(false)
                    .setFirstOfQueue(false);
        }
        if (queue.getHousing().getFamily().getChildren().size() != 0 && queue.getHousing().getFamily().getChildren().size() >= 3){
            builder.setPromotions(true);
        }else{
            builder.setPromotions(false);
        }
        return builder.build();
    }

    @Override
    public boolean checkRecorded(String userName) {
        QueueDao queueDao = DaoFactory.getInstance().getQueueDao();
        return queueDao.queueExist(userName);
    }

    @Override
    public int findId(String userName) {
        QueueDao queueDao = DaoFactory.getInstance().getQueueDao();
        return queueDao.findId(userName);
    }

    @Override
    public String findInfo(String userName) {
        return null;
    }

    @Override
    public String findPromotions(String userName) {
        return null;
    }
}
