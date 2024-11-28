package fr.efrei.repository;

import fr.efrei.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistRepository implements IReceptionistRepository {
    private static IReceptionistRepository repository = null;
    private List<Receptionist> receptionistList;
    private ReceptionistRepository(){
        receptionistList = new ArrayList<>();
    }

    @Override
    public Receptionist create(Receptionist r) {
        boolean success = receptionistList.add(r);
        if (success)
            return r;
        return null;
    }

    @Override
    public Receptionist read(Integer id) {
        for (Receptionist receptionist : receptionistList) {
            if (receptionist.getEmployeeId() == id)
                return receptionist;
        }
        return null;
    }

    @Override
    public Receptionist update(Receptionist r) {
        int id = r.getEmployeeId();
        Receptionist oldReceptionist = read(id);
        if (oldReceptionist == null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (receptionistList.add(r))
                return r;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Receptionist receptionistToDelete = read(id);
        if (receptionistToDelete == null)
            return false;
        return receptionistList.remove(receptionistToDelete);
    }

    @Override
    public List<Receptionist> getAll() {
        return receptionistList;
    }
}
