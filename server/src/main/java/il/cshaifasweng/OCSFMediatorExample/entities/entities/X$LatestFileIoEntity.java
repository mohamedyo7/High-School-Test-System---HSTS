package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$latest_file_io", schema = "sys", catalog = "")
public class X$LatestFileIoEntity {
    @Basic
    @Column(name = "thread")
    private String thread;
    @Basic
    @Column(name = "file")
    private String file;
    @Basic
    @Column(name = "latency")
    private Object latency;
    @Basic
    @Column(name = "operation")
    private String operation;
    @Basic
    @Column(name = "requested")
    private Long requested;

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Object getLatency() {
        return latency;
    }

    public void setLatency(Object latency) {
        this.latency = latency;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getRequested() {
        return requested;
    }

    public void setRequested(Long requested) {
        this.requested = requested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$LatestFileIoEntity that = (X$LatestFileIoEntity) o;

        if (thread != null ? !thread.equals(that.thread) : that.thread != null) return false;
        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (latency != null ? !latency.equals(that.latency) : that.latency != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (requested != null ? !requested.equals(that.requested) : that.requested != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = thread != null ? thread.hashCode() : 0;
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (latency != null ? latency.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (requested != null ? requested.hashCode() : 0);
        return result;
    }
}
