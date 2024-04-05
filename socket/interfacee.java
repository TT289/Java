package socket;

import java.io.IOException;

public interface interfacee {
    void connect() throws IOException;
    void startCommunication() throws IOException;
    void close() throws IOException;
}

