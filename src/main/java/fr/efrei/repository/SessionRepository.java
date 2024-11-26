package fr.efrei.repository;

import fr.efrei.domain.Session;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository implements ISessionRepository {
    private static ISessionRepository repository = null;
    private List<Session> sessionList;

    private SessionRepository() {
        sessionList = new ArrayList<>();
    }

    public static ISessionRepository getRepository() {
        if (repository == null) {
            repository = new SessionRepository();
        }
        return repository;
    }

    @Override
    public Session create(Session s) {
        boolean success = sessionList.add(s);
        if (success)
            return s;
        return null;
    }

    @Override
    public Session read(Integer id) {
        for (Session session: sessionList) {
            if (session.getSessionID() == id)
                return session;
        }
        return null;
    }

    @Override
    public Session update(Session s) {
        int id = s.getSessionID();
        Session oldSession = read(id);
        if (oldSession == null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (sessionList.add(s))
                return s;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Session sessionToDelete = read(id);
        if (sessionToDelete == null)
            return false;
        return sessionList.remove(sessionToDelete);
    }

    @Override
    public List<Session> getAll() {
        return sessionList;
    }
}
