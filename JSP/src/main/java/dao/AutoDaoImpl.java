package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AutoDaoImpl {
    public List<Auto> findAll() {
        List<Auto> autos = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("Auto.txt"))) {

            String auto_string;
            while ((auto_string = reader.readLine())!=null) {
                Auto newAuto = new Auto(auto_string.substring(0, auto_string.indexOf(' ')));
                autos.add(newAuto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return autos;
    }
}
