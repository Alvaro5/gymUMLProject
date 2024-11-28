package fr.efrei.repository;

import fr.efrei.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository implements ICoachRepository {
    private static ICoachRepository repository = null;
    private List<Coach> coachList;
    private CoachRepository(){
        coachList = new ArrayList<>();
    }

    @Override
    public Coach create(Coach c) {
        boolean success = coachList.add(c);
        if (success)
            return c;
        return null;
    }

    @Override
    public Coach read(Integer id) {
        for (Coach coach : coachList) {
            if (coach.getEmployeeId() == id)
                return coach;
        }
        return null;
    }

    @Override
    public Coach update(Coach c) {
        int id = c.getEmployeeId();
        Coach oldCoach = read(id);
        if (oldCoach == null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (coachList.add(c))
                return c;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Coach coachToDelete = read(id);
        if (coachToDelete == null)
            return false;
        return coachList.remove(coachToDelete);
    }

    @Override
    public List<Coach> getAll() {
        return coachList;
    }
}

