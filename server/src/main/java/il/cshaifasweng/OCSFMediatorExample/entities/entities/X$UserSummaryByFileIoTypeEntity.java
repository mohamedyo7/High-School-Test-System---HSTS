package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$user_summary_by_file_io_type", schema = "sys", catalog = "")
public class X$UserSummaryByFileIoTypeEntity {
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "latency")
    private Object latency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public Object getLatency() {
        return latency;
    }

    public void setLatency(Object latency) {
        this.latency = latency;
    }

    public Object getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Object maxLatency) {
        this.maxLatency = maxLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$UserSummaryByFileIoTypeEntity that = (X$UserSummaryByFileIoTypeEntity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (latency != null ? !latency.equals(that.latency) : that.latency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (latency != null ? latency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        return result;
    }
}
