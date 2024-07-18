package ec.nttdata.challenge.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<T, K> {

    @Autowired
    private K dao;

    public T save(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        handleSave(t);
        return (T) dao.getClass().getMethod("save", Object.class).invoke(dao, t);
    }

    public T read(String id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Optional optional = (Optional) dao.getClass().getMethod("findById", Object.class).invoke(dao, id);
        return (T) optional.get();
    }

    public List<T> readAll() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (List<T>) dao.getClass().getMethod("findAll").invoke(dao);
    }

    public void delete(String id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        handleDelete(id);
        dao.getClass().getMethod("deleteById", Object.class).invoke(dao, id);
    }

    public T handleSave(T t) {
        return t;
    };
//    public abstract void handleDelete(String id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}