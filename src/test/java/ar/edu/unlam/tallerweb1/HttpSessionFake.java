package ar.edu.unlam.tallerweb1;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpSessionFake implements HttpSession {
    private Map<String, Object> map;

    public HttpSessionFake() {
        this.map = new HashMap<>();
    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return getValue(name);
    }

    @Override
    public Object getValue(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }

        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return map.keySet().toArray(new String[0]);
    }

    @Override
    @Deprecated
    public void setAttribute(String name, Object value) {
        putValue(name, value);
    }

    @Override
    public void putValue(String name, Object value) {
        map.put(name, value);
    }

    @Override
    @Deprecated
    public void removeAttribute(String name) {
        removeValue(name);
    }

    @Override
    public void removeValue(String name) {
        map.remove(name);
    }

    @Override
    public void invalidate() {
        map.clear();
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
