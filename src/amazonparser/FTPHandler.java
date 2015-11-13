/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazonparser;

import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import com.enterprisedt.net.ftp.FileTransferClient;
import java.io.OutputStream;

/**
 *
 * @author Sh1fT
 */

public final class FTPHandler {
    protected FileTransferClient fileTransferClient;
    protected String host;
    protected Integer port;
    protected String username;
    protected String password;
    protected Boolean binary;

    /**
     * Creates new instance FTPHandler
     * @param host
     * @param port
     * @param username
     * @param password
     * @param binary 
     */
    public FTPHandler(String host, Integer port, String username, String password,
        Boolean binary) {
        this.setFileTransferClient(new FileTransferClient());
        this.setHost(host);
        this.setPort(port);
        this.setUsername(username);
        this.setPassword(password);
        this.setBinary(binary);
    }

    public FileTransferClient getFileTransferClient() {
        return this.fileTransferClient;
    }

    protected void setFileTransferClient(FileTransferClient fileTransferClient) {
        this.fileTransferClient = fileTransferClient;
    }

    public String getHost() {
        return this.host;
    }

    protected void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return this.port;
    }

    protected void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return this.username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBinary() {
        return this.binary;
    }

    protected void setBinary(Boolean binary) {
        this.binary = binary;
    }

    /**
     * Connect To The FTP Server
     */
    public void connect() {
        try {
            this.getFileTransferClient().setRemoteHost(this.getHost());
            this.getFileTransferClient().setRemotePort(this.getPort());
            this.getFileTransferClient().setUserName(this.getUsername());
            this.getFileTransferClient().setPassword(this.getPassword());
            if (this.getBinary())
                this.getFileTransferClient().setContentType(FTPTransferType.BINARY);
            this.getFileTransferClient().connect();
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Disconnect From The Server
     * @param immediate 
     */
    public void disconnect(Boolean immediate) {
        try {
            this.getFileTransferClient().disconnect(immediate);
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Disconnect From The Server
     */
    public void disconnect() {
        this.disconnect(false);
    }

    /**
     * Create A New Directory
     * @param directory 
     */
    public void createDirectory(String directory) {
        try {
            this.getFileTransferClient().createDirectory(directory);
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Change To A New Working Directory On The FTP Server
     * @param directory 
     */
    public void setDirectory(String directory) {
        try {
            this.getFileTransferClient().changeDirectory(directory);
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Upload A File To The FTP Server 
     * @param file 
     */
    public void upload(File file) {
        try {
            this.getFileTransferClient().uploadFile(file.getAbsolutePath(), file.getName());
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Upload An InputStream To The FTP Server 
     * @param stream
     * @param filename 
     */
    public void upload(InputStream stream, String filename) {
        try {
            try (OutputStream out = this.getFileTransferClient().uploadStream(filename)) {
                byte[] buffer = new byte[1024];
                int len = stream.read(buffer);
                while (len != -1) {
                    out.write(buffer, 0, len);
                    len = stream.read(buffer);
                }
            }
        } catch (FTPException | IOException ex) {
            System.out.println("Aïe Aïe Aïe !\n" + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
}