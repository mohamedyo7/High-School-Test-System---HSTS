package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "host_summary_by_file_io", schema = "sys", catalog = "")
public class HostSummaryByFileIoEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "ios")
    private Long ios;
    @Basic
    @Column(name = "io_latency")
    private String ioLatency;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getIos() {
        return ios;
    }

    public void setIos(Long ios) {
        this.ios = ios;
    }

    public String getIoLatency() {
        return ioLatency;
    }

    public void setIoLatency(String ioLatency) {
        this.ioLatency = ioLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostSummaryByFileIoEntity that = (HostSummaryByFileIoEntity) o;

        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (ios != null ? !ios.equals(that.ios) : that.ios != null) return false;
        if (ioLatency != null ? !ioLatency.equals(that.ioLatency) : that.ioLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (ios != null ? ios.hashCode() : 0);
        result = 31 * result + (ioLatency != null ? ioLatency.hashCode() : 0);
        return result;
    }
}
