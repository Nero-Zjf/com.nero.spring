import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

public class ResourcePOJO {

    private Resource res;

    public Resource getRes() {
        return res;
    }

    public void setRes(Resource res) {
        this.res = res;
    }
}
