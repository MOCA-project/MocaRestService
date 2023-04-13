package moca.MocaRestService.Domain.Helper.Iterator;

public interface Iterador<T> {
    boolean hasNext();
    T next();
}
