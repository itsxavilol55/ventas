import java.io.IOException;
import java.io.ObjectOutputStream;
public class MyOOS extends ObjectOutputStream {
    public MyOOS(java.io.OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}