import javax.security.auth.Destroyable;

public class Plant {
    public void doDestroy(IDestroyable d) {
        d.destroyed();
    }
}
