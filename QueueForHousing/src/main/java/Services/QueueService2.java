package Services;

import Models.Child;
import Models.Model;
import Models.ModelsEnum;

public interface QueueService2 {

    /**
     * проверяет существование записи заданной модели для определенного пользователя
     * в случае детей проверят существует по крайней мере один ребенок в таблице Children
     * @param userName имя пользователя
     * @param mode зназвание модели (из enum)
     * @return существует или нет
     */
    boolean checkRecorded(String userName, ModelsEnum mode);

    /**
     * проверяет сущуствование заданного ребенка для определенного пользователя
     * @param userName имя пользователя
     * @param child модель ребенка
     * @return существует или нет
     */
    boolean checkRecordedChild(String userName, Child child);

    /**
     * сохраняет модель для заданного пользователя
     * @param userName имя пользователя
     * @param model реализация интерфейса Model
     */
    void save(String userName, Model model);

    /**
     * обновляет данные заданной модели для заданного пользователя
     * @param userName имя пользователя
     * @param model реализация интерфейса Model
     */
    void update(String userName, Model model);

    /**
     * удаляет заданную модель для определенного пользователя
     * в случае детей удаляет всех сразу
     * @param userName имя пользователя
     * @param mode название модели (из enum)
     */
    void delete(String userName, ModelsEnum mode);

    void deleteChild(String userName, Child child);

}
