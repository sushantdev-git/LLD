
package cache.policies;

public interface EvictionPolicy<Type> {

    public void keyAccessed(Type k);

    public Type evictKey();
}