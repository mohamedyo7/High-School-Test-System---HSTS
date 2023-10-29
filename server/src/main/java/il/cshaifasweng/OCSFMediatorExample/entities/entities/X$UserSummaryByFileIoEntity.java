package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$user_summary_by_file_io", schema = "sys", catalog = "")
public class X$UserSummaryByFileIoEntity {
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "ios")
    private Long ios;
    @Basic
    @Column(name = "io_latency")
    private Long ioLatency;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getIos() {
        return ios;
    }

    public void setIos(Long ios) {
        this.ios = ios;
    }

    public Long getIoLatency() {
        return ioLatency;
    }

    public void setIoLatency(Long ioLatency) {
        this.ioLatency = ioLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$UserSummaryByFileIoEntity that = (X$UserSummaryByFileIoEntity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (ios != null ? !ios.equals(that.ios) : that.ios != null) return false;
        if (ioLatency != null ? !ioLatency.equals(that.ioLatency) : that.ioLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (ios != null ? ios.hashCode() : 0);
        result = 31 * result + (ioLatency != null ? ioLatency.hashCode() : 0);
        return result;
    }
}
